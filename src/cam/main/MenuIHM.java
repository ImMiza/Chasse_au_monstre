package cam.main;

public class MenuIHM {
	//ATTRIBUTS
	private static int personnage = 0;
	private static int difficulte = 0;
	private static int modeDeJeu = 0;
	private static String nomMonstre = "";
	private static String nomChasseur = "";
	
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
	
	public static void setNomMonstre(String nom) {
		nomMonstre = nom;
	}
	
	public static void setNomChasseur(String nom) {
		nomChasseur = nom;
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
	

}
