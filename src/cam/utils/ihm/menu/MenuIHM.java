package cam.utils.ihm.menu;

public class MenuIHM {
	//ATTRIBUTS
	private static int personnage = 0;
	private static int difficulte = 0;
	private static int modeDeJeu = 0;
	private static String nomMonstre = "";
	private static String nomChasseur = "";
	private static int deplacementVerticalMonstre = 2;
	private static int deplacementHorizontalMonstre = 2;
	private static int deplacementDiagonaleMonstre = 1;
	private static int tailleXPlateau;
	private static int tailleYPlateau;
	
	
	//METHODES

	/**
	 * 0 Non défini
	 * 1 Solo
	 * 2 Multijoueur
	 */
	public static void setModeDeJeu(int i) {
		modeDeJeu = i;
	}
	
	/**
	 * 0 Non défini
	 * 1 Niveau de difficulté 1 (easy)
	 * 2 Niveau de difficulté 2 (normal)
	 * 3 Niveau de difficulté 3 (difficile)
	 */
	public static void setDifficulte(int i) {
		difficulte = i;
	}
	
	/**
	 * 0 Non défini
	 * 2 Chasseur
	 * 1 Monstre
	 */
	public static void setPersonnage(int i) {
		personnage = i;
	}
	
	/**
	 * Nom du monstre, par défaut vide ""
	 */
	public static void setNomMonstre(String nom) {
		nomMonstre = nom;
	}
	
	/**
	 * Nom du chasseur, par défaut vide ""
	 */
	public static void setNomChasseur(String nom) {
		nomChasseur = nom;
	}
	
	/**
	 * Donne les deplacements possibles pour le monstre verticalement
	 * Maximum égal à 4
	 * Minimum égal à 1
	 */
	public static void setDeplacementVerticalMonstre(int i) {
		if(i > 4) {
			deplacementVerticalMonstre = 4;
		}
		else if(i < 1) {
			deplacementVerticalMonstre = 1;
		}
		else {
			deplacementVerticalMonstre = i;
		}
	}
	
	/**
	 * Donne les deplacements possibles pour le monstre horizontalement
	 * Maximum égal à 4
	 * Minimum égal à 1
	 */
	public static void setDeplacementHorizontalMonstre(int i) {
		if(i > 4) {
			deplacementHorizontalMonstre = 4;
		}
		else if(i < 1) {
			deplacementHorizontalMonstre = 1;
		}
		else {
			deplacementHorizontalMonstre = i;
		}
	}
	
	/**
	 * Donne les dplacements possibles pour le monstre en diagonale
	 * Maximum égal à 4
	 * Minimum égal à 0
	 */
	public static void setDeplacementDiagonaleMonstre(int i) {
		if (i > 4) {
			deplacementDiagonaleMonstre = 4;
		}
		else if(i < 0) {
			deplacementDiagonaleMonstre = 0;
		}
		else {
			deplacementDiagonaleMonstre = i;
		}
	}
	
	/**
	 * Donne la taille du plateau en X
	 * Minimum égal à 4
	 * Maximum égal à 20
	 */
	public static void setTailleXPlateau(int i) {
		if(i < 4) {
			tailleXPlateau = 4;
		}
		else if(i > 20) {
			tailleXPlateau = 20;
		}
		else {
			tailleXPlateau = i;
		}
	}
	
	/**
	 * Minimum égal à 4
	 * Maximum égal à 20
	 */
	public static void setTailleYPlateau(int i) {
		if(i < 4) {
			tailleYPlateau = 4;
		}
		else if(i > 20) {
			tailleYPlateau = 20;
		}
		else {
			tailleYPlateau = i;
		}
	}
	
	//GETTERS
	public static int getPersonnage() {
		return personnage;
	}

	public static int getDifficulte() {
		return difficulte;
	}

	public static int getModeDeJeu() {
		return modeDeJeu;
	}
	
	public static String getNomMonstre() {
		return nomMonstre;
	}

	public static String getNomChasseur() {
		return nomChasseur;
	}
	
	public static int getDeplacementVerticalMonstre() {
		return deplacementVerticalMonstre;
	}

	public static int getDeplacementHorizontalMonstre() {
		return deplacementHorizontalMonstre;
	}

	public static int getDeplacementDiagonaleMonstre() {
		return deplacementDiagonaleMonstre;
	}

	public static int getTailleXPlateau() {
		return tailleXPlateau;
	}

	public static int getTailleYPlateau() {
		return tailleYPlateau;
	}
}
