package cam.utils.main;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		int resMenu = menu();
		System.out.println(resMenu);

	}
	
	public static int menu() {
		Scanner in = new Scanner(System.in);
		int choix;
		
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
		choix = in.nextInt();
		
		if(choix == 2) {
			regles();	
		}
		
		if(choix == 3) {
			return 33;
		}
		
		return 0;
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
	
	private static void clearScreen() {
		for(int i=0 ; i<100 ; i++) {
			System.out.println("\n");
		}
	}

}
