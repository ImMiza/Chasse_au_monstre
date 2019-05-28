
package cam.utils.ihm.menu.events;

import cam.utils.ihm.menu.Test;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void retourAuMenu(MouseEvent event) {
    	System.out.println("test");
    	Scene scene = new Scene(Test.getMain());
     	Test.getPrimaryStage().setScene(scene);
    }

}
