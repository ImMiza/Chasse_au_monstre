package cam.utils.cases;

import cam.utils.personnages.Position;
import cam.utils.plateau.Biome;

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
	private Biome biomeCase;


	//CONSTRUCTEURS

	/**
	 * Constructeur sans parametres permettant de creer une case.
	 * Le biome par défaut d'une case est Plaine (qui ne confère pas d'effet négatif)
	 * la position par défaut est x:0 y:0
	 */
	public Case() {
		this(new Position(0, 0), Biome.PLAINE);
	}
	
	/**
	 * Constructeur permettant de creer une case.
	 * @param position la position a donner
	 */
	public Case(Position position) {
		this(position, Biome.PLAINE);
	}
	
	/**
	 * Constructeur permettant de creer une case
	 * @param position la position a donner
	 * @param biome le biome a definir
	 */
	public Case(Position position, Biome biome) {
		this.visited = false;
		this.tourVisited = -1;
		this.nbClick = 0;
		this.biomeCase = biome;
		this.position = position;
	}

	//METHODES
	
	/**
	 * Permet de changer le biome d'une case 
	 * @param b biome
	 */
	public void setBiome(Biome b) {
		this.biomeCase = b;
	}


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
	 * Permet de dire a la case a quel tour elle a ete visitee
	 * @param tour : met tourVisited a la valeur de tour
	 */
	public void setTourVisited(int tour) {
		this.tourVisited = tour;
	}


	/**
	 * @return la position de la case
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Permet de changer la position de la case
	 * @param position la nouvelle position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Permet de changer la position de la case
	 * @param x la coordonnee x 
	 * @param y la coordonnee y
	 */
	public void setPosition(int x, int y) {
		this.position = new Position(x, y);
	}
	
	/**
	 * @return le biome de la case
	 */
	public Biome getBiome() {
		return biomeCase;
	}
	
	/**
	 * Permet d'incrementer de 1 le combre de clicks effectues par le chasseur
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
