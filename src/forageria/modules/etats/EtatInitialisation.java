package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat lorsque notre automate s'initialise, il récupère le joueur.
 */
public class EtatInitialisation extends Etat {
    /**
     * Constructeur de l'état initialisation.
     *
     * @param module Valeur de la variable module.
     */
    public EtatInitialisation(ModuleDecision module) {
        super(module);
    }


    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public void action() {

    }
}
