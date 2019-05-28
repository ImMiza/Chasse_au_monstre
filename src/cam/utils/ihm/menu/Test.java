package cam.utils.ihm.menu;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application{

	private static Parent main;
	private static Parent choosePerso;
	
	private static Stage primary;
	private static Scene scene;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		primary = stage;
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        main = loader.load();
        
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("/cam/ressources/MenuChoixPersonnage.fxml"));
        choosePerso = loader2.load();
        
        scene = new Scene(main);
        primary.setScene(scene);
        primary.setTitle("Menu");
        primary.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static Parent getMain() {
		return main;
	}
	
	public static Parent getChoosePerso() {
		return choosePerso;
	}
	
	public static Scene getScene() {
		return scene;
	}
	
	public static Stage getPrimaryStage() {
		return primary;
	}
}
