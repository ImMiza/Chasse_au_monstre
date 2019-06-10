package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.main.Launcher;

/**
 * Classe d'évènements liée à la ressource MenuChoixReseau.fxml
 * @author Adrien Bassail
 */

import cam.utils.ihm.menu.MenuIHM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MenuChoixReseauEvent {

    @FXML
    private Button reseau;

    @FXML
    private Button retour;

    @FXML
    private Button Local;

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Local, de renseigner true pour la variable estLocal dans MenuIHM
     * et de lancer une partie avec tous les paramètres renseignés
     * @param Click de souris sur le bouton Local
     * @throws IOException
     */
    void modeLocalClick(MouseEvent event) {
    	MenuIHM.setLocal(true);
    	
    	System.out.println("GOTO game multi en local");

    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Réseau, de renseigner true pour la variable estReseau dans MenuIHM
     * et de lancer une partie avec tous les paramètres renseignés
     * @param Click de souris sur le bouton Réseau
     * @throws IOException
     */
    void modeReseauClick(MouseEvent event) {
    	MenuIHM.setReseau(true);
    	
    	System.out.println("GOTO game multi en réseau");

    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Retour, de retourner au menu principal du jeu
     * et d'effacer des variables tous les paramètres renseignés
     * @param Click de souris sur le bouton Local
     * @throws IOException
     */
    void retourMenu(MouseEvent event) throws IOException {
    	MenuIHM.setLocal(false);
    	MenuIHM.setReseau(false);
    	MenuIHM.setNomChasseur("");
    	MenuIHM.setNomMonstre("");
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);

    }

}
