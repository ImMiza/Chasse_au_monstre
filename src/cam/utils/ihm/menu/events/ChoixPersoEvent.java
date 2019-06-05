package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource MenuChoixPersonnage.fxml
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

public class ChoixPersoEvent {

    @FXML
    private Button monstre;

    @FXML
    private Button retour;

    @FXML
    private Button chasseur;

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Monstre, d'accéder au menu de choix du nom du monstre, 
     * et de définir le choix de personnage sur 1
     * @param Click de souris sur le bouton Monstre
     * @throws IOException
     */
    void clickMonstre(MouseEvent event) throws IOException {
    	MenuIHM.setPersonnage(1);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuNomMonstre.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
     	
     	System.out.println(MenuIHM.getPersonnage());
    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Chasseur, d'accéder au menu de choix du nom du Chasseur, 
     * et de définir le choix de personnage sur 2
     * @param Click de souris sur le bouton Chasseur
     * @throws IOException
     */
    void clickChasseur(MouseEvent event) throws IOException {
    	MenuIHM.setPersonnage(2);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuNomChasseur.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
     	
     	System.out.println(MenuIHM.getPersonnage());
    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Retour, de retourner au menu principal
     * et de redéfinir les paramètres définis précédamment aux valeurs par défaut
     * @param Click de souris sur le bouton Retour
     * @throws IOException
     */
    void retourAuMenu(MouseEvent event) throws IOException {
    	MenuIHM.setDifficulte(0);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent main = loader.load();
        Scene scene = new Scene(main);
        Launcher.getPrimaryStage().setScene(scene);
    }

}
