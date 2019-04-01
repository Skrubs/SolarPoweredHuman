package utils;

import application.Main;
import gameObjects.Sprite;

public class Camera {

	
	private double x;
	private double y;
	
	public Camera(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveCamera(double offsetX, double offsetY) {
		this.x += offsetX;
		this.y += offsetY;
	}
	
	public void lockObject(Sprite s) {
		x = ((s.getX() - (Main.WINDOW_WIDTH/2)));
		y = ((s.getY() - (Main.WINDOW_HEIGHT/2)));
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
	
	
	
}
