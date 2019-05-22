package cam.utils.ihm;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Game extends Application {
	
	List<CaseIHM> lesCases = new ArrayList<>();

	public void start(Stage primaryStage) throws Exception {
		System.out.println("Bite. 8=====>");
		BorderPane groot = new BorderPane();
		Scene s = new Scene(groot, 1000, 1000);
		
		Label space1 = new Label();
		Label space2 = new Label();
		HBox.setHgrow(space1, Priority.ALWAYS);
		HBox.setHgrow(space2, Priority.ALWAYS);
		space1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		space2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		Label lblNom = new Label("Chasse au monstre");
		lblNom.setAlignment(Pos.CENTER);
		
		HBox title = new HBox(space1, lblNom, space2);
		
		groot.setTop(title);
		
		Canvas canvas = new Canvas(700, 700);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		groot.setCenter(canvas);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				CaseIHM c = new CaseIHM(50 * j + 10, 50 * i + 10, 50, 50);
				lesCases.add(c);
				gc.strokeRect(50 * j + 10, 50 * i + 10, 50, 50);
			}
		}
		
		canvas.setOnMouseClicked(e -> {
			double x = e.getX();
			double y = e.getY();
			
			for (int i = 0; i < lesCases.size(); i++) {
				if (lesCases.get(i).getRectangle().contains(x, y)) {
					System.out.println(lesCases.get(i).getRectangle().getX() + ", " + lesCases.get(i).getRectangle().getY());
				}
			}
		});
		
		primaryStage.setTitle("Game");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
