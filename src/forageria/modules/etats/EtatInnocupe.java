package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

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
        ArrayList<TypeRessource> ressources = new ArrayList<>(){{
            add(TypeRessource.ARBRE);
            add(TypeRessource.ROCHER);
        }};
        return new EtatRechercheRessource(getModule(), ressources);
    }

    @Override
    public void action() {

    }
}
