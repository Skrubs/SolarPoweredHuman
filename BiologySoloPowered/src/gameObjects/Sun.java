package gameObjects;

import application.ImageLoader;
import application.SpriteAnimation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Sun extends Sprite {
	
	private Image[] sunFrames;

	public Sun(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		
	}
	
	public void init() {
		sunFrames = new Image[3];
		sunFrames[0] = ImageLoader.sun1;
		sunFrames[1] = ImageLoader.sun2;
		sunFrames[2] = ImageLoader.sun3;
	}

	@Override
	public void update(double timer) {
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(SpriteAnimation.animateSprite(sunFrames, .1), this.x, this.y);
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D(x+150,y+200,width-350,height-350);
	}
	
	public void showBounds(GraphicsContext gc) {
		gc.setStroke(Color.DARKRED);
		gc.strokeRect(this.getBounds().getMinX(), this.getBounds().getMinY(), this.getBounds().getWidth(), this.getBounds().getHeight());
	}

	@Override
	public boolean collision(Sprite s) {
		// TODO Auto-generated method stub
		return false;
	}

}
