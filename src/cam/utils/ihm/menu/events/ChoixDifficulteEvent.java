package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.utils.ihm.menu.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ChoixDifficulteEvent {

    @FXML
    private Button normal;

    @FXML
    private Button difficile;

    @FXML
    private Button easy;
    
    @FXML
    private Button retour;

    @FXML
    void diff1(MouseEvent event) {
    	System.out.println("diff 1");
    }

    @FXML
    void diff2(MouseEvent event) {
    	System.out.println("diff 2");
    }

    @FXML
    void diff3(MouseEvent event) {
    	System.out.println("diff 3");
    }
    
    @FXML
    void retourChoixPerso(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuChoixPersonnage.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Test.getPrimaryStage().setScene(scene);
    }

}
