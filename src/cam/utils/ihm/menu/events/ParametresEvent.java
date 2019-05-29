package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.utils.ihm.menu.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ParametresEvent {

    @FXML
    private TextField txtFieldTaillePlateau;

    @FXML
    private Slider sliderObstaclePlateau;

    @FXML
    private TextField txtFieldHorisontalMonstre;

    @FXML
    private Button retour;

    @FXML
    private Slider sliderTaillePlateau;

    @FXML
    private TextField txtFieldObstacle;

    @FXML
    private TextField txtFieldVerticalMonstre;

    @FXML
    private TextField txtFieldDiagonaleMonstre;

    @FXML
    void retourMenu(MouseEvent event) throws IOException {
    	
    	
    	
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

}
