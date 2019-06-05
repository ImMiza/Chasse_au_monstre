package cam.utils.ihm.menu;

/**
 * Classe qui permet de récupérer et controler toutes les informations définies dans le menu
 * et rendre ses informations accesibles partout dans le code
 * @author Adrien Bassail
 */

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
	private static int tailleXPlateau = 10;
	private static int tailleYPlateau = 10;
	
	
	//METHODES

	/**
	 * Permet de définir le mode de jeu :
	 * 0 Non défini
	 * 1 Solo
	 * 2 Multijoueur
	 * @param i : nouvelle valeur
	 */
	public static void setModeDeJeu(int i) {
		//System.out.println("i : " + i);
		modeDeJeu = i;
		//System.out.println("mdj : " +modeDeJeu);
	}
	
	/**
	 * Permet de définir le niveau de difficulté :
	 * 0 Non défini
	 * 1 Niveau de difficulté 1 (easy)
	 * 2 Niveau de difficulté 2 (normal)
	 * 3 Niveau de difficulté 3 (difficile)
	 * @param i : nouvelle valeur
	 */
	public static void setDifficulte(int i) {
		difficulte = i;
	}
	
	/**
	 * Permet de définir le personnage choisi (solo uniquement)
	 * 0 Non défini
	 * 2 Chasseur
	 * 1 Monstre
	 * @param i : nouvelle valeur
	 */
	public static void setPersonnage(int i) {
		personnage = i;
	}
	
	/**
	 * Nom du monstre, par défaut vide ""
	 * @param nom : nouvelle valeur
	 */
	public static void setNomMonstre(String nom) {
		nomMonstre = nom;
	}
	
	/**
	 * Nom du chasseur, par défaut vide ""
	 * @param nom : nouvelle valeur
	 */
	public static void setNomChasseur(String nom) {
		nomChasseur = nom;
	}
	
	/**
	 * Permet de définir le nombre de déplacements max verticalement pour le monstre 
	 * Maximum égal à 4
	 * Minimum égal à 1
	 * @param i : nouvelle valeur
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
	 * Permet de définir le nombre de déplacements max horizontalement pour le monstre 
	 * Maximum égal à 4
	 * Minimum égal à 1
	 * @param i : nouvelle valeur
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
	 * Permet de définir le nombre de déplacements max diagonale pour le monstre 
	 * Maximum égal à 4
	 * Minimum égal à 0
	 * @param i : nouvelle valeur
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
	 * Permet de définir la taille du plateau max en X
	 * Minimum égal à 4
	 * Maximum égal à 20
	 * @param i : nouvelle valeur
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
	 * Permet de définir la taille max du plateau en Y
	 * Minimum égal à 4
	 * Maximum égal à 20
	 * @param i : nouvelle valeur
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
	/**
	 * Permet de récupérer le personnage choisi (solo uniquement)
	 * 0 Non défini
	 * 2 Chasseur
	 * 1 Monstre
	 * @return l'attribut personnage
	 */
	public static int getPersonnage() {
		return personnage;
	}
	
	/**
	 * Permet de récupérer le niveau de difficulté :
	 * 0 Non défini
	 * 1 Niveau de difficulté 1 (easy)
	 * 2 Niveau de difficulté 2 (normal)
	 * 3 Niveau de difficulté 3 (difficile)
	 * @return l'attrubut difficulte
	 */
	public static int getDifficulte() {
		return difficulte;
	}

	/**
	 * Permet de récupérer le mode de jeu :
	 * 0 Non défini
	 * 1 Solo
	 * 2 Multijoueur
	 * @return l'attribut modeDeJeu
	 */
	public static int getModeDeJeu() {
		return modeDeJeu;
	}
	
	/**
	 * Permet de récupérer le nom du monstre
	 * @return l'attribut nomMonstre
	 */
	public static String getNomMonstre() {
		return nomMonstre;
	}

	/**
	 * Permet de récupérer le nom du chasseur
	 * @return l'attribut nomChasseur
	 */
	public static String getNomChasseur() {
		return nomChasseur;
	}
	
	/**
	 * Permet de récupérer le nombre de déplacements max verticalement pour le monstre 
	 * Maximum égal à 4
	 * Minimum égal à 1
	 * @return l'attribit deplacementVerticalMonstre
	 */
	public static int getDeplacementVerticalMonstre() {
		return deplacementVerticalMonstre;
	}

	/**
	 * Permet de récupérer le nombre de déplacements max horizontalement pour le monstre 
	 * Maximum égal à 4
	 * Minimum égal à 1
	 * @return l'attribit deplacementHorizontalMonstre
	 */
	public static int getDeplacementHorizontalMonstre() {
		return deplacementHorizontalMonstre;
	}

	/**
	 * Permet de récupérer le nombre de déplacements max diagonale pour le monstre 
	 * Maximum égal à 4
	 * Minimum égal à 1
	 * @return l'attribit deplacementDiagonaleMonstre
	 */
	public static int getDeplacementDiagonaleMonstre() {
		return deplacementDiagonaleMonstre;
	}

	/**
	 * Permet de récupérer la taille du plateau max en X
	 * Minimum égal à 4
	 * Maximum égal à 20
	 * @return l'attribut tailleXPlateau
	 */
	public static int getTailleXPlateau() {
		return tailleXPlateau;
	}

	/**
	 * Permet de récupérer la taille du plateau max en Y
	 * Minimum égal à 4
	 * Maximum égal à 20
	 * @return l'attribut tailleYPlateau
	 */
	public static int getTailleYPlateau() {
		return tailleYPlateau;
	}
}
