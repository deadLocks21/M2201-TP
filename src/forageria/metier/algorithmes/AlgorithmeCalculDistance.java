package forageria.metier.algorithmes;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Carte;
import forageria.metier.carte.cases.Case;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe abstraite d'un algo de calcul de distance.
 */
public abstract class AlgorithmeCalculDistance {
    /**
     * Stocke la carte dans lequel on l'execute.
     */
    private Carte carte;
    /**
     * Permet de stocker les distances.
     */
    private HashMap<Case, Integer> distances;


    /**
     * Constructur de la classe.
     *
     *
     * @param carte Représente la carte stocké par la classe.
     */
    public AlgorithmeCalculDistance(Carte carte){
        this.carte = carte;
        distances = new HashMap<Case, Integer>();
    }


    /**
     * Assesseur de la variable carte.
     *
     *
     * @return Carte stocké par la classe.
     */
    protected Carte getCarte(){
        return carte;
    }

    /**
     * Permet d'insérer des valeurs dans distances.
     *
     *
     * @param position  Case à insérer dans l'index.
     * @param valeur    Valeur à affecter à position.
     */
    protected void setDistances(Case position, int valeur){
        distances.put(position, valeur);
    }

    /**
     * Retourne la distance pour aller jusqu'à la case demandée.
     *
     *
     * @param arrivee  Case que l'on vise.
     *
     * @return Distance pour y aller.
     */
    public Integer getDistance(Case arrivee){
        return distances.get(arrivee);
    }

    /**
     * Vide la variable distances.
     */
    protected void reinitialisationDistances(){
        distances.clear();
    }


    /**
     * Calcul une distance depuis depart.
     *
     *
     * @param depart Case de départ.
     */
    public abstract void calculerDistancesDepuis(Case depart);

    /**
     * Méthode permettant de trouver le chemin pour aller à une case accessible.
     *
     *
     * @param arrivee Case ou l'on veut se rendre.
     *
     * @return Suite d'instruction pour y aller.
     */
    public abstract ArrayList<TypeMouvement> getChemin(Case arrivee);
}
