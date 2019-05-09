package cam.utils.ihm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application{

	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Scene s = new Scene(root, 1000, 1000);
		
		Canvas canvas = new Canvas(700, 700);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		primaryStage.setTitle("Game");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
