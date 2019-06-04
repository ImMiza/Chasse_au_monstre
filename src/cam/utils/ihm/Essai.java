package cam.utils.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Essai extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loaderJEU = new FXMLLoader();
		loaderJEU.setLocation(getClass().getResource("/cam/ressources/CAM.fxml"));
		Parent root = loaderJEU.load();
		
		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.setMinHeight(720);
		primaryStage.setMinWidth(1080);
		primaryStage.setTitle("CAM");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
