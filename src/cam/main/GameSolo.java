package cam.main;

import java.util.Scanner;

import cam.utils.cases.TrapCase;
import cam.utils.ihm.CaseIHM;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;
import cam.utils.personnages.Personnage;
import cam.utils.personnages.Position;
import cam.utils.personnages.ia.IA;
import cam.utils.plateau.Plateau;

public abstract class GameSolo {

	private static Scanner in = new Scanner(System.in);
	
	private CaseIHM[][] cases;
	private Personnage joueur;
	private IA bot;
	
	private Plateau plateau;
	
	public GameSolo(int width, int height) {
		this.cases = new CaseIHM[width][height];
		initByMenu();
	}
	
	public void start() {
		Position piege1;
		Position piege2;
		Position piege3;

		System.out.println("MONSTRE : " + Menu.getNomMonstre());
		monstre.setNom(Menu.getNomMonstre());
		
		placeMonstre(monstre, plateau);
		
		clearScreen();
		
		System.out.println("CHASSEUR : " + Menu.getNomChasseur());
		chasseur.setNom(Menu.getNomChasseur());
		
		System.out.println("1er piege :");
		piege1 = posePiege();
		
		System.out.println("2eme piege :");
		piege2 = posePiege();

		System.out.println("3eme piege :");
		piege3 = posePiege();

		clearScreen();
		
		plateau.getPlateau()[piege1.getX()][piege1.getY()] = new TrapCase();
		plateau.getPlateau()[piege2.getX()][piege2.getY()] = new TrapCase();
		plateau.getPlateau()[piege3.getX()][piege3.getY()] = new TrapCase();
		
		while (!finDuJeu) {
			tourDuMonstre(plateau);
			clearScreen();
			tourDuChasseur(plateau, monstre, chasseur);
			clearScreen();
		}
	}
	
	public void initByMenu() {
		
	}
	
	public GameSolo() {
		this(10,10);
	}
	
	/**
	 * Permet de poser un piege pour le chasseur
	 * @return la position du piege
	 */
	public static Position posePiege() {
		int X;
		do {
			System.out.print("Ligne (entre 1 et 8) : ");
			X = getSecureInt(1, 8);
		}while(X < 1 || X > 8);
		
		int Y;
		do {
			System.out.print("Colonne (entre 1 et 8) : ");
			Y = getSecureInt(1, 8);
		}while(Y < 1 || Y > 8);
		
		return new Position(X, Y);
	}
	
	/**
	 * Permet de recuperer un entier de facon securise et de 
	 * façon delimitee
	 * @param min la borne minimum
	 * @param max la borne maximum
	 * @return un entier
	 */
	public static int getSecureInt(int min, int max) {
		String entry;
		int n = min - 1;
		
		do {
			entry = in.nextLine();
			if(isNumber(entry))
				n = Integer.parseInt(entry);
			
		}while(n < min || n > max);
		
		return n;
	}
	
	/**
	 * Permet de verifier si une phrase est aussi un chiffre
	 * @param number la phrase a tester
	 * @return true si c'est que des chiffres, sinon false
	 */
	public static boolean isNumber(String number) {
		if(number.equals(""))
			return false;
		
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) < '0' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
