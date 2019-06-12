package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource MenuChoixNomMonstreMulti.fxml
 * @author Adrien Bassail
 */


import java.io.IOException;

import cam.main.Launcher;
import cam.main.games.GameMonster;
import cam.main.games.LocalGame;
import cam.utils.ihm.MainController;
import cam.utils.ihm.menu.MenuIHM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NomMonstreMultiEvent {

    @FXML
    private Button valider;

    @FXML
    private TextField txtFieldNomMonstre;

    @FXML
    /**
     * Permet, lorsque l'on clique sur le bouton Valider, de donner récupérer le choix de nom du monstre entré par le joueur dans l'espace de texte
     * et d'accéder a la partie
     * @param Click de souris sur le bouton Valider
     * @throws IOException
     */
    void goNextMenu(MouseEvent event) throws IOException {
    	MenuIHM.setNomMonstre(txtFieldNomMonstre.getText());
    	
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
    	
    	MainController.game = new LocalGame(MenuIHM.getNomChasseur(), MenuIHM.getNomMonstre(), MainController.cases);

    }

}

