package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.utils.ihm.menu.Launcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class ReglesDuJeuEvent {

    @FXML
    private TextArea textChasseur;

    @FXML
    private ImageView imgMonstre;

    @FXML
    private Button retour;

    @FXML
    private StackPane reglesChasseur;

    @FXML
    private TextArea textMonstre;

    @FXML
    private ImageView imgChasseur;

    @FXML
    void retourMenu(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    @FXML
    void clickSurTextMonstre(ActionEvent event) {

    }

    @FXML
    void clickSurImgMonstre(ActionEvent event) {

    }

    @FXML
    void clickSurTextChasseur(ActionEvent event) {

    }

    @FXML
    void clickSurImgChasseur(ActionEvent event) {

    }

}
