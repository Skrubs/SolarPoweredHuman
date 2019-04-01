package application;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameTimer extends AnimationTimer {
	
	private Game game;
	private GraphicsContext gc;
	
	private static double timer;
	private double startTime = System.nanoTime();
	
	public GameTimer(GraphicsContext gc) {
		this.gc = gc;
		game = new Game();
		game.init();
	}
	
	@Override
	public void handle(long now) {
		
		timer = (now-startTime)/1000000000.0;
		
		game.update(timer);
		game.render(gc);
	}
	
	public static double getTimer() {
		return timer;
	}

}
