package cam.utils.tests;

import cam.utils.main.PierreFeuilleCiseaux;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;

public class TestPierreFeuilleCiseaux
{

	public static void main(String[] args)
	{
		Chasseur joueur1 = new Chasseur(0, 0, "Allan");
		Monstre joueur2 = new Monstre(0, 0, "Adrien");
		
		PierreFeuilleCiseaux game = new PierreFeuilleCiseaux(joueur1, joueur2);
		
		System.out.println("Un gagnant ?: " + game.hasWinner());
		System.out.println("joueur 1 : " + game.getFirstPlayer().getNom());
		System.out.println("joueur 2 : " + game.getSecondPlayer().getNom());
		
		System.out.println();
		System.out.println("LANCEMENT DE LA PARTIE");
		game.startGame();
		
		System.out.println();
		System.out.println("Un gagnant ?: " + game.hasWinner());
		
		if(game.hasWinner())
			System.out.println("Gagnant: " + game.getWinner().getNom());
	}
}
