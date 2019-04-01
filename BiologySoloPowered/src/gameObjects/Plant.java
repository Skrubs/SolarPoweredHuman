package gameObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Plant extends Sprite {

	public Plant(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D(x,y,width,height);
	}

	@Override
	public boolean collision(Sprite s) {
		return this.getBounds().intersects(s.getBounds());
	}

	public void move(Person p) {
		double rise = (p.getY() - this.getY());
		double run = (p.getX() - this.getX());
		this.velX = run;
		this.velY = rise;
	}
	
	@Override
	public void update(double timer) {
		
		
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
