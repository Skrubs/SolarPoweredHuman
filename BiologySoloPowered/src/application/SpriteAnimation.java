package application;

import javafx.scene.image.Image;

public class SpriteAnimation {
	
	
	public SpriteAnimation() {
		
	}
	
	public static Image animateSprite(Image[] frames, double duration) {
		int index = (int) (GameTimer.getTimer() % (frames.length * duration) / duration);
		return frames[index];
	}

}
