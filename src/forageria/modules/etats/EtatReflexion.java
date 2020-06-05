package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 * Etat qui réalise la premiere action de la liste.
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
        Etat res;

        if(!getMemoire().hasCarte())
            res = new EtatCarte(getModule());
        else if (getModule().hasAction())
            res = new EtatReflexion(getModule());
        else
            res = new EtatInnocupe(getModule());

        return res;
    }

    @Override
    public void action() {
        // Réalise une action si il y a des actions dans la liste
        if(getModule().hasAction())
            getModule().realiserAction();
    }
}
