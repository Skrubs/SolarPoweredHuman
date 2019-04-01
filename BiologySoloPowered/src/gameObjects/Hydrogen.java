package gameObjects;

import java.util.ArrayList;

import application.GameTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Hydrogen extends Sprite {

	private double velX;
	private double velY;
	private static double startTimer = 0;

	public Hydrogen(Image spriteImage, double x, double y, double velX, double velY) {
		super(spriteImage, x, y);
		this.velX = velX;
		this.velY = velY;

	}

	public boolean hydrogenCollision(Hydrogen h) {
		if (this.isAlive() && h.isAlive()) {
			if (GameTimer.getTimer() - startTimer > 4) {
				if (this.getBounds().intersects(h.getBounds())) {
					this.setAlive(false);
					h.setAlive(false);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * returns the bounds of the object for collision detection
	 * 
	 * @return Rectangle2D
	 */
	public Rectangle2D getBounds() {
		return new Rectangle2D(x + 15, y + 35, width - 45, height - 55);
	}

	public void move(Sprite s) {

		if (this.getBounds().getMaxX() >= s.getBounds().getMaxX()
				|| this.getBounds().getMinX() <= s.getBounds().getMinX()) {
			this.velX *= -1;
		}

		if (this.getBounds().getMaxY() >= s.getBounds().getMaxY()
				|| this.getBounds().getMinY() <= s.getBounds().getMinY()) {
			this.velY *= -1;
		}

		x += velX;
		y += velY;
	}

	public void setVelocity(double velX, double velY) {
		this.velX = velX;
		this.velY = velY;
	}

	/**
	 * Sets the X velocity of the object
	 * 
	 * @param velX
	 */
	public void setVelX(double velX) {
		this.velX = velX;
	}

	/**
	 * Sets the Y velocity of the object
	 * 
	 * @param velY
	 */
	public void setVelY(double velY) {
		this.velY = velY;
	}

	@Override
	public void update(double timer) {

	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(this.spriteImage, this.x, this.y);
	}

	@Override
	public boolean collision(Sprite s) {
		return this.getBounds().intersects(s.getBounds());
	}

	@Override
	public void showBounds(GraphicsContext gc) {
		gc.setFill(Color.DARKBLUE);
		gc.strokeRect(this.getBounds().getMinX(), this.getBounds().getMinY(), this.getBounds().getWidth(),
				this.getBounds().getHeight());

	}

}
