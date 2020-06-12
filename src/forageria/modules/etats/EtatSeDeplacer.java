package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.FabriqueAction;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

/**
 * Etat permettant de se déplacer.
 */
public class EtatSeDeplacer extends Etat {
    /**
     * Stocke le chemin pour me déplacer.
     */
    private ArrayList<TypeMouvement> chemin;


    /**
     * Constructeur d'un EtatSeDeplacer.
     *
     * @param module Valeur de la variable module.
     */
    public EtatSeDeplacer(ModuleDecision module, ArrayList<TypeMouvement> chemin) {
        super(module);

        this.chemin = chemin;
    }

    @Override
    public Etat transition() {
        return new EtatReflexion(getModule());
    }

    @Override
    public void action() {
        for (TypeMouvement mouvement : chemin)
            getModule().ajouterAction(FabriqueAction.creerMouvement(mouvement));
    }
}
