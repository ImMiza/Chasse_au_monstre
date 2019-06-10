package cam.utils.ihm.menu.events;


import cam.main.games.Game;
import cam.utils.ihm.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class PierreFeuilleCiseauxEvent {
    /**
     * 1 = Pierre
     * 2 = Feuille
     * 3 = Ciseaux
     */
    private static int choixMonstre;
    private static int choixChasseur;
    
    public static boolean playerIsMonster = true;

    /**
     * Setter de choixChasseur
     * @param choixChasseur
     */
    public static void setChoixChasseur(int cChasseur) {
        choixChasseur = cChasseur;
    }

    /**
     * Setter de choixMonstre
     * @param choixMonstre
     */
    public static void setChoixMonstre(int cMonstre) {
        choixMonstre = cMonstre;
    }

    /**
     * Getter de choixChasseur
     * @return
     */
    public static int getChoixChasseur() {
        return choixChasseur;
    }

    /**
     * Getter de choixMonstre
     * @return
     */
    public static int getChoixMonstre() {
        return choixMonstre;
    }

    /**
     * Donne le resultat du pierre feuille ciseaux
     * @return -1 si le monstre gagne
     *  0 si il y a une egalite
     *  1 si le chasseur a gagne
     */
    public int getResult(){
        if (choixChasseur == 1) {
            if(choixMonstre == 1) return 0;
            else if(choixMonstre == 2) return -1;
            else return 1;
        } else if (choixChasseur == 2){
            if (choixMonstre == 1) return 1;
            else if (choixMonstre == 2) return 0;
            else return -1;
        } else {
            if (choixMonstre == 1) return -1;
            else if (choixMonstre == 2) return 1;
            else return 0;
        }
    }

    @FXML
    private Button btnCiseaux;

    @FXML
    private Button btnPierre;

    @FXML
    private Button btnFeuille;

    @FXML
    void pierreChoix(MouseEvent event) {
    	choix(1, "Pierre");

    }

    @FXML
    void feuilleChoix(MouseEvent event) {
    	choix(2, "Feuille");
    }

    @FXML
    void ciseauxChoix(MouseEvent event) {
    	choix(3, "Ciseaux");
    }
    
    private void choix(int c, String str) {
    	if(playerIsMonster) {
    		choixMonstre = c;
    		choixChasseur = (int) (Math.random() * 3) + 1;
    	}
    	else {
    		choixChasseur = c;
    		choixMonstre = (int) (Math.random() * 3) + 1;
    	}
    	
    	MainController.clearConsole();
    	MainController.writeConsole("Vous avez choisi: " + str);
    	
    	int result = getResult();
    	if(playerIsMonster && result == 1) {
    		MainController.writeConsole("Le chasseur gagne");
    		MainController.setTextIndicator("Vous avez perdu !");
    		Game.PierreFeuilleCiseaux.close();
        	Game.PFC = false;
        	Game.gameFinish = true;
    	}
    	else if(playerIsMonster && result == -1) {
    		MainController.writeConsole("Le monstre gagne");
    		MainController.setTextIndicator("Vous etes encore libre !");
    		Game.PierreFeuilleCiseaux.close();
        	Game.PFC = false;
        	MainController.canClick = true;
    	}
    	else {
    		MainController.writeConsole("Egalite");
    		MainController.setTextIndicator("Allez du nerf !");
    	}
    }
}
