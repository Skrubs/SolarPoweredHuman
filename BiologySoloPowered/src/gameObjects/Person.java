package gameObjects;

import application.ImageLoader;
import application.SpriteAnimation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Person extends Sprite {
	
	Image[] faceFrames = new Image[2];

	public Person(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		faceFrames[0] = ImageLoader.face1;
		faceFrames[1] = ImageLoader.face2;
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
		gc.drawImage(SpriteAnimation.animateSprite(faceFrames, .2), x, y);
		
	}

	@Override
	public void showBounds(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

}
