package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.algorithmes.AlgorithmeCalculDistance;
import forageria.metier.algorithmes.Dijkstra;
import forageria.metier.carte.Carte;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.ressources.Ressource;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

/**
 * Etat qui recherche l'arbre le plus proche.
 */
public class EtatRechercheBois extends Etat {
    /**
     * Permet de stocker le chemin jusqu'à un bois.
     */
    ArrayList<TypeMouvement> chemin;
    /**
     * Ressource à collecter.
     */
    Ressource ressource;

    /**
     * Constructeur de l'EtatRechercheBois.
     *
     * @param module Valeur de la variable module.
     */
    public EtatRechercheBois(ModuleDecision module) {
        super(module);

        // TODO Initialiser chemin.
    }


    @Override
    public Etat transition() {
        return chemin == null ? new EtatAttendre(getModule()) : new EtatCollecter(getModule(), chemin, ressource);
    }

    @Override
    public void action() {
        int distanceMin;
        Case arbreLePlusProche;

        Carte carte = getMemoire().getCarte();
        AlgorithmeCalculDistance algorithme = new Dijkstra(carte);
        algorithme.calculerDistancesDepuis(getMemoire().getCaseJoueur());

        distanceMin = 1;
        arbreLePlusProche = null;

        for (Case C : carte.getCases()){
            if((C.getRessource() != null) && (C.getRessource().getType() == TypeRessource.ARBRE)) {
                if(arbreLePlusProche == null || algorithme.getDistance(C) < distanceMin){
                    distanceMin = algorithme.getDistance(C);
                    arbreLePlusProche = C;
                }
            }
        }

        if (arbreLePlusProche != null){
            ressource = arbreLePlusProche.getRessource();
            chemin = algorithme.getChemin(arbreLePlusProche);
        }
    }
}
