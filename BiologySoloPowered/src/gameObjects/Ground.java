package gameObjects;

import application.ImageLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Ground extends Sprite {

	public Ground(Image spriteImage, double x, double y) {
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
		gc.drawImage(ImageLoader.ground, x, y);
		
	}

	@Override
	public void showBounds(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

}
