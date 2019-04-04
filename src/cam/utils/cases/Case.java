package cam.utils.cases;

/**
 * Classe qui difinit le fonctionnement d'une case
 * @author Adrien BASSAIL
 */

public class Case {
	//ATTRIBUTS
	private boolean visited;
	private int tourVisited;
	private int nbClick;

	//CONSTRUCTEURS
	
	/**
	 * Constructeur sans param�tres permettant de cr�er une case.
	 */
	public Case() {
		this.visited = false;
		this.tourVisited = -1;
		this.nbClick = 0;
	}
	
	//METHODES
	
	
	/**
	 * Permet de savoir si une case � �t� visit�e par le monstre
	 * @return True si la case � d�j� �t� visit�e par le monstre, False sinon (boolean)
	 */
	public boolean isVisited() {
		return this.visited;
	}
	
	
	/**
	 * Met une case � l'�tat visit�.
	 */
	public void setVisited() {
		this.visited = true;
	}
	
	
	/**
	 * Permet de savoir � quel tour la case � �t� visit�e par le monstre
	 * -1 si la case n'as jamais �t� visit�e
	 * @return Le tour auquel la case � �t� visit�e (int)
	 */
	public int getTourVisited() {
		return this.tourVisited;
	}
	
	
	/**
	 * Permet de dire � la case � quel tour elle � �t� visit�e
	 * @param tour : met tourVisited � la valeur de tour 
	 */
	public void setTourVisited(int tour) {
		this.tourVisited = tour;
	}
	
	
	/**
	 * Permet d'incr�menter de 1 le combre de clicks effectu�s par le monstre
	 */
	public void addClick() {
		this.nbClick++;
	}
	
	
	/**
	 * Permet de r�cup�rer le nombre de clicks effectu�s par le chasseur
	 * @return le nombre de clicks effectu�s par le chasseur
	 */
	public int getNbClick() {
		return this.nbClick;
	}
	
	
	
}
