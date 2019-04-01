package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * 
 * @author Angelo Barcelona Biology 101 Instructor Dr. Martin 2019/03/30
 */

public class Main extends Application {

	private Stage window;
	private Scene mainScene;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	public static final double WINDOW_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();
	public static final double WINDOW_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
	private GameTimer gameTimer;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;

		root = new Group();
		mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		canvas = new Canvas(mainScene.getWidth(), mainScene.getHeight());
		gc = canvas.getGraphicsContext2D();

		root.getChildren().add(canvas);

		gameTimer = new GameTimer(gc);
		gameTimer.start();

		window.setScene(mainScene);
		window.setMaximized(true);
		window.setTitle("Barcelona Biology 101 - Solar Powered Humans");
		window.setX(Screen.getPrimary().getVisualBounds().getMinX());
		window.setY(Screen.getPrimary().getVisualBounds().getMinY());
		window.show();
	}

	public GameTimer getGameTimer() {
		return gameTimer;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
