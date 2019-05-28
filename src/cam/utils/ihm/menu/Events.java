package cam.utils.ihm.menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Events {

    @FXML
    private Button solo;

    @FXML
    private Button Aide;

    @FXML
    private Button quitter;

    @FXML
    void GoToSolo(MouseEvent event) {
    	System.out.println("test");
//    	Scene scene = new Scene(Test.getChoosePerso());
//    	Test.getPrimaryStage().setScene(scene);
    }

    @FXML
    void goToAide(MouseEvent event) {

    }

    @FXML
    void goToMultijoueur(MouseEvent event) {

    }

    @FXML
    void multijoueur(ActionEvent event) {

    }

    @FXML
    void quit(MouseEvent event) {
    	System.exit(1);
    }

}
