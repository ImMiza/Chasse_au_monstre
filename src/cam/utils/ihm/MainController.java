package cam.utils.ihm;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	public static Canvas leCanvas;

    @FXML
    private Canvas canvas;

    @FXML
    private TextArea txtFieldhistorique;

    @FXML
    private Label lblJoueur;

    @FXML
    void activeCanvas(MouseEvent event) {
    	CaseIHM[][] lesCases = Essai.getCase();
    	
    	for (int i = 0; i < lesCases.length; i++) {
			for (int j = 0; j < lesCases[i].length; j++) {
				if (lesCases[i][j].getRectangle().contains(event.getX(), event.getY())) {
					System.out.println(lesCases[i][j].getRectangle().getX() / (500 / lesCases.length) + ", " + lesCases[i][j].getRectangle().getY() / (500 / lesCases.length));
				}
			}
		}
    }
    
    public void initialize() {
    	leCanvas = canvas;
    	lblJoueur.setText("Au monstre a jouer");
    }

}
