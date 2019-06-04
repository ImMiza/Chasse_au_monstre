package cam.utils.ihm.menu.events;

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
    void clickMonstre(MouseEvent event) throws IOException {
    	MenuIHM.setModeDeJeu(1);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuNomMonstre.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    @FXML
    void clickChasseur(MouseEvent event) throws IOException {
    	MenuIHM.setModeDeJeu(2);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuNomChasseur.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    @FXML
    void retourAuMenu(MouseEvent event) throws IOException {
    	MenuIHM.setDifficulte(0);
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent main = loader.load();
        Scene scene = new Scene(main);
        Launcher.getPrimaryStage().setScene(scene);
    }

}
