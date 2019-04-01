package gameObjects;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Sprite {
	
	protected Image spriteImage;
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	protected double velX;
	protected double velY;
	protected boolean alive;
	protected double centerX;
	protected double centerY;
	
	
	public Sprite(Image spriteImage, double x, double y) {
		this.spriteImage = spriteImage;
		this.x = x;
		this.y = y;
		this.width = spriteImage.getWidth();
		this.height = spriteImage.getHeight();
		velX = 0;
		velY = 0;
		alive = true;
		centerX = (x + width)/2;
		centerY = (y + height)/2;
	}
	
	public abstract Rectangle2D getBounds();
	public abstract boolean collision(Sprite s);
	public abstract void update(double timer);
	public abstract void render(GraphicsContext gc);
	public abstract void showBounds(GraphicsContext gc);
	
	
	public void setVelocity(double velX, double velY) {
		x += velX;
		y += velY;
	}
	
	
	
	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Image getSpriteImage() {
		return spriteImage;
	}

	public void setSpriteImage(Image spriteImage) {
		this.spriteImage = spriteImage;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
	
	

}
