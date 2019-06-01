package cam.utils.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EssaiAvecPlateauIhm extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loaderJEU = new FXMLLoader();
		loaderJEU.setLocation(getClass().getResource("file:src/cam/ressources/CAM.fxml"));
		Parent root = loaderJEU.load();
		
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
