package VersionTerminal;

public class Plateau {

	private Case[][] plateau;
	private int nbLignes, nbColonnes;
	
	public Plateau(int nbLignes, int nbColonnes) {
		this.plateau = new Case[nbLignes][nbColonnes];
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
	}
	
	public int getNbLignes() {
		return nbLignes;
	}
	
	public int getNbColonnes() {
		return nbColonnes;
	}
	
	public Case[][] getPlateau() {
		return plateau;
	}
	
	public void initialize() {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				plateau[i][j] = new Case(i, j, ' ');
			}
		}
		
		int i = (int) (Math.random() * this.nbLignes);
		int j = (int) (Math.random() * this.nbColonnes);
		
		plateau[i][j].setCar('M');
		plateau[i][j].setEstDecouvert(true);
	}
	
	public void afficher() {
		System.out.print("╔═══");
		for (int i = 1; i < plateau[0].length; i++) {
			System.out.print("╦═══");
		}
		System.out.println("╗");
		for (int i = 1; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				System.out.print("║ " + this.plateau[i - 1][j].getCar() + " ");
			}
			System.out.println("║");
			System.out.print("╠═══");
			for (int j = 1; j < plateau[i].length; j++) {
				System.out.print("╬═══");
			}
			System.out.println("╣");
		}
		for (int i = 0; i < plateau[this.nbLignes - 1].length; i++) {
			System.out.print("║ " + this.plateau[this.nbLignes - 1][i].getCar() + " ");
		}
		System.out.println("║");
		System.out.print("╚═══");
		for (int i = 1; i < plateau[this.nbLignes - 1].length; i++) {
			System.out.print("╩═══");
		}
		System.out.println("╝");
	}
	
	public boolean estDécouvert() {
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				if (!this.plateau[i][j].getEstDecouvert()) {
					return false;
				}
			}
		}
		return true;
	}
}


/*
  ╔═══╦═══╗
  ║ M ║   ║
  ╠═══╬═══╣
  ║   ║ O ║
  ╚═══╩═══╝
*/