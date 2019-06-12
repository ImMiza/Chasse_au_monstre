package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource PierreFeuilleCiseauxEvent.fxml
 */

import java.io.IOException;

import cam.main.Launcher;
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
    /**
     * Permet de retourner au menu une fois la lecture des règles effectuée
     * @param Click de souris sur le bouton Retour
     * @throws IOException
     */
    void retourMenu(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    @FXML
    /**
     * Affiche les règles liées au chasseur
     * @param Click sur l'image du chasseur
     */
    void clickSurImgChasseur(MouseEvent event) {
        textChasseur.setVisible(true);
        imgChasseur.setVisible(false);
    }

    @FXML
    /**
     * Affiche les règles liées au monstre
     * @param Click sur l'image du monstre
     */
    void clickSurImgMonstre(MouseEvent event) {
        textMonstre.setVisible(true);
        imgMonstre.setVisible(false);
    }

    @FXML
    /**
     * Affiche l'image liée au chasseur
     * @param Click sur le texte des règles du jeu du chasseur
     */
    void clickSurTextChasseur(MouseEvent event) {
        textChasseur.setVisible(false);
        imgChasseur.setVisible(true);
    }

    @FXML
    /**
     * Affiche l'image liée au monstre
     * @param Click sur le texte des règles du jeu du monstre
     */
    void clickSurTextMonstre(MouseEvent event) {
        textMonstre.setVisible(false);
        imgMonstre.setVisible(true);
    }

    @FXML
    /**
     * Initialise les ressources de la page
     */
    void initialize() {
        assert imgChasseur != null : "fx:id=\"imgChasseur\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert imgMonstre != null : "fx:id=\"imgMonstre\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert reglesChasseur != null : "fx:id=\"reglesChasseur\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert textChasseur != null : "fx:id=\"textChasseur\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
        assert textMonstre != null : "fx:id=\"textMonstre\" was not injected: check your FXML file 'ReglesDuJeu.fxml'.";
    }

}
