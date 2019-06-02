package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.main.MenuIHM;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NomMonstreMultiEvent {

    @FXML
    private Button valider;

    @FXML
    private TextField txtFieldNomMonstre;

    @FXML
    void goNextMenu(MouseEvent event) throws IOException {
    	MenuIHM.setNomMonstre(txtFieldNomMonstre.getText());
    	
    	System.out.println("GOTO GAME MULTI");

    }

}

