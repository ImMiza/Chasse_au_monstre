

package cam.utils.ihm;


import cam.utils.plateau.Plateau;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Annexe {
	
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


