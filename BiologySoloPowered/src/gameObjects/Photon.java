package gameObjects;

import application.ImageLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import utils.Camera;

public class Photon extends Sprite {

	public Photon(Image spriteImage, double x, double y) {
		super(spriteImage, x, y);
		this.velY += 3;
		velX += 0;
	}
	
	public void move() {
		x += velX;
		y += velY;
	}

	@Override
	public Rectangle2D getBounds() {
		return new Rectangle2D(x,y,width,height);
	}

	@Override
	public boolean collision(Sprite s) {
		return this.getBounds().intersects(s.getBounds());
	}

	@Override
	public void update(double timer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(ImageLoader.photon, x, y);
		
	}

	@Override
	public void showBounds(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}

}
