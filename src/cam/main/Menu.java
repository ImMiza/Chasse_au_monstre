package cam.main;

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
		@SuppressWarnings("resource")
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
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		clearScreen();
		System.out.println("..........CHASSE AU MONSTRE..........");
		System.out.println("           REGLES DU JEU");
		System.out.println("Appuyez sur une touche pour revenir au menu principal");
		System.out.println("");
		System.out.println("Chasse au monstre est un jeu à 2 joueurs contenant un plateau de jeu, un monstre et un chasseur");
		System.out.println("");
		System.out.println("BUT DU JEU :");
		System.out.println("Le but du MONSTRE est de parcourir toutes les cases de jeu sans se faire attraper par le chasseur");
		System.out.println("Le but du CHASSEUR est d'attraper le monstre avant que celui-ci parcourt tout le plateau de jeu.");
		System.out.println("");
		System.out.println("DEROULEMENT DU JEU :");
		System.out.println("Premièrement, avant de commencer la partie, le chasseur doit poser 3 pièges sur le plateau,");
		System.out.println("en entrant les coordonnées de chacune d'entre elles.");
		System.out.println("Ensuite, toujours avant le début du jeu, le monstre aura le choix de se positionner dans une extrémité");
		System.out.println("du plateau.");
		System.out.println("Place au jeu, le chasseur et le monstre vont jouer chacun leur tour, le monstre se déplacera en entrant des");
		System.out.println("coordonnées (celles des cases possibles autour de lui), et le chasseur rentrera lui les coordonées de son choix");
		System.out.println("sur le plateau, essayant de trouver le monstre.");
		System.out.println("Si le chasseur trouve le monstre, il y aura un Pierre-Feuille-Ciseaux, si le chasseur gagne, alors la partie est terminée.");
		System.out.println("Si le monstre gagne, alors la partie continue laissant un déplacement au monstre pour s'enfuir");
		System.out.println("");
		System.out.println("NOTATIONS DU PLATEAU :");
		System.out.println("   - M : Monstre");
		System.out.println("   - P : Possible (les cases possibles de déplacement pour le monstre");
		System.out.println("   - C : Chasseur");
		System.out.println("   - E : Effet (les cases avec un effet)");
		System.out.println("   - V : Visité (les cases ou le monstre est déjà passé");
		System.out.println(".....................................");
		in.nextLine();
		menu();	
	}

	/**
	 * Affichage et choix du mode de jeu
	 */
	private static void gamemode() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String tmp = "";
		boolean firstAff = false;

		while(!tmp.equals("1") && !tmp.equals("2") && !tmp.equals("3") || firstAff == false) {
			clearScreen();
			firstAff = true;
			System.out.println("..........CHASSE AU MONSTRE..........");
			System.out.println("          CHOIX MODE DE JEU ");
			System.out.println("");
			//System.out.println("     Solo");
			System.out.println("     1.Multijoueur");
			System.out.println("     2.Retour au menu principal");
			System.out.println("");
			System.out.println(".....................................");
			tmp = in.nextLine();
		}

		//if(Integer.parseInt(tmp) == 1) {
		//	choix = Integer.parseInt(tmp);
		//	choixPerso();
		//}
		if (Integer.parseInt(tmp) == 1) {
			choix = 2;
			noms();
		}
		else if (Integer.parseInt(tmp) == 2) {
			menu();
		}
		else {
			choix = 1;
		}
	}

	/**
	 * Affichage et choix du personnage (multijoueur)
	 */
	@SuppressWarnings("unused")
	private static void choixPerso() {
		@SuppressWarnings("resource")
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
		@SuppressWarnings("resource")
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
		@SuppressWarnings("resource")
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
		@SuppressWarnings("resource")
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
