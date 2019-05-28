package cam.utils.ihm.menu.events;

import cam.utils.ihm.menu.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AccueilEvent {

    @FXML
    private Button multijoueur;

    @FXML
    private Button aide;

    @FXML
    private Button quitter;

    @FXML
    private Button solo;

    @FXML
    void goToSolo(MouseEvent event) {
    	Scene scene = new Scene(Test.getChoosePerso());
     	Test.getPrimaryStage().setScene(scene);
    }

    @FXML
    void goToMultijoueur(MouseEvent event) {
    	System.out.println("test");
    }

    @FXML
    void goToAide(MouseEvent event) {

    }

    @FXML
    void quitter(MouseEvent event) {
    	System.exit(0);
    }

}

