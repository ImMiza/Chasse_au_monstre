package cam.main;

import java.util.Scanner;

import cam.utils.personnages.Personnage;

/**
 * Cette classe est utilisee au moment de la rencontre du chasseur avec le monstre (quand ils sont tout
 * les 2 dans la meme case)
 * Elle permet de faire le celebre jeu du Pierre Feuille Ciseaux.
 * Ce qui influencera sur la suite de la partie selon le gagnant
 * @author Boukhebza Allan
 */
public class PierreFeuilleCiseaux
{
	private Personnage perso1; //joueur 1
	private Personnage perso2; //joueur 2
	
	private Personnage winner; //le gagnant
	
	
	/**
	 * Constructeur permettant d'etablir une partie de Pierre Feuille Ciseaux
	 * @param perso1 le premier joueur
	 * @param perso2 le deuxieme joueur
	 */
	public PierreFeuilleCiseaux(Personnage perso1, Personnage perso2)
	{
		this.perso1 = perso1;
		this.perso2 = perso2;
		this.winner = null;
	}
	
	/**
	 * Une fois la classe initialisee, cette methode permet de lancer la partie
	 * de Pierre Feuille Ciseaux
	 */
	public void startGame() {
		if(this.perso1 == null || this.perso2 == null) {
			System.out.println("Manque de joueur");
			return;
		}

		int choixPerso1, choixPerso2;
		
		do {
			
			System.out.println(this.perso1.getNom() + ", c'est à votre tour !");
			System.out.println(list());
			choixPerso1 = getEntry();
			
			for(int i = 0 ; i < 100; i++)
				System.out.println();
			
			System.out.println(this.perso2.getNom() + ", c'est à votre tour !");
			System.out.println(list());
			choixPerso2 = getEntry();
			
			this.winner = defineWinner(choixPerso1, choixPerso2);
			
			if(this.winner == null)
				System.out.println("EGALITE");
			
		} while(this.winner == null);
		
		System.out.println(this.winner.getNom() + " a gagne le Pierre-Feuille-Ciseaux !");
		
	}
	
	/**
	 * Classe privee permettant de definir le gagnant par rapport a leur choix
	 * et aux regles du Pierre Feuille Ciseaux
	 * @param choixPerso1 le choix du joueur 1 (Pierre(1), Feuille(2), Ciseaux(3))
	 * @param choixPerso2 le choix du joueur 2 (Pierre(1), Feuille(2), Ciseaux(3))
	 * @return le joueur gagnant, <b>null</b> si egalite 
	 */
	private Personnage defineWinner(int choixPerso1, int choixPerso2)
	{
		if(choixPerso1 == choixPerso2)
			return null;
		
		else if((choixPerso1 == 1 && choixPerso2 == 3) || (choixPerso1 == 2 && choixPerso2 == 1) || (choixPerso1 == 3 && choixPerso2 == 2))
			return this.perso1;
		
		else
			return this.perso2;
	}

	/**
	 * @return la liste des choix (Pierre(1), Feuille(2), Ciseaux(3))
	 */
	private String list() {
		return "1 = Pierre \n"
				+ "2 = Feuille \n"
				+ "3 = Ciseaux";
	}
	
	/**
	 * Permet la saisie du choix (Pierre(1), Feuille(2), Ciseaux(3)) tout en controlant la saisie pour eviter
	 * tout problemes
	 * @return le choix du joueur
	 */
	private int getEntry() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String text;
		
		char entry;
		
		do{
			text = sc.nextLine();
			entry = (!text.equals("")) ? text.charAt(0) : '0';
		}while(entry < '1' || entry > '3');
		
		return Integer.parseInt("" + entry);
	}
	
	/**
	 * Permet de changer de joueur 1
	 * @param perso1 le joueur 1
	 */
	public void changeFirstPlayer(Personnage perso1) {
		this.perso1 = perso1;
	}
	
	/**
	 * Permet de changer de joueur 2
	 * @param perso1 le joueur 2
	 */
	public void changeSecondPlayer(Personnage perso2) {
		this.perso2 = perso2;
	}
	
	/**
	 * @return true si il y a un gagnant, sinon false
	 */
	public boolean hasWinner() {
		return this.winner != null;
	}
	
	/**
	 * @return le joueur ayant gagner la partie
	 */
	public Personnage getWinner() {
		return this.winner;
	}
	
	/**
	 * @return le joueur 1
	 */
	public Personnage getFirstPlayer()
	{
		return perso1;
	}
	
	/**
	 * @return le joueur 2
	 */
	public Personnage getSecondPlayer()
	{
		return perso2;
	}
}
