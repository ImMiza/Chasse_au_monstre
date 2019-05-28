package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.main.MenuIHM;
import cam.utils.ihm.menu.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NomChasseurEvent {

    @FXML
    private Button valider;

    @FXML
    private TextField txtFieldNomChasseur;

    @FXML
    void goNextMenu(MouseEvent event) throws IOException {
    	MenuIHM.setNomChasseur(txtFieldNomChasseur.getText());
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/MenuChoixDifficulte.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);

    }

}