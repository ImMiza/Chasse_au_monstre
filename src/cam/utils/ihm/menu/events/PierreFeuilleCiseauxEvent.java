package cam.utils.ihm.menu.events;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PierreFeuilleCiseauxEvent {

    @FXML
    private Button btnCiseaux;

    @FXML
    private Button btnPierre;

    @FXML
    private Button btnFeuille;

    @FXML
    void pierreChoix(MouseEvent event) {
    	System.out.println("Pierre");
    }

    @FXML
    void feuilleChoix(MouseEvent event) {
    	System.out.println("Feuille");
    }

    @FXML
    void ciseauxChoix(MouseEvent event) {
    	System.out.println("Ciseaux");
    }

}
