package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.carte.TypeBatiment;
import forageria.modules.ModuleDecision;

import static forageria.metier.TypeMouvement.*;
import static forageria.metier.carte.TypeBatiment.FURNACE;

/**
 * Etat permettant de lancer la construction d'un fourneau.
 */
public class EtatConstruireFourneau extends Etat {
    /**
     * Constructeur d'un EtatConstruireFourneau.
     *
     * @param module Valeur de la variable module.
     */
    public EtatConstruireFourneau(ModuleDecision module) {
        super(module);
    }


    @Override
    public Etat transition() {
        return new EtatReflexion(getModule());
    }

    @Override
    public void action() {
        getModule().ajouterAction(FabriqueAction.creerMouvement(RIGHT));
        getModule().ajouterAction(FabriqueAction.creerMouvement(TOP));
        getModule().ajouterAction(FabriqueAction.creerMouvement(LEFT));
        getModule().ajouterAction(FabriqueAction.creerMouvement(BOTTOM));
        getModule().ajouterAction(FabriqueAction.creerMouvement(LEFT));
        getModule().ajouterAction(FabriqueAction.creerConstruire(RIGHT, FURNACE));
    }
}
