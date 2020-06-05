package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat qui recherche l'arbre le plus proche.
 */
public class EtatRechercheBois extends Etat {
    /**
     * Constructeur de l'EtatRechercheBois.
     *
     * @param module Valeur de la variable module.
     */
    public EtatRechercheBois(ModuleDecision module) {
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
