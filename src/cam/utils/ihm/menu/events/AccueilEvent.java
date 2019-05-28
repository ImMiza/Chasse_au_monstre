package cam.utils.ihm.menu.events;

import cam.utils.ihm.menu.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

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
    void GoToSolo(ActionEvent event) {
    	Scene scene = new Scene(Test.getChoosePerso());
    	Test.getPrimaryStage().setScene(scene);
    }

    @FXML
    void goToMultijoueur(ActionEvent event) {

    }

    @FXML
    void goToAide(ActionEvent event) {

    }

    @FXML
    void quit(ActionEvent event) {

    }

}
