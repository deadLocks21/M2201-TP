package forageria.metier.carte.cases;

import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.ressources.Ressource;

import java.util.ArrayList;

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
     * Attribut permettant de trouver les voisins de la case.
     */
    private ArrayList<Case> voisins;


    /**
     * Permet d'initialiser une case.
     *
     *
     * @param coordonnee Coordonnées de la case.
     */
    public Case(Coordonnee coordonnee){
        this.coordonnee = coordonnee;
        this.voisins = new ArrayList<>();
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

    



    /**
     * Méthode permettant de connaitre le type de la case.
     *
     *
     * @return Type de la case sous la forme de TypeCase.
     */
    public abstract TypeCase getType();
}
