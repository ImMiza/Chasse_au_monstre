
package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.utils.ihm.menu.Test;
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
    void clickMonstre(MouseEvent event) {

    }

    @FXML
    void clickChasseur(MouseEvent event) {
    	System.out.println("essai");
    }

    @FXML
    void retourAuMenu(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent main = loader.load();
        Scene scene = new Scene(main);
        Test.getPrimaryStage().setScene(scene);
    }

}
