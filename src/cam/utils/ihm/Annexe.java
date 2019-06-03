

package cam.utils.ihm;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Annexe {
    public static void dessineTerrain(Canvas canvas){
        Image herbe= new Image("file:src/sample/herbe.jpg");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.drawImage(herbe, 0,0, 10,10);
        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                gc.drawImage(herbe, i*canvas.getWidth()/10, j*canvas.getHeight()/10, canvas.getWidth(), canvas.getHeight());
            }
        }
    }
}


