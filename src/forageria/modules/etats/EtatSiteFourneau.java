package forageria.modules.etats;

import forageria.metier.carte.Coordonnee;
import forageria.modules.ModuleDecision;

/**
 * Etat qui cherche à déterminer le site du fourneau existe ou non.
 */
public class EtatSiteFourneau extends Etat {
    /**
     * Constructeur d'un EtatSiteFourneau.
     *
     * @param module Valeur de la variable module.
     */
    public EtatSiteFourneau(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
        return getMemoire().getSiteFourneau().equals(new Coordonnee(-1, -1)) ?
                new EtatTrouverSiteFourneau(getModule()) :
                new EtatConstruireFourneau(getModule());
    }

    @Override
    public void action() {

    }
}
