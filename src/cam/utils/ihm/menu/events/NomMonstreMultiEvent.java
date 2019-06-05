package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource MenuChoixNomMonstreMulti.fxml
 * @author Adrien Bassail
 */


import java.io.IOException;

import cam.utils.ihm.menu.MenuIHM;
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
    /**
     * Permet, lorsque l'on clique sur le bouton Valider, de donner récupérer le choix de nom du monstre entré par le joueur dans l'espace de texte
     * et de lancer la partie avec les paramètres définis
     * @param Click de souris sur le bouton Valider
     * @throws IOException
     */
    void goNextMenu(MouseEvent event) throws IOException {
    	MenuIHM.setNomMonstre(txtFieldNomMonstre.getText());
    	
    	System.out.println("GOTO GAME MULTI");

    }

}

