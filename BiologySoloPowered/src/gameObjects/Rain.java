package gameObjects;

import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Rain extends Sprite {
	
	private double startY;

	public Rain(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		velY = 5 + new Random().nextInt(4);
		startY = y;
	}

	@Override
	public Rectangle2D getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean collision(Sprite s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public void move() {
		y += velY;		
	}

	@Override
	public void update(double timer) {
		
		if((this.y - startY) > 900) {
			this.y = startY;
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
