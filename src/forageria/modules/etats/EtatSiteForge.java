package forageria.modules.etats;

import forageria.metier.carte.Coordonnee;
import forageria.modules.ModuleDecision;

/**
 * Permet de savoir si le site d'une forge existe ou non.
 */
public class EtatSiteForge extends Etat {
    /**
     * Constructeur d'un état.
     *
     * @param module Valeur de la variable module.
     */
    public EtatSiteForge(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
        return getMemoire().getSiteForge().equals(new Coordonnee(-1, -1)) ?
                new EtatTrouverSiteForge(getModule()) :
                new EtatConstruireForge(getModule());
    }

    @Override
    public void action() {

    }
}
