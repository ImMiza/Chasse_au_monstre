/*package cam.utils.ihm.events;

import cam.utils.cases.Case;
import cam.utils.personnages.Position;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MainController2 {

    private PlateauIHM plateau;

    @FXML
    private Canvas canvas;

    @FXML
    private TextArea txtFieldhistorique;

    @FXML
    private Label lblJoueur;

    @FXML
    void activeCanvas(MouseEvent event) {
        for (int i = 0; i < plateau.getPlateau().getPlateau().length; i++) {
            for (int j = 0; j < plateau.getPlateau().getPlateau()[i].length; j++) {
                if (plateau.getLesRectangles()[i][j].contains(event.getX(), event.getY())) {
                    System.out.println(plateau.getLesRectangles()[i][j].getX() / (500 / plateau.getPlateau().getPlateau().length) + ", " + plateau.getLesRectangles()[i][j].getY() / (500 / lesCases.length));
                }
            }
        }
    }

    /**
     * fais le plateau avec les images
     */
/*
    private void dessineDansCanvas(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image herbe = new Image("file:src/cam/ressources/herbe.jpg");
        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                gc.drawImage(herbe, canvas.getWidth()/10 * i, canvas.getHeight()/10*j, canvas.getWidth() / 10, canvas.getHeight()/10);
            }
        }
    }


    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (int i = 0; i < plateau.getPlateau().getPlateau().length; i++) {
            for (int j = 0; j < plateau.getPlateau().getPlateau()[i].length; j++) {
                plateau.getPlateau().getPlateau()[i][j] = new Case(new Position(i * (500 / plateau.getPlateau().getPlateau().length), j * (500 / plateau.getPlateau().getPlateau()[i].length)));
                plateau.getLesRectangles()[i][j] = new Rectangle(i * (500 / plateau.getPlateau().getPlateau().length), j * (500 / plateau.getPlateau().getPlateau().length), 500 / plateau.getPlateau().getPlateau().length, 500 / plateau.getPlateau().getPlateau().length);
                gc.strokeRect(i * (500 / plateau.getPlateau().getPlateau().length), j * (500 / plateau.getPlateau().getPlateau().length), 500 / plateau.getPlateau().getPlateau().length, 500 / plateau.getPlateau().getPlateau().length);
            }
        }
        lblJoueur.setText("Au monstre a jouer");
        dessineDansCanvas();

    }

}
*/