package forageria.metier.carte.cases;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.TypeBatiment;
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
     * Permet de savoir si un batiment se trouve sur la case.
     */
    private TypeBatiment batiment;


    /**
     * Permet d'initialiser une case.
     *
     *
     * @param coordonnee Coordonnées de la case.
     */
    public Case(Coordonnee coordonnee){
        this.coordonnee = coordonnee;
        this.voisins = new ArrayList<>();
        batiment = null;
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
     * Assesseur de la variable voisins.
     *
     *
     * @return Variable voisins sour la forme d'une ArrayList
     */
    public ArrayList<Case> getVoisins() {
        return voisins;
    }

    /**
     * Assesseur de la variable batiment.
     *
     *
     * @return Valeur de batiment.
     */
    public TypeBatiment getBatiment() {
        return batiment;
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
     * Mutateur de batiment.
     *
     *
     * @param batiment Nouvelle valeur de batiment.
     */
    public void setBatiment(TypeBatiment batiment) {
        this.batiment = batiment;
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
        return ressource == null && batiment == null;
    }

    /**
     * Retourne le mouvement pour aller à une case voisine.
     *
     *
     * @param arrivee Case ou l'on veut aller.
     *
     * @return Mouvement à effectuer.
     */
    public TypeMouvement getMouvementPourAller(Case arrivee){
        return coordonnee.getMouvementPourAller(arrivee.getCoordonnee());
    }


    /**
     * Méthode permettant de connaitre le type de la case.
     *
     *
     * @return Type de la case sous la forme de TypeCase.
     */
    public abstract TypeCase getType();

    /**
     * Renvoie TRUE si on se trouve sur une CaseHerbe vide.
     *
     *
     * @return TRUE|FALSE
     */
    public abstract boolean estAccessible();
}
