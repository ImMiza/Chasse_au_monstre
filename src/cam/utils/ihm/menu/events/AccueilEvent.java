
package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.main.MenuIHM;
import cam.utils.ihm.menu.Launcher;
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
    private Button parametres;

    @FXML
    void goToSolo(MouseEvent event) throws IOException {
    	MenuIHM.setModeDeJeu(1);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuChoixPersonnage.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    @FXML
    void goToMultijoueur(MouseEvent event) {
    	MenuIHM.setModeDeJeu(2);
    	
    	System.out.println("REDIRIGER VERS PLATEAU DE JEU ADAPTE");
    }

    @FXML
    void goToAide(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/ReglesDuJeu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }
    
    @FXML
    void goToParametres(MouseEvent event) {
    	System.out.println("TODO");
    }

    @FXML
    void quitter(MouseEvent event) {
    	System.exit(0);
    }

}

