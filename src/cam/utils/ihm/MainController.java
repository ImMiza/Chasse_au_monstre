package cam.utils.ihm;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MainController {
    // Attributs pour le fonctionnement
	public static int width = 15;
	public static int height = 15;
	
	public static CaseIHM[][] cases;
	public static boolean canClick;
	public static Canvas plateau;
	private static TextArea console;
	private static Label indicateur;
	
	public static CaseIHM lastCase;

	// attributs lies a l'ihm
	@FXML
    private Label titre;
    @FXML
    private Canvas canvas;
    @FXML
    private Label indications;
    @FXML
    private TextArea consoleArea;


    // Methodes d'evenement

    /**
     *
     * @param event
     */
    @FXML
    void onClickPlateau(MouseEvent event) {
    	if(!canClick) {
    		return;
    	}
    	for(int i = 0; i < cases.length; i++) {
    		for(int j = 0; j < cases[0].length; j++) {
    			if(cases[i][j].getRectangle().contains(event.getX(), event.getY())) {
    				lastCase = cases[i][j];
    				return;
    			}
    		}
    	}
    	
    	GameControl.execute();
    }

    @FXML
    void initialize() {
        assert titre != null : "fx:id=\"titre\" was not injected: check your FXML file 'CAM.fxml'.";
        assert canvas != null : "fx:id=\"plateau\" was not injected: check your FXML file 'CAM.fxml'.";
        assert indications != null : "fx:id=\"indications\" was not injected: check your FXML file 'CAM.fxml'.";
        assert console != null : "fx:id=\"console\" was not injected: check your FXML file 'CAM.fxml'.";

        lastCase = null;
        cases = dessineTerrain(canvas, width, height);
        canClick = true;
        plateau = canvas;
        console = consoleArea;
        indicateur = indications;
        
        console.setEditable(false);
        console.setWrapText(false);
        
        titre.setText("Chasse au Monstre");
    }
    
    public static CaseIHM[][] dessineTerrain(Canvas canvas, int width, int height){
		CaseIHM[][] cases = new CaseIHM[width][height];
		
        Image herbe = new Image("/cam/ressources/herbe.jpg");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.drawImage(herbe, 0,0, 10,10);
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
            	cases[i][j] = new CaseIHM(i, j, i*canvas.getWidth()/width, j*canvas.getHeight()/height, canvas.getWidth()/width, canvas.getHeight()/height);
            	gc.drawImage(herbe, cases[i][j].getRectangle().getX(), cases[i][j].getRectangle().getY(), cases[i][j].getRectangle().getWidth(), cases[i][j].getRectangle().getHeight());
            }
        }
        
        return cases;
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
    
    public static void writeConsole(String message) {
    	console.setText(console.getText() + "\n" + message);
    }
    
    public static void clearConsole() {
    	console.setText("");
    }
    
    public static void setTextIndicator(String message) {
    	indicateur.setText(message);
    }
}
