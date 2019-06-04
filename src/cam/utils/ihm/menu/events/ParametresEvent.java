package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.main.Launcher;
import cam.utils.ihm.menu.MenuIHM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ParametresEvent {

    @FXML
    private TextField txtFieldYPlateau;

    @FXML
    private Slider sliderYPlateau;

    @FXML
    private TextField txtFieldHorisontalMonstre;

    @FXML
    private Button retour;

    @FXML
    private Slider sliderXPlateau;

    @FXML
    private TextField txtFieldXPlateau;

    @FXML
    private TextField txtFieldVerticalMonstre;

    @FXML
    private TextField txtFieldDiagonaleMonstre;

    @FXML
    void retourMenu(MouseEvent event) throws IOException {
    	if(isNumber(txtFieldHorisontalMonstre.getText())) {
    		MenuIHM.setDeplacementHorizontalMonstre(Integer.parseInt(txtFieldHorisontalMonstre.getText()));
    	}
    	else {
    		MenuIHM.setDeplacementHorizontalMonstre(2);
    	}

    	if(isNumber(txtFieldVerticalMonstre.getText())) {
    		MenuIHM.setDeplacementVerticalMonstre(Integer.parseInt(txtFieldVerticalMonstre.getText()));
    	}
    	else {
    		MenuIHM.setDeplacementVerticalMonstre(2);
    	}

    	if(isNumber(txtFieldDiagonaleMonstre.getText())) {
    		MenuIHM.setDeplacementDiagonaleMonstre(Integer.parseInt(txtFieldDiagonaleMonstre.getText()));
    	}
    	else {
    		MenuIHM.setDeplacementDiagonaleMonstre(1);
    	}
    	System.out.println("HMonstre : " + MenuIHM.getDeplacementHorizontalMonstre());
    	System.out.println("VMonstre : " + MenuIHM.getDeplacementVerticalMonstre());
    	System.out.println("DMonstre : " + MenuIHM.getDeplacementDiagonaleMonstre());


    	MenuIHM.setTailleXPlateau(Integer.parseInt(txtFieldXPlateau.getText()));
    	MenuIHM.setTailleYPlateau(Integer.parseInt(txtFieldYPlateau.getText()));

    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/cam/ressources/Menu.fxml"));
        Parent perso = loader.load();
    	Scene scene = new Scene(perso);
     	Launcher.getPrimaryStage().setScene(scene);
    }

    public boolean isNumber(String s) {
    	try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
    	return true;
    }

    public void initialize() {
    	txtFieldHorisontalMonstre.setText(MenuIHM.getDeplacementHorizontalMonstre() + "");
    	txtFieldVerticalMonstre.setText(MenuIHM.getDeplacementVerticalMonstre() + "");
    	txtFieldDiagonaleMonstre.setText(MenuIHM.getDeplacementDiagonaleMonstre() + "");

    	this.sliderXPlateau.setOnMouseDragged(e -> {
    		this.txtFieldXPlateau.setText("" + (int) this.sliderXPlateau.getValue());
    	});
    	this.sliderYPlateau.setOnMouseDragged(e -> {
    		this.txtFieldYPlateau.setText("" + (int) this.sliderYPlateau.getValue());
    	});
    	this.txtFieldXPlateau.setOnKeyReleased(e -> {
    		if (!this.txtFieldXPlateau.getText().equals("") && isInteger(txtFieldXPlateau.getText())) {
            	this.sliderXPlateau.setValue((double) Integer.parseInt(this.txtFieldXPlateau.getText()));
			}
    	});
    	this.txtFieldYPlateau.setOnKeyReleased(e -> {
    		if (!this.txtFieldYPlateau.getText().equals("") && isInteger(txtFieldYPlateau.getText())) {
            	this.sliderYPlateau.setValue((double) Integer.parseInt(this.txtFieldYPlateau.getText()));
			}
    	});
    }
    
    public boolean isInteger(String s) {
    	try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
    }

}
