package gameObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Helium extends Sprite {

	public Helium(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		// TODO Auto-generated constructor stub
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

	@Override
	public void update(double timer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(this.getSpriteImage(), this.x, this.y);
		
	}

	@Override
	public void showBounds(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

}
