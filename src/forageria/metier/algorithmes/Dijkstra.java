package forageria.metier.algorithmes;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.CaseHerbe;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra extends AlgorithmeCalculDistance {
    /**
     * Permet de savoir si une case a été visité.
     */
    private HashMap<Case, Boolean> estVisite;
    /**
     * Permet de connaitre le prédecesseur d'une case.
     */
    private HashMap<Case, Case> predecesseur;
    /**
     * Valeur attribué à l'infini.
     */
    private int infini;


    /**
     * Constructur de la classe.
     *
     * @param carte Représente la carte stocké par la classe.
     */
    public Dijkstra(Carte carte) {
        super(carte);

        estVisite = new HashMap<>();
        predecesseur = new HashMap<>();
    }


    /**
     * Cout du mouvement pour aller vers une case.
     *
     *
     * @param destination Case ou on veut aller.
     *
     * @return Cout pour se déplacer.
     */
    private int coutMouvementVers(Case destination){
        // TODO Implémenter.
        return 0;
    }

    /**
     * Initialisation avant d'utiliser Dijkstra.
     *
     *
     * @param depart Case de départ du calcul.
     */
    private void initialisation(Case depart){
        // TODO Implémenter.
    }

    /**
     * Relachement nécessaire à Dijkstra.
     *
     *
     * @param a Une des deux cases à comparer.
     * @param b Une des deux cases à comparer.
     */
    private void relachement(Case a, Case b){
        // TODO Implémenter.
    }

    private Case getCaseLaPlusProche(){
        // TODO Implémenter.
        return null;
    }


    @Override
    public void calculerDistancesDepuis(Case depart) {

    }

    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        return null;
    }
}
