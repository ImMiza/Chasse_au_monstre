package cam.utils.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Essai extends Application {

	private static CaseIHM[][] lesCases = new CaseIHM[10][10];
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loaderJEU = new FXMLLoader();
		loaderJEU.setLocation(getClass().getResource("/cam/ressources/CAM.fxml"));
		Parent root = loaderJEU.load();
		
		GraphicsContext gc = MainController.leCanvas.getGraphicsContext2D();
		
		for (int i = 0; i < lesCases.length; i++) {
			for (int j = 0; j < lesCases[i].length; j++) {
				lesCases[i][j] = new CaseIHM(i * (500 / lesCases.length), j * (500 / lesCases.length), 500 / lesCases.length, 500 / lesCases.length);
				gc.strokeRect(i * (500 / lesCases.length), j * (500 / lesCases.length), 500 / lesCases.length, 500 / lesCases.length);
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
	
	public static CaseIHM[][] getCase() {
		return lesCases;
	}

}
