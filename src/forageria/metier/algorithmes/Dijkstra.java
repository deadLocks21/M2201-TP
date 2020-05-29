package forageria.metier.algorithmes;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.CaseHerbe;
import forageria.metier.carte.cases.TypeCase;

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
        infini = 1 + 16*getCarte().getTaille()*getCarte().getTaille();
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
        int ret = infini;

        if(destination.getType() != TypeCase.EAU)
            ret = destination.getRessource().nombreCoupsPioche() + 1;

        return ret;
    }

    /**
     * Initialisation avant d'utiliser Dijkstra.
     *
     *
     * @param depart Case de départ du calcul.
     */
    private void initialisation(Case depart){
        for (Case v : getCarte().getCases()) {
            setDistances(v, infini);
            estVisite.put(v, false);
            predecesseur.put(v, null);
        }

        setDistances(depart, 0);
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
