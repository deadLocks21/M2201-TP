package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat initial de notre automate.
 */
public class EtatInitial extends Etat {
    /**
     * Constructeur de l'état initial.
     *
     * @param module Valeur de la variable module.
     */
    public EtatInitial(ModuleDecision module) {
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
