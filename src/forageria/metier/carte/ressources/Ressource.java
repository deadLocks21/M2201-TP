package forageria.metier.carte.ressources;

import forageria.metier.carte.cases.Case;

/**
 * Classe en charge de stocker une ressource.
 */
public abstract class Ressource {
    /**
     * Stocke la position de la ressource.
     */
    private Case position;


    /**
     * Constructeur de la classe Ressource.
     *
     *
     * @param position Case ou se troyve la ressource.
     */
    public Ressource(Case position){
        this.position = position;
    }


    /**
     * Assesseur de la position.
     *
     *
     * @return Position de la ressource.
     */
    public Case getPosition() {
        return position;
    }


    /**
     * Méthode permettant de connaitre le type de la ressource.
     *
     *
     * @return Type de la ressource sous la forme de TypeRessource.
     */
    public abstract TypeRessource getType();
}
