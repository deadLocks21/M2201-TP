package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.algorithmes.AlgorithmeCalculDistance;
import forageria.metier.algorithmes.DijkstraBatiment;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.ressources.TypeMateriau;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

import static forageria.metier.carte.TypeBatiment.FORGE;

/**
 * Permet de crafter à la forge.
 */
public class EtatCrafterALaForge extends Etat {
    /**
     * Matériau que l'on veut crafter.
     */
    TypeMateriau materiau;


    /**
     * Constructeur d'un EtatCrafterALaForge.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCrafterALaForge(ModuleDecision module, TypeMateriau materiau) {
        super(module);

        this.materiau = materiau;
    }


    @Override
    public Etat transition() {
        return new EtatReflexion(getModule());
    }

    @Override
    public void action() {
        //On récupère la carte et on lance Dijkstra
        Carte carte = this.getMemoire().getCarte();
        AlgorithmeCalculDistance dijkstra = new DijkstraBatiment(carte, FORGE);
        dijkstra.calculerDistancesDepuis(this.getMemoire().getCaseJoueur());


        //On recherche la case de la forge la plus proche
        int distanceMin = -1;
        Case forgeLaPlusProche = null ;

        for(Coordonnee coo : this.getMemoire().getForges()) {
            Case c = carte.getCase(coo) ;
            if (forgeLaPlusProche == null || dijkstra.getDistance(c) < distanceMin) {
                distanceMin = dijkstra.getDistance(c);
                forgeLaPlusProche = c;
            }
        }


        //On s'y rend (on enlève le dernier mouvement pour le replacer par CRAFT)
        ArrayList<TypeMouvement> chemin = dijkstra.getChemin(forgeLaPlusProche);
        TypeMouvement dernierMouvement = chemin.get(chemin.size() - 1);
        chemin.remove(chemin.size() - 1);

        for(TypeMouvement mouvement : chemin) {
            Action action = FabriqueAction.creerMouvement(mouvement);
            this.getModule().ajouterAction(action);
        }

        Action action = FabriqueAction.creerCraft(dernierMouvement,materiau);
        this.getModule().ajouterAction(action);
    }
}
