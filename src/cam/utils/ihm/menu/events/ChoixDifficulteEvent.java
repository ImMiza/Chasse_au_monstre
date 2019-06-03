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
    void diff1(MouseEvent event) {
    	MenuIHM.setDifficulte(1);
    	
    	System.out.println("REDIRIGER VERS PLATEAU DE JEU ADAPTE");
    	System.out.println(MenuIHM.getNomChasseur());
    	System.out.println(MenuIHM.getNomMonstre());
    }

    @FXML
    void diff2(MouseEvent event) {
    	MenuIHM.setDifficulte(2);
    	
    	System.out.println("REDIRIGER VERS PLATEAU DE JEU ADAPTE");
    }

    @FXML
    void diff3(MouseEvent event) {
    	MenuIHM.setDifficulte(3);
    	
    	System.out.println("REDIRIGER VERS PLATEAU DE JEU ADAPTE");
    }

    @FXML
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

