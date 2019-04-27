package cam.utils.main;

import java.util.Scanner;

public class Menu {
	//ATTRIBUTS
	private static int choix;
	private static String nomChasseur;
	private static String nomMonstre;

	
	public static void main(String[] args) {
		menu();
		System.out.println(getChoixMenu());
		System.out.println(getNomChasseur());
		System.out.println(getNomMonstre());
	}
	
	

	//GETTERS RECUPERATION DU CHOIX
	public static int getChoixMenu() {
		return choix;
	}
	
	public static String getNomChasseur() {
		return nomChasseur;
	}
	
	public static String getNomMonstre() {
		return nomMonstre;
	}
	
	//METHODES
	
	public static void menu() {
		Scanner in = new Scanner(System.in);
		int tmp;
		
		//code du choix
		//si 111 => solo monstre easy
		//si 122 => solo chasseur normal
		//si 2 => multijoueur 
		
		//premier chiffre   : mode de jeu solo/multi 1/2
		//second chiffre    : difficulté (solo uniquement) easy/normal 1/2
		//troisième chiffre : choix du perso (solo uniquement) monstre/chasseur 1/2
		//code 33           : quitter le jeu
		//code 1            : erreur
		
		//menu principal
		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("           MENU PRINCIPAL");
		System.out.println("");
		System.out.println(" Veuillez faire un choix : ");
		System.out.println("     1. Jouer");
		System.out.println("     2. Voir les règles");
		System.out.println("     3. Quitter");
		System.out.println("");
		System.out.println(".....................................");
		tmp = in.nextInt();
		
		if(tmp == 1) {
			gamemode();
		}
		else if(tmp == 2) {
			regles();	
		}
		else if(tmp == 3) {
			choix = 33;
		}
		else {
			choix = 1;
		}
	}
	
	
	
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
	
	private static void gamemode() {
		Scanner in = new Scanner(System.in);
		int tmp;

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("          CHOIX MODE DE JEU ");
		System.out.println("");
		System.out.println("     1.Solo");
		System.out.println("     2.Multijoueur");
		System.out.println("     3.Retour au menu principal");
		System.out.println("");
		System.out.println(".....................................");
		tmp = in.nextInt();
		
		if(tmp == 1) {
			choix = tmp;
			choixPerso();
		}
		if (tmp == 2) {
			choix = tmp;
			noms();
		}
		if (choix == 3) {
			menu();
		}
	}
	
	private static void choixPerso() {
		Scanner in = new Scanner(System.in);
		int tmp;

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("          CHOIX DU PERSONNAGE ");
		System.out.println("");
		System.out.println("     1.Monstre");
		System.out.println("     2.Chasseur");
		System.out.println("");
		System.out.println(".....................................");
		tmp = in.nextInt();
		
		if(tmp == 1) {
			choix = choix*10 + tmp;
			difficulte();
		}
		else if(tmp == 2) {
			choix = choix*10 + tmp;
			difficulte();
		}
		
	}
	
	private static void difficulte() {
		Scanner in = new Scanner(System.in);
		int tmp;

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("        CHOIX DE LA DIFFICULTE ");
		System.out.println("");
		System.out.println("     1.Easy");
		System.out.println("     2.Normal");
		System.out.println("");
		System.out.println(".....................................");
		tmp = in.nextInt();
		
		if(tmp == 1) {
			choix = choix*10 + tmp;
		}
		else if(tmp == 2) {
			choix = choix*10 + tmp;
		}
	}
	
	private static void noms() {
		Scanner in = new Scanner(System.in);

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("   ENTREZ UN NOM POUR LE CHASSEUR ");

		nomChasseur = in.nextLine();

		
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("   ENTREZ UN NOM POUR LE MONSTRE ");
		
		nomMonstre = in.nextLine();		
	}
	
	
	
	
	
	
	
	private static void clearScreen() {
		for(int i=0 ; i<100 ; i++) {
			System.out.println("\n");
		}
	}

}
