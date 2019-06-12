package cam.utils.ihm;

import cam.main.games.Game;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

/**
 * Interface principal du jeu, gerant les events concernant le jeu
 * @author allan
 */
public class MainController {
    // Attributs pour le fonctionnement
	public static int width = 15;
	public static int height = 15;
	
	public static CaseIHM[][] cases;
	public static boolean canClick;
	public static Canvas plateau;
	public static TextArea console;
	public static Label indicateur;
	
	public static CaseIHM lastCase;
	
	public static Game game;

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
     * @param event l'event de la souris
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
    				game.execute();
    				return;
    			}
    		}
    	}
    	
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
        console.setWrapText(true);
        
        titre.setText("Chasse au Monstre");
    }
    
    /**
     * Dessine sur un canva le plateau du jeu
     * @param canvas le canva sur laquelle dessiner
     * @param width le nombre de case en longueur
     * @param height le nombre de case en largeur
     * @return le tableau de case associé
     */
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
    
    /**
     * Permet de dessiner le monstre sur le plateau
     * @param x position X de la case
     * @param y position Y de la case
     */
    public static void drawMonster(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	Image monster = new Image("/cam/ressources/monstre.png");
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.drawImage(monster, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    /**
     * Permet de dessiner le chasseur sur le plateau
     * @param x position X de la case
     * @param y position Y de la case
     */
    public static void drawHunter(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	Image hunter = new Image("/cam/ressources/chasseur.png");
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.drawImage(hunter, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
    
    /**
     * Permet de supprimer le monstre du plateau
     * @param x position X de la case
     * @param y position Y de la case
     */
    public static void removeMonster(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.clearRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
    
    /**
     * Permet de dessiner le chasseur du plateau
     * @param x position X de la case
     * @param y position Y de la case
     */
    public static void removeHunter(int x, int y) {
    	Rectangle rectangle = cases[x][y].getRectangle();
    	Image bg = new Image("/cam/ressources/herbe.jpg");
    	GraphicsContext context = plateau.getGraphicsContext2D();
    	context.clearRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    	context.drawImage(bg, rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }
    
    /**
     * Permet d'ecrire un message sur la console se situant a droite de l'interface
     * @param message le message a ecrire
     */
    public static void writeConsole(String message) {
    	console.setText(console.getText() + "\n" + message);
    }
    
    /**
     * Permet d'effacer tout sur la console
     */
    public static void clearConsole() {
    	console.setText("");
    }
    
    /**
     * Permet d'ecrire un texte sur l'indicateur de situant en bas de l'interface
     * @param message le message a ecrire
     */
    public static void setTextIndicator(String message) {
    	indicateur.setText(message);
    }
}
