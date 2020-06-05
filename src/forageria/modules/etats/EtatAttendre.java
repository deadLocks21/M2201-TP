package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat qui demande une attente.
 */
public class EtatAttendre extends Etat {
    /**
     * Constructeur de l'EtatAttendre.
     *
     * @param module Valeur de la variable module.
     */
    public EtatAttendre(ModuleDecision module) {
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
