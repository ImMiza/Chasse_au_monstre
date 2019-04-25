package cam.utils.plateau;

import java.util.ArrayList;
import java.util.List;

import cam.utils.cases.Case;
import cam.utils.personnages.Chasseur;
import cam.utils.personnages.Monstre;

public class Plateau {
	/**
	 * Classe qui détermine le fonctionnement du plateau de jeu
	 * @author Hugo Wieder
	 */
	 
	// ATTRIBUTS
	private Monstre monstre;
	private Chasseur chasseur;
	private Case[][] plateau;
	
	// CONSTRUCTEURS
	/**
	 * Constructeur d'une instance de Plateau
	 * @param monstre
	 * @param chasseur
	 * @param nbLignes
	 * @param nbColonnes
	 */
	public Plateau(Monstre monstre, Chasseur chasseur, int nbLignes, int nbColonnes) {
		this.monstre = monstre;
		this.chasseur = chasseur;
		this.plateau = new Case[nbLignes][nbColonnes];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				plateau[i][j] = new Case();
			}
		}
	}
	/**
	 * Constructeur d'une instance de Plateau
	 * @param monstre
	 * @param chasseur
	 * @param unPlateau
	 */
	public Plateau(Monstre monstre, Chasseur chasseur, Case[][] unPlateau) {
		this.monstre = monstre;
		this.chasseur = chasseur;
		this.plateau = unPlateau;
	}
	
	
	
	public Case[][] getPlateau() {
		return plateau;
	}
	
	// METHODES
	/**
	 * Renvoie la liste de toutes les cases où le déplacement est possible en partant de la case mise en paramètre
	 * @param caseDeDepart
	 * @return uneListe
	 */
	public List<Case> deplacementsPossible(){
		Case caseDeDepart = chercheCase(this.monstre.getPosition().getX(), this.monstre.getPosition().getY());
		ArrayList<Case> res = new ArrayList<Case>();
		int[] coordonneesCase = this.chercheCase(caseDeDepart);
		if (coordonneesCase == null) return null;
		int i = coordonneesCase[0], j = coordonneesCase[1];
		
		res.addAll(deplacementDiagonale(i, j));
		res.addAll(deplacementVertical(i,j));
		res.addAll(deplacementHorizontal(i, j));
		
		while(!sontToutesLibres(res)) {
			boolean trouvee = false; int k = 0;
			while (!trouvee && k<res.size()) {
				if(res.get(k).isVisited()) {
					trouvee=true;
					res.remove(k);
				}
				k++;
			}
		}
		return res;
	}
	
	public void deplacerMonstre(Case uneCase) {
		
	}
	
	/**
	 * Verifie que toutes les cases de maListe n'ont jamais etees visitees par le monstre
	 * @param maListe
	 * @return 
	 */
	private boolean sontToutesLibres(List<Case> maListe) {
		for (int i = 0; i< maListe.size(); i++) {
			if(maListe.get(i).isVisited()) return false;
		}
		return true;
	}
	
	/**
	 * Verifie l'appartenance d'une case au plateau
	 * @param ligne
	 * @param colonne
	 * @return Boolean true si la case d'indice [ligne][colonne] appartient au plateau
	 */
	private boolean appartientAuPlateau(int ligne, int colonne) {
		return (ligne>=0 && ligne <this.plateau.length) && (colonne >=0 && colonne < this.plateau[0].length);
	}
	
	private void ajoute(List<Case> uneListe, int ligne, int colonne) {
		if (appartientAuPlateau(ligne, colonne)) {
			uneListe.add(this.chercheCase(ligne, colonne));
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return Renvoie tous les deplacements diagonnaux possibles
	 */
	private List<Case> deplacementDiagonale(int ligne, int colonne){
		List<Case> maListe = new ArrayList<Case>();
		if (ligne == 0) {
			ajoute(maListe, ligne + this.monstre.getDeplacementDiagonal(), colonne + this.monstre.getDeplacementDiagonal());
			ajoute(maListe, ligne + this.monstre.getDeplacementDiagonal(), colonne - this.monstre.getDeplacementDiagonal());
			ajoute(maListe, ligne - this.monstre.getDeplacementDiagonal(), colonne + this.monstre.getDeplacementDiagonal());
			ajoute(maListe, ligne - this.monstre.getDeplacementDiagonal(), colonne - this.monstre.getDeplacementDiagonal());
		}
		return maListe;
	}
	/**7
	 * 
	 * @param i
	 * @param j
	 * @return Renvoie tous les deplacements Verticaux possibles
	 */
	private List<Case> deplacementVertical(int ligne, int colonne){
		List<Case> maListe = new ArrayList<Case>();
		for (int i = 0; i<this.monstre.getDeplacementVertical(); i++) {
			ajoute(maListe, ligne + i+1, colonne);
			ajoute(maListe, ligne - (i+1), colonne);
		}
		return maListe;
	}
	/**
	 * 
	 * @param i
	 * @param j
	 * @return Renvoie tous les deplacements horizontaux possibles
	 */
	private List<Case> deplacementHorizontal(int ligne, int colonne){
		List<Case> maListe = new ArrayList<Case>();
		for (int i = 0; i<this.monstre.getDeplacementHorizontal(); i++) {
			ajoute(maListe, ligne, colonne + i+1);
			ajoute(maListe, ligne, colonne - (i+1));
		}
		
		return maListe;
	}
	
	/**
	 * Methode privee permettant de renvoyer les coordonnees de la case mise en parametre
	 * @exception Renvoie null si la case n'appartient pas au plateau
	 * @param uneCase
	 * @return coordonnees
	 */
	private int[] chercheCase(Case uneCase) {
		for (int i = 0; i<this.plateau.length; i++) {
			for (int j=0; j<this.plateau[0].length; i++) {
				if(this.plateau[i][j] == uneCase) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}
	
	/**
	 * Methode privee permettant de renvoyer la case de coordonees rentrees en parametre
	 * @exception renvoie null si les coordonnees ne sont pas valides(n'appartiennent pas au plateau)
	 * @param i
	 * @param j
	 * @return
	 */
	private Case chercheCase(int i, int j) {
		if((i<this.plateau.length && j<this.plateau[0].length) && (i>=0 && j>=0)) {
			return this.plateau[i][j];
		}
		return null;
	}
	
	public void printPlateau() {
		char[][] plateau = new char[this.plateau.length][this.plateau[0].length];
		
		for(Case cas : deplacementsPossible()) {
			int[] coord = chercheCase(cas);
			plateau[coord[0]][coord[1]] = 'P';
		}
		
		for(int i = 0; i < this.plateau.length; i++) {
			for(int j = 0; j < this.plateau[0].length; j++) {
				if(this.plateau[i][j].isVisited()) {
					plateau[i][j] = 'V';
				}
				else {
					plateau[i][j] = ' ';
				}
			}
		}
		
		plateau[monstre.getPosition().getX()][monstre.getPosition().getY()] = 'M';
		
		System.out.print("╔═══");
        for (int i = 1; i < plateau[0].length; i++) {
            System.out.print("╦═══");
        }
        System.out.println("╗");
        for (int i = 1; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print("║ " + plateau[i][j] + " ");
            }
            System.out.println("║");
            System.out.print("╠═══");
            for (int j = 1; j < plateau[i].length; j++) {
                System.out.print("╬═══");
            }
            System.out.println("╣");
        }
        for (int i = 0; i < plateau[plateau.length - 1].length; i++) {
            System.out.print("║ " + plateau[plateau.length - 1][i] + " ");
        }
        System.out.println("║");
        System.out.print("╚═══");
        for (int i = 1; i < plateau[plateau.length - 1].length; i++) {
            System.out.print("╩═══");
        }
        System.out.println("╝");
	}
}
