package forageria.modules.etats;

import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

import static forageria.metier.carte.ressources.TypeMateriau.CHARBON;

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
        Etat nouvelEtat = new EtatCrafterRessource(getModule(), TypeMateriau.PIECE);;

        ArrayList<TypeRessource> ressources = new ArrayList<>();

        if (getMemoire().getFourneaux().size() == 0)
            nouvelEtat = new EtatRessourceFourneau(getModule());

        else if (getMemoire().getForges().size() == 0)
            nouvelEtat = new EtatRessourceForge(getModule());

        return nouvelEtat;
    }

    @Override
    public void action() {

    }
}
