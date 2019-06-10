package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource MenuChoixDifficulte.fxml
 * @author Adrien Bassail
 */


import java.io.IOException;

import cam.main.Launcher;
import cam.main.games.GameMonster;
import cam.utils.ihm.MainController;
import cam.utils.ihm.menu.MenuIHM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class ChoixDifficulteEvent {

    @FXML
    private Button normal;

    @FXML
    private Button difficile;

    @FXML
    private Button retour;

    @FXML
    private Button easy;

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Easy, de lancer la partie avec tous les paramètres définis, 
     * et de définir la difficulté au niveau 1
     * @param Click de souris sur le bouton Easy
     * @throws IOException
     */
    void diff1(MouseEvent event) throws IOException {
    	MenuIHM.setDifficulte(1);
    	
    	if(MenuIHM.getPersonnage() == 1) {
    		launchGameMonster();
    	}
    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Normal, de lancer la partie avec tous les paramètres définis, 
     * et de définir la difficulté au niveau 2
     * @param Click de souris sur le bouton Normal
     * @throws IOException
     */
    void diff2(MouseEvent event) {
    	MenuIHM.setDifficulte(2);
    	
    	if(MenuIHM.getPersonnage() == 1) {
    		launchGameMonster();
    	}
    }

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Difficile, de lancer la partie avec tous les paramètres définis, 
     * et de définir la difficulté au niveau 3
     * @param Click de souris sur le bouton Difficile
     * @throws IOException
     */
    void diff3(MouseEvent event) {
    	MenuIHM.setDifficulte(3);
    	
    	if(MenuIHM.getPersonnage() == 1) {
    		launchGameMonster();
    	}
    }

    
    private void launchGameMonster() {
    	try{
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/cam/ressources/CAM.fxml"));
	        Parent parent;
			parent = loader.load();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Jeu");
			stage.show();
			
			MainController.game = new GameMonster(MenuIHM.getNomMonstre(), MenuIHM.getDifficulte(), MainController.cases);
			MainController.canClick = true;
    	}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }
    
    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Retour, de retourner au menu principal
     * et de redéfinir les paramètres définis précédamment aux valeurs par défaut
     * @param Click de souris sur le bouton Retour
     * @throws IOException
     */
    void retour(MouseEvent event) throws IOException {
    	MenuIHM.setDifficulte(0);
    	MenuIHM.setNomChasseur("");
    	MenuIHM.setNomMonstre("");
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

}

