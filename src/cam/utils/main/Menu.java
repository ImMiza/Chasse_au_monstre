package cam.utils.main;

/**
 * Class permettant de creer le menu et recuperer les choix faits par le joueur
 * @author Adrien BASSAIL
 */

import java.util.Scanner;

public class Menu {
	//ATTRIBUTS
	private static int choix;
	private static String nomChasseur;
	private static String nomMonstre;


	/**
	 * Codage du choix :
	 * Exemples :
	 * si 111 : solo / monstre / easy
	 * si 122 : solo / chasseur / normal
	 * si 2 : multijoueur
	 * 
	 * Premier chiffre    : mode de jeu solo/multijoueur 1/2
	 * Second chiffre     : choix du personnage monstre/chasseur 1/2
	 * Troisième chfiffre : choix de la difficulté easy/normal 1/2
	 * Code 33            : quitter le jeu
	 * Code 1             : erreur
	 * 
	 * @return Le code choix que la personne a fait dans le menu
	 */
	public static int getChoixMenu() {
		return choix;
	}

	/**
	 * @return Le nom que le Chasseur à choisi
	 */
	public static String getNomChasseur() {
		return nomChasseur;
	}

	/**
	 * @return Le nom que le Monstre a choisi 
	 */
	public static String getNomMonstre() {
		return nomMonstre;
	}

	//METHODES

	/**
	 * Affichage et choix sur le menu principal
	 */
	public static void menu() {
		Scanner in = new Scanner(System.in);
		String tmp = "";
		boolean firstAff = false;

		while(!tmp.equals("1") && !tmp.equals("2") && !tmp.equals("3") || firstAff == false) {
			clearScreen();
			firstAff = true;
			System.out.println("..........CHASSE AU MONSTRE..........");
			System.out.println("           MENU PRINCIPAL");
			System.out.println("");
			System.out.println(" Veuillez faire un choix : ");
			System.out.println("     1. Jouer");
			System.out.println("     2. Voir les règles");
			System.out.println("     3. Quitter");
			System.out.println("");
			System.out.println(".....................................");
			tmp = in.nextLine();
		}

		if(Integer.parseInt(tmp) == 1) {
			gamemode();
		}
		else if(Integer.parseInt(tmp) == 2) {
			regles();	
		}
		else if(Integer.parseInt(tmp) == 3) {
			choix = 33;
		}
		else {
			choix = 1;
		}
	}


	/**
	 * Affichage et choix dans les regles du jeu
	 */
	private static void regles() {
		Scanner in = new Scanner(System.in);

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("           REGLES DU JEU");
		System.out.println("Appuyez sur une touche pour revenir au menu principal");
		System.out.println("");
		System.out.println("coucou cest les regles du jeu");
		System.out.println("");
		System.out.println(".....................................");
		in.nextLine();
		menu();	
	}

	/**
	 * Affichage et choix du mode de jeu
	 */
	private static void gamemode() {
		Scanner in = new Scanner(System.in);
		String tmp = "";
		boolean firstAff = false;

		while(!tmp.equals("1") && !tmp.equals("2") && !tmp.equals("3") || firstAff == false) {
			clearScreen();
			firstAff = true;
			System.out.println("..........CHASSE AU MONSTRE..........");
			System.out.println("          CHOIX MODE DE JEU ");
			System.out.println("");
			System.out.println("     1.Solo");
			System.out.println("     2.Multijoueur");
			System.out.println("     3.Retour au menu principal");
			System.out.println("");
			System.out.println(".....................................");
			tmp = in.nextLine();
		}

		if(Integer.parseInt(tmp) == 1) {
			choix = Integer.parseInt(tmp);
			choixPerso();
		}
		else if (Integer.parseInt(tmp) == 2) {
			choix = Integer.parseInt(tmp);
			noms();
		}
		else if (Integer.parseInt(tmp) == 3) {
			menu();
		}
		else {
			choix = 1;
		}
	}

	/**
	 * Affichage et choix du personnage (multijoueur)
	 */
	private static void choixPerso() {
		Scanner in = new Scanner(System.in);
		String tmp = "";
		boolean firstAff = false;

		while(!tmp.equals("1") && !tmp.equals("2") || firstAff == false) {
			clearScreen();
			firstAff = true;
			System.out.println("..........CHASSE AU MONSTRE..........");
			System.out.println("          CHOIX DU PERSONNAGE ");
			System.out.println("");
			System.out.println("     1.Monstre");
			System.out.println("     2.Chasseur");
			System.out.println("");
			System.out.println(".....................................");
			tmp = in.nextLine();
		}
		if(Integer.parseInt(tmp) == 1) {
			choix = choix*10 + Integer.parseInt(tmp);
			nomMonstre();
			difficulte();
		}
		else if(Integer.parseInt(tmp) == 2) {
			choix = choix*10 + Integer.parseInt(tmp);
			nomChasseur();
			difficulte();
		}
		else {
			choix = 1;
		}
	}

	/**
	 * Affichage et choix de la difficulté (solo uniquement)
	 */
	private static void difficulte() {
		Scanner in = new Scanner(System.in);
		String tmp = "";
		boolean firstAff = false;

		while(!tmp.equals("1") && !tmp.equals("2") || firstAff == false) {
			clearScreen();
			firstAff = true;
			System.out.println("..........CHASSE AU MONSTRE..........");
			System.out.println("        CHOIX DE LA DIFFICULTE ");
			System.out.println("");
			System.out.println("     1.Easy");
			System.out.println("     2.Normal");
			System.out.println("");
			System.out.println(".....................................");
			tmp = in.nextLine();
		}
		if(Integer.parseInt(tmp) == 1) {
			choix = choix*10 + Integer.parseInt(tmp);
		}
		else if(Integer.parseInt(tmp) == 2) {
			choix = choix*10 + Integer.parseInt(tmp);
		}
		else {
			choix = 1;
		}
	}

	/**
	 * Affichage et choix des noms des personnages (multijoueur uniquement)
	 */
	private static void noms() {
		nomChasseur();
		nomMonstre();
	}

	/**
	 * Choix du nom du chasseur 
	 */
	private static void nomChasseur() {
		Scanner in = new Scanner(System.in);

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("   ENTREZ UN NOM POUR LE CHASSEUR ");

		nomChasseur = in.nextLine();
	}

	/**
	 * Choix du nom du monstre
	 */
	private static void nomMonstre() {
		Scanner in = new Scanner(System.in); 

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("   ENTREZ UN NOM POUR LE MONSTRE ");

		nomMonstre = in.nextLine();	
	}

	/**
	 * Permet de nettoyer l'écran avant d'afficher la suite du menu / sous-menu
	 */
	private static void clearScreen() {
		for(int i=0 ; i<100 ; i++) {
			System.out.println("\n");
		}
	}
}
