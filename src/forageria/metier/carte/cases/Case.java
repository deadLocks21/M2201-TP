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
     * Assesseur de la variable voisins.
     *
     *
     * @return Variable voisins sour la forme d'une ArrayList
     */
    public ArrayList<Case> getVoisins() {
        return voisins;
    }

    /**
     * Permet d'ajouter un voisin à la liste des voisins.
     *
     *
     * @param voisin Case à ajouter à la liste.
     */
    public void ajouterVoisin(Case voisin){
        voisins.add(voisin);
    }


    /**
     * Permet de savoir si la case est vide ou non.
     * Vaut TRUE si elle n'a pas de ressource.
     *
     *
     * @return TRUE | FALSE
     */
    public boolean estVide(){
        return ressource == null;
    }


    /**
     * Méthode permettant de connaitre le type de la case.
     *
     *
     * @return Type de la case sous la forme de TypeCase.
     */
    public abstract TypeCase getType();
}
