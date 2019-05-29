package cam.utils.ihm;

import cam.utils.cases.Case;
import cam.utils.personnages.Position;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EssaiAvecPlateauIhm extends Application{
	
	private PlateauIHM plateau;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loaderJEU = new FXMLLoader();
		loaderJEU.setLocation(getClass().getResource("/cam/ressources/CAM.fxml"));
		Parent root = loaderJEU.load();
		
		GraphicsContext gc = MainController.leCanvas.getGraphicsContext2D();
		
		for (int i = 0; i < plateau.getPlateau().getPlateau().length; i++) {
			for (int j = 0; j < plateau.getPlateau().getPlateau()[i].length; j++) {
				plateau.getPlateau().getPlateau()[i][j] = new Case(new Position(i * (500 / plateau.getPlateau().getPlateau().length), j * (500 / plateau.getPlateau().getPlateau()[i].length)));
				plateau.getLesRectangles()[i][j] = new Rectangle(i * (500 / plateau.getPlateau().getPlateau().length), j * (500 / plateau.getPlateau().getPlateau().length), 500 / plateau.getPlateau().getPlateau().length, 500 / plateau.getPlateau().getPlateau().length);
				gc.strokeRect(i * (500 / plateau.getPlateau().getPlateau().length), j * (500 / plateau.getPlateau().getPlateau().length), 500 / plateau.getPlateau().getPlateau().length, 500 / plateau.getPlateau().getPlateau().length);
			}
		}
		
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.setMinHeight(700);
		primaryStage.setMinWidth(700);
		primaryStage.setTitle("CAM");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
