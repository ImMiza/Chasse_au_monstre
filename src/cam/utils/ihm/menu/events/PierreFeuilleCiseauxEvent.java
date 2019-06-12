package cam.utils.ihm.menu.events;

/**
 * Classe d'évènements liée à la ressource PierreFeuilleCiseauxEvent.fxml
 * @author Adrien Bassail & Allan Boukhebza
 */


import java.io.IOException;

import cam.main.games.Game;
import cam.utils.ihm.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PierreFeuilleCiseauxEvent {
    /**
     * 1 = Pierre
     * 2 = Feuille
     * 3 = Ciseaux
     */
    private static int choixMonstre;
    private static int choixChasseur;
    
    public static boolean playerIsMonster = true;
    
    public static boolean localGame = false;
    public static boolean theFirstPlayed = false;
    
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

    public static Label Indicator;
    
    @FXML
    private Label text;
    
    @FXML
    private Button btnCiseaux;

    @FXML
    private Button btnPierre;

    @FXML
    private Button btnFeuille;

    @FXML
    void initialize() {
        assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'PierreFeuilleCiseauxFenetre.fxml'.";
        assert btnPierre != null : "fx:id=\"btnPierre\" was not injected: check your FXML file 'PierreFeuilleCiseauxFenetre.fxml'.";
        assert btnFeuille != null : "fx:id=\"btnFeuille\" was not injected: check your FXML file 'PierreFeuilleCiseauxFenetre.fxml'.";
        assert btnCiseaux != null : "fx:id=\"btnCiseaux\" was not injected: check your FXML file 'PierreFeuilleCiseauxFenetre.fxml'.";
        Indicator = text;
    }
    
    @FXML
    void pierreChoix(MouseEvent event) {
    	if(!localGame)
    		choix(1, "Pierre");
    	else
    		localGameChoix(1);
    }

	@FXML
    void feuilleChoix(MouseEvent event) {
    	if(!localGame)
    		choix(2, "Feuille");
    	else
    		localGameChoix(2);
	}

    @FXML
    void ciseauxChoix(MouseEvent event) {
    	if(!localGame)
    		choix(3, "Ciseaux");
    	else
    		localGameChoix(3);
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
    	
    	if(result == 0) {
    		MainController.writeConsole("Egalite");
    		MainController.setTextIndicator("Allez du nerf !");
    	}
    	else if(playerIsMonster && result == 1) {
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
    	
    	else if(!playerIsMonster && result == 1) {
    		MainController.writeConsole("Le chasseur gagne");
    		MainController.setTextIndicator("Vous avez gagne !");
    		Game.PierreFeuilleCiseaux.close();
        	Game.PFC = false;
        	Game.gameFinish = true;
    	}
    	else if(!playerIsMonster && result == -1) {
    		MainController.writeConsole("Le monstre gagne");
    		MainController.setTextIndicator("Le monstre est toujours en fuite !");
    		Game.PierreFeuilleCiseaux.close();
        	Game.PFC = false;
        	MainController.canClick = true;
    	}
    }
    
    private void localGameChoix(int i) {
		if(!theFirstPlayed) {
			choixChasseur = i;
			Game.PierreFeuilleCiseaux.close();
			theFirstPlayed = true;
			
			try{
				Game.PierreFeuilleCiseaux = new Stage();
				FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(getClass().getResource("/cam/ressources/PierreFeuilleCiseauxFenetre.fxml"));
		        Parent parent;
				parent = loader.load();
				Scene scene = new Scene(parent);
				Game.PierreFeuilleCiseaux.setScene(scene);
				Game.PierreFeuilleCiseaux.setAlwaysOnTop(true);
				Game.PierreFeuilleCiseaux.setTitle("Pierre-Feuille-Ciseaux");
				Game.PierreFeuilleCiseaux.show();
				
				Indicator.setText("Au MONSTRE de choisir");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else {
			choixMonstre = i;
			Game.PierreFeuilleCiseaux.close();
			theFirstPlayed = false;
			
			int result = getResult();
			
			Game.PierreFeuilleCiseaux.close();
			
			if(result == 1) {
				MainController.writeConsole("Le chasseur gagne");
	    		MainController.setTextIndicator("Le monstre a perdu !");
	        	Game.PFC = false;
	        	Game.gameFinish = true;
			}
			else if(result == -1) {
				MainController.writeConsole("Le monstre gagne");
	    		MainController.setTextIndicator("Le monstre est toujours en fuite !");
	        	Game.PFC = false;
	        	MainController.canClick = true;
	        	
	        	MainController.game.temporisation("Tour du monstre");
	        	MainController.game.printAllMonster(true);
	    		MainController.setTextIndicator("C'est a votre tour " + MainController.game.getPlateau().getMonstre().getNom());
	    		MainController.writeConsole("TOUR " + MainController.game.getTour());
			}
			else {
				MainController.writeConsole("Egalite");
				
				try{
					Game.PierreFeuilleCiseaux = new Stage();
					FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(getClass().getResource("/cam/ressources/PierreFeuilleCiseauxFenetre.fxml"));
			        Parent parent;
					parent = loader.load();
					Scene scene = new Scene(parent);
					Game.PierreFeuilleCiseaux.setScene(scene);
					Game.PierreFeuilleCiseaux.setAlwaysOnTop(true);
					Game.PierreFeuilleCiseaux.setTitle("Pierre-Feuille-Ciseaux");
					Game.PierreFeuilleCiseaux.show();
					
					Indicator.setText("Au CHASSEUR de choisir");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
