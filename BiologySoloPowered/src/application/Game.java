package application;

import java.util.ArrayList;
import java.util.Random;

import gameObjects.Cell;
import gameObjects.Cloud;
import gameObjects.Earth;
import gameObjects.Ground;
import gameObjects.Helium;
import gameObjects.Hydrogen;
import gameObjects.Person;
import gameObjects.Photon;
import gameObjects.Plant;
import gameObjects.Rain;
import gameObjects.Sun;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import utils.Camera;

public class Game {

	private Random gen = new Random();
	private ArrayList<Photon> photonList = new ArrayList<>();
	private ArrayList<Rain> rainList = new ArrayList<>();

	private Sun sun = new Sun(ImageLoader.sun1, 100, 100);
	private ArrayList<Hydrogen> hydrogenList = new ArrayList<>();
	private ArrayList<Helium> heliumList = new ArrayList<>();
	private int state = 0;
	private double heliumPhotonSpawnTime = 0;
	private Camera camera;
	private Earth earth = new Earth(ImageLoader.earth1, sun.getCenterX() - 50, 1900);
	private Ground ground = new Ground(ImageLoader.ground, -395, (2100 + Main.WINDOW_HEIGHT / 2));
	private Cloud cloud = new Cloud(ImageLoader.cloud, 1900, 200);
	private int callCloud = 0;
	private int callRain = 0;
	private int callPuddle = 0;
	private double startTime = 0;
	private int puddleSize = 0;
	private int callPlant = 0;
	private int callPerson = 0;
	private Person person = new Person(ImageLoader.face1,800,2000);
	private Plant plant = new Plant(ImageLoader.plant,450,1800+Main.WINDOW_HEIGHT/2);
	private int callCells = 0;
	private Cell humanCell = new Cell(ImageLoader.humanCell,1200,1700);
	private Cell plantCell = new Cell(ImageLoader.plantCell,plant.getX()-100,plant.getY()-600);

	/**
	 * Game Constructor
	 */
	public Game() {

	}

	/**
	 * Initialize game objects
	 */
	public void init() {
		sun.init();
		earth.init();
		camera = new Camera((sun.getBounds().getMinX() - (Main.WINDOW_WIDTH / 3)),
				sun.getBounds().getMinY() - (Main.WINDOW_HEIGHT / 3));

		for (int i = 0; i < 6; i++) {
			double x = 0;
			double y = 0;

			while (x < sun.getBounds().getMinX() || x > (sun.getBounds().getMaxX() - 75)) {
				x = gen.nextInt(2000);
			}
			while (y < sun.getBounds().getMinY() || y > (sun.getBounds().getMaxY() - 100)) {
				y = gen.nextInt(2000);
			}

			double velX = 0;
			double velY = 0;
			if (gen.nextDouble() > .5) {
				velX = 3;
			} else {
				velX = -3;
			}

			if (gen.nextDouble() > .5) {
				velY = 3;
			} else {
				velY = -3;
			}

			hydrogenList.add(new Hydrogen(ImageLoader.hydrogen, x, y, velX, velY));
		}

	}

	/**
	 * update game objects
	 * 
	 * @param timer
	 */
	public void update(double timer) {
		for (Hydrogen h : hydrogenList) {
			h.update(timer);
			h.move(sun);

		}

		if ((timer - heliumPhotonSpawnTime) > 2 && heliumList.size() < 5) {
			heliumList.add(new Helium(ImageLoader.helium,
					sun.getBounds().getMinX() + gen.nextInt((int) (sun.getBounds().getMaxX() - 200)),
					sun.getBounds().getMinY() + gen.nextInt((int) (sun.getBounds().getMaxY() - 300))));
			heliumPhotonSpawnTime = timer;
		}

		if (heliumList.size() == 5 && photonList.size() < 1) {
			photonList.add(new Photon(ImageLoader.photon, sun.getCenterX(), sun.getCenterY()));
		}

		for (Photon p : photonList) {
			p.update(timer);
			p.move();
			// camera.lockObject(p);
			if (state == 0) {
				camera.moveCamera(p.getVelX(), p.getVelY());
			}
			if (p.collision(earth)) {
				p.setVelY(0);
				state = 1;
			}
		}

		earth.update(timer);

		if (state == 1 && callPlant == 0) {
			for (Photon p : photonList) {
				if (camera.getY() < (p.getY() - 100)) {
					camera.moveCamera(0, 3);
				} else if (camera.getY() >= p.getY() - 100) {
					callCloud = 1;
					cloud.setY(p.getY());
					cloud.setPhotonX(p.getX());
				}
			}

		}

		// Calls Cloud
		if (callCloud == 1) {
			cloud.update(timer);
			if (cloud.getVelX() == 0) {
				callRain = 1;
			}
		}

		// Calls Rain
		if (callRain == 1) {
			double rainX = cloud.getX() + gen.nextInt((int) cloud.getWidth());

			if (rainList.size() < 50)
				rainList.add(new Rain(ImageLoader.rainDrop, rainX, cloud.getY() + 240));

			for (Rain r : rainList) {
				r.update(timer);
			}
		}
		
		if(puddleSize == 2) {
			callRain = 0;
			cloud.setVelX(-5);
			cloud.move();
			if(cloud.getX() < -1200) {
				callCloud = 0;
				callPlant = 1;
			}
		}
		
		if(callPerson == 1) {
			person.update(timer);
		}
		
		if(callPlant == 1) {
			
			for(Photon p : photonList) {
				camera.moveCamera(0, 0);
				p.setVelY(3);
				if(p.collision(plant)) {
					
					p.setVelY(0);
					callPerson = 1;
					callCells = 1;
				}
			}
			
			plant.update(timer);
			plant.move(person);
		}

	}// end update

	/**
	 * render game objects
	 * 
	 * @param gc
	 */
	public void render(GraphicsContext gc) {

		if (gc.getFill() != Color.BLACK && state == 0) {
			gc.setFill(Color.BLACK);
		}
		gc.fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);

		
		gc.translate(-camera.getX(), -camera.getY());

		if (state == 0) {
			if (sun.getBounds().getMaxY() > 0)
				sun.render(gc);
			// sun.showBounds(gc);

			if (earth.getBounds().getMinY() < Main.WINDOW_HEIGHT + 100)
				;
			earth.render(gc);

			if (sun.getBounds().getMaxY() > 0)
				for (Hydrogen h : hydrogenList) {
					h.render(gc);
				}

			if (sun.getBounds().getMaxY() > 0)
				for (Helium he : heliumList) {
					he.render(gc);
				}
		} // end state 0

		if (state == 1) {
			gc.setFill(Color.LIGHTBLUE);
			ground.render(gc);
		}

		for (Photon p : photonList) {
			p.render(gc);
		}

		if (callCloud == 1) {
			cloud.render(gc);
		}

		if (callRain == 1) {
			for (Rain r : rainList) {
				r.render(gc);
			}
			if (callPuddle == 0) {
				callPuddle = 1;
			}

		}

		if (callPuddle == 1) {
			if (startTime == 0) {
				startTime = GameTimer.getTimer();
			}
			if ((GameTimer.getTimer() - startTime > 3)) {
				if (puddleSize == 0) {
					puddleSize = 1;
				}
				gc.drawImage(ImageLoader.smallPuddle, 460, cloud.getY() + 800);
			}
			
			if(GameTimer.getTimer() - startTime > 6) {
				puddleSize = 2;
			}

		}
		
		if(callPerson == 1) {
			person.render(gc);
		}
		
		if(callPlant == 1) {
			plant.render(gc);
			gc.drawImage(ImageLoader.co2, plant.getX()-300, plant.getY()+100);
			gc.drawImage(ImageLoader.co2, person.getX()+person.getWidth()-100, person.getY()+person.getHeight()-125);
			gc.drawImage(ImageLoader.o2, person.getX(), person.getY() + person.getHeight()-75);
			
		}
		
		if(callCells == 1) {
			humanCell.render(gc);
			plantCell.render(gc);
			gc.drawImage(ImageLoader.h20, plant.getX(), plant.getY()+100);
		}
		
		
		
		gc.translate(camera.getX(), camera.getY());

	}// end render
}
