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
 * Etat qui recherche les ressources les plus proches.
 */
public class EtatRechercheRessource extends Etat {
    /**
     * Permet de stocker le chemin jusqu'à un bois.
     */
    ArrayList<TypeMouvement> chemin;
    /**
     * Ressource à collecter.
     */
    Ressource ressource;

    /**
     * Constructeur de l'EtatRechercheRessource.
     *
     * @param module Valeur de la variable module.
     */
    public EtatRechercheRessource(ModuleDecision module) {
        super(module);

        chemin = new ArrayList<>();
        ressource = null;
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
