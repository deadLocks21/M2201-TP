package forageria.modules.etats;

import forageria.metier.actions.FabriqueAction;
import forageria.modules.ModuleDecision;

import static forageria.metier.TypeMouvement.*;
import static forageria.metier.TypeMouvement.RIGHT;
import static forageria.metier.carte.TypeBatiment.FORGE;

/**
 * Permet de construire une forge.
 */
public class EtatConstruireForge extends Etat {
    /**
     * Constructeur d'un EtatConstruireForge.
     *
     * @param module Valeur de la variable module.
     */
    public EtatConstruireForge(ModuleDecision module) {
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
        getModule().ajouterAction(FabriqueAction.creerConstruire(RIGHT, FORGE));
    }
}
