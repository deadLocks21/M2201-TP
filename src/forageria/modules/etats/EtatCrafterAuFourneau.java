package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.algorithmes.AlgorithmeCalculDistance;
import forageria.metier.algorithmes.Dijkstra;
import forageria.metier.algorithmes.DijkstraBatiment;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.ressources.TypeMateriau;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

import static forageria.metier.carte.TypeBatiment.FURNACE;

/**
 * Etat permettant de crafter dans un fourneau.
 */
public class EtatCrafterAuFourneau extends Etat {
    /**
     * Matériau que l'on veut crafter.
     */
    TypeMateriau materiau;

    /**
     * Constructeur d'un EtatCrafterAuFourneau.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCrafterAuFourneau(ModuleDecision module, TypeMateriau materiau) {
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
        AlgorithmeCalculDistance dijkstra = new DijkstraBatiment(carte, FURNACE);
        dijkstra.calculerDistancesDepuis(this.getMemoire().getCaseJoueur());


        //On recherche la case du fourneau la plus proche
        int distanceMin = -1;
        Case fourneauLePlusProche = null ;

        for(Coordonnee coo : this.getMemoire().getFourneaux()) {
            Case c = carte.getCase(coo) ;
            if (fourneauLePlusProche == null || dijkstra.getDistance(c) < distanceMin) {
                distanceMin = dijkstra.getDistance(c) ;
                fourneauLePlusProche = c ;
            }
        }


        //On s'y rend (on enlève le dernier mouvement pour le replacer par CRAFT)
        ArrayList<TypeMouvement> chemin = dijkstra.getChemin(fourneauLePlusProche);
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
