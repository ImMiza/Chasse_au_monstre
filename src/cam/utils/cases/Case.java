package cam.utils.cases;

import cam.utils.personnages.Position;

/**
 * Classe qui difinit le fonctionnement d'une case
 * @author Adrien BASSAIL
 */

public class Case {
	//ATTRIBUTS
	private boolean visited; //Pour le monstre
	private int tourVisited; //Pour le monstre
	private int nbClick; // Pour le monstre
	private Position position;

	//CONSTRUCTEURS

	/**
	 * Constructeur sans parametres permettant de creer une case.
	 */
	public Case(int x, int y) {
		this.visited = false;
		this.tourVisited = -1;
		this.nbClick = 0;
		this.position = new Position(x, y);
	}

	//METHODES


	/**
	 * Permet de savoir si une case à ete visitee par le monstre
	 * @return True si la case a deja ete visitee par le monstre, False sinon (boolean)
	 */
	public boolean isVisited() {
		return this.visited;
	}


	/**
	 * Met une case a l'etat visite.
	 */
	public void setVisited() {
		this.visited = true;
	}


	/**
	 * Permet de savoir a quel tour la case a ete visitee par le monstre
	 * -1 si la case n'as jamais ete visitee
	 * @return Le tour auquel la case a ete visitee (int)
	 */
	public int getTourVisited() {
		return this.tourVisited;
	}

	/**
	 * Permet de récupérer la position de la case
	 * @return La position de la case
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Permet de dire a la case a quel tour elle a ete visit�e
	 * @param tour : met tourVisited a la valeur de tour
	 */
	public void setTourVisited(int tour) {
		this.tourVisited = tour;
	}


	/**
	 * Permet d'incrementer de 1 le combre de clicks effectues par le monstre
	 */
	public void addClick() {
		this.nbClick++;
	}


	/**
	 * Permet de recuperer le nombre de clicks effectues par le chasseur
	 * @return le nombre de clicks effectues par le chasseur
	 */
	public int getNbClick() {
		return this.nbClick;
	}



}
