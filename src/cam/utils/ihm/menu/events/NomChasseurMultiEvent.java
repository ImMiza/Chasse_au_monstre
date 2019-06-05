package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource MenuChoixNomChasseurMulti.fxml
 * @author Adrien Bassail
 */


import java.io.IOException;

import cam.main.Launcher;
import cam.utils.ihm.menu.MenuIHM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NomChasseurMultiEvent {

    @FXML
    private Button valider;

    @FXML
    private TextField txtFieldNomChasseur;

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Valider, de donner récupérer le choix de nom du chasseur entré par le joueur dans l'espace de texte
     * et d'accéder au menu de choix du nom du monstre
     * @param Click de souris sur le bouton Valider
     * @throws IOException
     */
    void goNextMenu(MouseEvent event) throws IOException {
    	MenuIHM.setNomChasseur(txtFieldNomChasseur.getText());
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuNomMonstreMulti.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);

    }

}