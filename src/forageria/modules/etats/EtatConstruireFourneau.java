package forageria.modules.etats;

import forageria.modules.ModuleDecision;

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
        return null;
    }

    @Override
    public void action() {

    }
}
