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
    private ArrayList<TypeMouvement> chemin;
    /**
     * Ressource à collecter.
     */
    private Ressource ressource;
    /**
     * Liste des ressources à rechercher.
     */
    private ArrayList<TypeRessource> ressourcesRecherchees;

    /**
     * Constructeur de l'EtatRechercheRessource.
     *
     * @param module Valeur de la variable module.
     * @param ressourcesRecherchees Ressources que le joueur cherche.
     */
    public EtatRechercheRessource(ModuleDecision module, ArrayList<TypeRessource> ressourcesRecherchees) {
        super(module);

        chemin = new ArrayList<>();
        ressource = null;
        this.ressourcesRecherchees = ressourcesRecherchees;
    }


    @Override
    public Etat transition() {
        return chemin == null ? new EtatAttendre(getModule()) : new EtatCollecter(getModule(), chemin, ressource);
    }

    @Override
    public void action() {
        int distanceMin;
        Case arbreLePlusProche;
        TypeRessource ressourceATrouver;

        Carte carte = getMemoire().getCarte();
        AlgorithmeCalculDistance algorithme = new Dijkstra(carte);
        algorithme.calculerDistancesDepuis(getMemoire().getCaseJoueur());

        distanceMin = 1;
        arbreLePlusProche = null;

        // Recherche du plus court chemin pour chaque ressources qu'on cherche.
        for (TypeRessource type : ressourcesRecherchees) {
            ressourceATrouver = type;

            for (Case C : carte.getCases()){
                if((C.getRessource() != null) && (C.getRessource().getType() == ressourceATrouver)) {
                    if(arbreLePlusProche == null || algorithme.getDistance(C) < distanceMin){
                        distanceMin = algorithme.getDistance(C);
                        arbreLePlusProche = C;
                    }
                }
            }
        }

        if (arbreLePlusProche != null){
            ressource = arbreLePlusProche.getRessource();
            chemin = algorithme.getChemin(arbreLePlusProche);
        }
    }
}
