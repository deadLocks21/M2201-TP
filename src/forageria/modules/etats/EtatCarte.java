package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat qui initalise la carte.
 */
public class EtatCarte extends Etat {
    /**
     * Constructeur de l'EtatCarte.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCarte(ModuleDecision module) {
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
