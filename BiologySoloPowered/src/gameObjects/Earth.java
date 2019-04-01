package gameObjects;

import application.ImageLoader;
import application.SpriteAnimation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Earth extends Sprite {
	
	private Image[] earthFrames;

	public Earth(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		
	}
	
	public void init() {
		earthFrames = new Image[3];
		earthFrames[0] = ImageLoader.earth1;
		earthFrames[1] = ImageLoader.earth2;
		earthFrames[2] = ImageLoader.earth3;
	}

	@Override
	public void update(double timer) {
		
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(SpriteAnimation.animateSprite(earthFrames, .3), x, y);
		
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D(x,y+100,width,height-100);
	}

	@Override
	public boolean collision(Sprite s) {
		return this.getBounds().intersects(s.getBounds());
	}

	@Override
	public void showBounds(GraphicsContext gc) {
		gc.strokeRect(this.getBounds().getMinX(),this.getBounds().getMinY(),
						this.getBounds().getWidth(),this.getBounds().getHeight());	
	}

}
