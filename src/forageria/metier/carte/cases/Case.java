package forageria.metier.carte.cases;

import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.ressources.Ressource;

/**
 * Classe abstraite en charge de stocker une case.
 */
public abstract class Case {
    /**
     * Stocke les coordonnées de la case.
     */
    private Coordonnee coordonnee;
    /**
     * Stocke la ressource qu'est la case.
     */
    private Ressource ressource;


    /**
     * Permet d'initialiser une case.
     *
     *
     * @param coordonnee Coordonnées de la case.
     */
    public Case(Coordonnee coordonnee){
        this.coordonnee = coordonnee;
    }



    /**
     * Assesseur de la variable coordonee
     *
     *
     * @return Coordonnées de la case.
     */
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    /**
     * Assesseur de la variable ressource
     *
     *
     * @return Ressource que représente la case.
     */
    public Ressource getRessource() {
        return ressource;
    }

    /**
     * Mutateur de la variable ressource.
     *
     *
     * @param ressource Nouvelle ressource à affecté à la case.
     */
    public void setRessource(Ressource ressource) {
        this.ressource = ressource;
    }
}
