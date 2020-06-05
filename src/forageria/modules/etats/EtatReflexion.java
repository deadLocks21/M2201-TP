package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat qui choisi s'il initalise la carte ou réalise la premiere action de la liste.
 */
public class EtatReflexion extends Etat {
    /**
     * Constructeur de l'EtatReflexion.
     *
     * @param module Valeur de la variable module.
     */
    public EtatReflexion(ModuleDecision module) {
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
