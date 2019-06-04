package cam.main;

import java.io.IOException;

import cam.utils.cases.TrapCase;
import cam.utils.ihm.GameControl;
import cam.utils.ihm.MainController;
import cam.utils.ihm.menu.MenuIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.HunterIA;
import cam.utils.personnages.ia.MonstreIA;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LaunchGame {

	public static void introGame() {
		try {
			launchIHM();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		GameControl.initByMenu();

		Position piege1;
		Position piege2;
		Position piege3;

		MainController.writeConsole("MONSTRE: " + MenuIHM.getNomMonstre());
		MainController.setTextIndicator("Placer votre monstre");

		if (GameControl.joueur1IsMonster) {
			GameControl.poseMonster = true;
		} else
			((MonstreIA) GameControl.joueur2).placeMonster(GameControl.plateau);

		MainController.writeConsole("CHASSEUR: " + MenuIHM.getNomChasseur());

		if (GameControl.joueur1IsMonster) {
			piege1 = ((HunterIA) GameControl.joueur2).posePiege(GameControl.plateau);
			piege2 = ((HunterIA) GameControl.joueur2).posePiege(GameControl.plateau);
			piege3 = ((HunterIA) GameControl.joueur2).posePiege(GameControl.plateau);
		} else {
			MainController.setTextIndicator("Placer vos 3 pieges");
			GameControl.posePiege = true;
		}

	}

	public void StartMainGame() {
			while (!GameControl.gameFinish) {
				
				if(isJoueur1IsMonster()) {
					MainController.removeHunter(GameControl.plateau().getChasseur().getPosition().getX(), GameControl.plateau().getChasseur().getPosition().getY());
					MainController.drawMonster(GameControl.plateau().getMonstre().getPosition().getX(), GameControl.plateau().getMonstre().getPosition().getY());
					tourDuMonstre(GameControl.plateau());
				}
				else
					((MonstreIA) GameControl.joueur2()).ChoosePosition(GameControl.plateau());
				
				if(!isJoueur1IsMonster()) {
					MainController.removeMonster(GameControl.plateau().getChasseur().getPosition().getX(), GameControl.plateau().getChasseur().getPosition().getY());
					MainController.drawHunter(GameControl.plateau().getMonstre().getPosition().getX(), GameControl.plateau().getMonstre().getPosition().getY());
					tourDuChasseur(GameControl.plateau(), (Monstre) getJoueur1(), (Chasseur) GameControl.joueur2());
				}
				else
					((HunterIA) GameControl.joueur2()).ChoosePosition(GameControl.plateau());
		}

	public static void launchIHM() throws IOException {
		Stage primaryStage = new Stage();
		FXMLLoader loaderJEU = new FXMLLoader();
		loaderJEU.setLocation(LaunchGame.class.getResource("/cam/ressources/CAM.fxml"));
		Parent root = loaderJEU.load();

		Scene s = new Scene(root);
		primaryStage.setScene(s);
		primaryStage.setMinHeight(700);
		primaryStage.setMinWidth(700);
		primaryStage.setTitle("Jeu");
		primaryStage.show();
	}
}
