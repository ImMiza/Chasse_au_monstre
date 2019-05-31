package cam.utils.ihm;

import cam.utils.cases.Case;
import cam.utils.plateau.Plateau;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	public static Canvas leCanvas;
    public static TextArea console;
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

    /**
     * fais le plateau avec les images
     */
    private void dessineDansCanvas(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image herbe = new Image("src/cam/ressources/herbe.jpg");
        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                gc.drawImage(herbe, canvas.getWidth()/10 * i, canvas.getHeight()/10*j, canvas.getWidth() / 10, canvas.getHeight()/10);
            }
        }
    }


    public void initialize() {
    	leCanvas = canvas;
    	console = txtFieldhistorique;
    	lblJoueur.setText("Au monstre a jouer");
    	dessineDansCanvas();
    }

}
