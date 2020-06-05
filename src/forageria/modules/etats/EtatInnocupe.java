package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat qui ne fait rien.
 */
public class EtatInnocupe extends Etat {
    /**
     * Constructeur de l'EtatInnocupe.
     *
     * @param module Valeur de la variable module.
     */
    public EtatInnocupe(ModuleDecision module) {
        super(module);
    }


    @Override
    public Etat transition() {
        return new EtatRechercheBois(getModule());
    }

    @Override
    public void action() {

    }
}
