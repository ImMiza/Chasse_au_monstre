package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.utils.ihm.menu.Launcher;
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
    void clickSurImgChasseur(MouseEvent event) {
        textChasseur.setVisible(true);
        imgChasseur.setVisible(false);
    }

    @FXML
    void clickSurImgMonstre(MouseEvent event) {
        textMonstre.setVisible(true);
        imgMonstre.setVisible(false);
    }

    @FXML
    void clickSurTextChasseur(MouseEvent event) {
        textChasseur.setVisible(false);
        imgChasseur.setVisible(true);
    }

    @FXML
    void clickSurTextMonstre(MouseEvent event) {
        textMonstre.setVisible(false);
        imgMonstre.setVisible(true);
    }

    @FXML
    void initialize() {
        assert imgChasseur != null : "fx:id=\"imgChasseur\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert imgMonstre != null : "fx:id=\"imgMonstre\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert reglesChasseur != null : "fx:id=\"reglesChasseur\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert textChasseur != null : "fx:id=\"textChasseur\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert textMonstre != null : "fx:id=\"textMonstre\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
    }

}
