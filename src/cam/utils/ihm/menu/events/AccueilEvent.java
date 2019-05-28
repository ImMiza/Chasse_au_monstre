package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.utils.ihm.menu.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    void goToSolo(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuChoixPersonnage.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Test.getPrimaryStage().setScene(scene);
    }

    @FXML
    void goToMultijoueur(MouseEvent event) {
    	System.out.println("test");
    }

    @FXML
    void goToAide(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/ReglesDuJeu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Test.getPrimaryStage().setScene(scene);
    }

    @FXML
    void quitter(MouseEvent event) {
    	System.exit(0);
    }

}

