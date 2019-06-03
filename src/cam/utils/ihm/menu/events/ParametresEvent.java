package cam.utils.ihm.menu.events;

import java.io.IOException;

import cam.main.MenuIHM;
import cam.utils.ihm.menu.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    
    @FXML
    void sliderXReleasedListener(MouseEvent event) {
    	this.txtFieldXPlateau.setText("" + this.sliderXPlateau.getValue());
    }

    @FXML
    void sliderYReleasedListener(MouseEvent event) {
    	this.txtFieldYPlateau.setText("" + this.sliderYPlateau.getValue());
    }

    @FXML
    void txtFieldXKeyReleasedListener(KeyEvent event) {
    	this.sliderXPlateau.setValue(Double.parseDouble(this.txtFieldXPlateau.getText()));
    }

    @FXML
    void txtFieldYKeyReleasedListener(KeyEvent event) {
    	this.sliderYPlateau.setValue(Double.parseDouble(this.txtFieldYPlateau.getText()));
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
    }

}
