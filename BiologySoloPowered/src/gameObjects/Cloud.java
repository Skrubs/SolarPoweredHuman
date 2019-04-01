package gameObjects;

import application.GameTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Cloud extends Sprite {
	
	private double startTime = GameTimer.getTimer();
	private double photonX = 0;

	public Cloud(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		this.setVelX(-5);
	}

	@Override
	public Rectangle2D getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setPhotonX(double x) {
		this.photonX = x;
	}

	@Override
	public boolean collision(Sprite s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void move() {
		x += velX;
	}

	@Override
	public void update(double timer) {
		
		if(this.x == (photonX - 200)) {
			this.setVelX(0);
			
		}
		
		move();

	}

	@Override
	public void render(GraphicsContext gc) {
		
		gc.drawImage(this.spriteImage, x, y);
	}

	@Override
	public void showBounds(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

}
