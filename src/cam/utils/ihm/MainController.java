package cam.utils.ihm;

import cam.utils.ihm.menu.MenuIHM;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MainController {

	public static CaseIHM[][] cases;
	public static boolean canClick;
	public static Canvas plateau;
	
	@FXML
    private Label titre;

    @FXML
    private Canvas canvas;

    @FXML
    private Label indications;

    @FXML
    private TextArea console;

    @FXML
    void onClickPlateau(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert titre != null : "fx:id=\"titre\" was not injected: check your FXML file 'CAM.fxml'.";
        assert canvas != null : "fx:id=\"plateau\" was not injected: check your FXML file 'CAM.fxml'.";
        assert indications != null : "fx:id=\"indications\" was not injected: check your FXML file 'CAM.fxml'.";
        assert console != null : "fx:id=\"console\" was not injected: check your FXML file 'CAM.fxml'.";

        cases = Annexe.dessineTerrain(canvas, 10, 10);
        canClick = false;
        plateau = canvas;
    }
    
    public static void drawMonster(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	Image monster = new Image("/cam/ressources/monstre.png");
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.drawImage(monster, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public static void drawHunter(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	Image hunter = new Image("/cam/ressources/monstre.png");
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.drawImage(hunter, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
    
    public static void removeMonster(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	Image bg = new Image("/cam/ressources/herbe.jpg");
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.drawImage(bg, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
    
    public static void removeHunter(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	Image bg = new Image("/cam/ressources/herbe.jpg");
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.drawImage(bg, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
    
    
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
        Image herbe = new Image("/cam/ressources/herbe.jpg");
        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                gc.drawImage(herbe, canvas.getWidth()/10 * i, canvas.getHeight()/10*j, canvas.getWidth() / 10, canvas.getHeight()/10);
            }
        }
    }

}
