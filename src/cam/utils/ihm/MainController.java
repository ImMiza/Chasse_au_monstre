package cam.utils.ihm;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;

public class MainController {

    @FXML
    private Label indications;

    @FXML
    private Canvas leCanvas;

    @FXML
    private Label Titre;

    @FXML
    private TextArea Console;
    private GraphicsContext gc;

    @FXML
    public void initialize(){
        Image herbe = new Image("file:src/sample/herbe.jpg");
        Annexe.dessineTerrain(leCanvas);
    }

}
