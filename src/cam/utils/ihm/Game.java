package cam.utils.ihm;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {
	
	List<Rectangle> lesCases = new ArrayList<Rectangle>();

	public void start(Stage primaryStage) throws Exception {
		BorderPane groot = new BorderPane();
		Scene s = new Scene(groot, 1000, 1000);
		
		Canvas canvas = new Canvas(700, 700);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		groot.setCenter(canvas);
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Rectangle r = new Rectangle(i, j, 50, 50);
				r.setOnMouseClicked(e -> {
					
				});
				lesCases.add(r);
				gc.strokeRect(50 * j + 10, 50 * i + 10, 50, 50);
			}
		}
		
		primaryStage.setTitle("Game");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
