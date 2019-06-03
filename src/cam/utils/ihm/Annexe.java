

package cam.utils.ihm;


import cam.utils.plateau.Plateau;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Annexe {
	
	public static CaseIHM[][] dessineTerrain(Canvas canvas, int width, int height){
		CaseIHM[][] cases = new CaseIHM[width][height];
		
        Image herbe= new Image("/cam/ressources/herbe.jpg");
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

    public static void ecritTourVisited(Canvas canvas, Plateau plateau) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for(int i = 0 ; i<plateau.getPlateau().length; i++){
            for (int j = 0; j<plateau.getPlateau()[0].length; j++){
                if(plateau.chercheCase(i,j).isVisited() && plateau.chercheCase(i,j).getNbClick() !=0){
                    gc.fillText(""+plateau.chercheCase(i,j).getTourVisited(), i*canvas.getWidth()/10, j*canvas.getHeight()/10, canvas.getWidth()/10);
                }
            }
        }
    }
    
}


