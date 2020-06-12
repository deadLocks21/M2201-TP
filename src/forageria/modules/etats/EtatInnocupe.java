package forageria.modules.etats;

import forageria.metier.carte.Coordonnee;
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
        ArrayList<TypeRessource> ressources = new ArrayList<>();

        ressources.add(TypeRessource.ARBRE);
        ressources.add(TypeRessource.ROCHER);

        return getMemoire().getFourneaux().size() == 0 ?
                new EtatRessourceFourneau(getModule()) :
                new EtatRechercheRessource(getModule(), ressources);
    }

    @Override
    public void action() {

    }
}
