package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat qui va collecter une ressource en particulier.
 */
public class EtatCollecter extends Etat {
    /**
     * Constructeur de l'EtatCollecter.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCollecter(ModuleDecision module) {
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
