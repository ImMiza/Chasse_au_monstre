
package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource Menu.fxml
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
    /**
     * Permet, lorsque l'on clique sur le bouton Solo, d'accéder au menu de choix de personnage, 
     * et de définir le mode de jeu dans la classe MenuIHM
     * @param Click de souris sur le bouton Solo
     * @throws IOException
     */
    void goToSolo(MouseEvent event) throws IOException {
    	MenuIHM.setModeDeJeu(1);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuChoixPersonnage.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Multijoueur, d'accéder au menu de choix du nom du chasseur, 
     * et de définir le mode de jeu dans la classe MenuIHM
     * @param Click de souris sur le bouton Multijoueur
     * @throws IOException
     */
    void goToMultijoueur(MouseEvent event) throws IOException {
    	MenuIHM.setModeDeJeu(2);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuNomChasseurMulti.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    	
    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Aide, d'accéder aux règles du jeu, 
     * @param Click de souris sur le bouton Aide
     * @throws IOException
     */
    void goToAide(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/ReglesDuJeu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }
    
    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton paramètres, d'accéder au menu de choix des paramètres, 
     * @param Click de souris sur le bouton Paramètres
     * @throws IOException
     */
    void goToParametres(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuParamètres.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Quitter, de quitter le jeu, 
     * @param Click de souris sur le bouton Quitter
     * @throws IOException
     */
    void quitter(MouseEvent event) {
    	System.exit(0);
    }

}

