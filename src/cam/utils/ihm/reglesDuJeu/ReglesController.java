package cam.utils.ihm.reglesDuJeu;

import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.TextArea;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.StackPane;


public class ReglesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;




    @FXML
    private ImageView imgChasseur;

    @FXML
    private ImageView imgMonstre;

    @FXML
    private StackPane reglesChasseur;

    @FXML
    private TextArea textChasseur;

    @FXML
    private TextArea textMonstre;


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

