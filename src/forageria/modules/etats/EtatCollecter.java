package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.carte.ressources.Ressource;
import forageria.modules.ModuleDecision;

import java.util.ArrayList;

/**
 * Etat qui va collecter une ressource en particulier.
 */
public class EtatCollecter extends Etat {
    /**
     * Permet de stocker le chemin jusqu'à une ressource.
     */
    private ArrayList<TypeMouvement> chemin;
    /**
     * Ressource à collecter.
     */
    private Ressource ressource;

    /**
     * Constructeur de l'EtatCollecter.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCollecter(ModuleDecision module, ArrayList<TypeMouvement> chemin, Ressource ressource) {
        super(module);

        this.chemin = chemin;
        this.ressource = ressource;
    }


    @Override
    public Etat transition() {
        return new EtatReflexion(getModule());
    }

    @Override
    public void action() {
        TypeMouvement dernierMouvement = chemin.get(chemin.size() - 1);
        chemin.remove(chemin.size() - 1);

        for (TypeMouvement mouvement : chemin)
            getModule().ajouterAction(FabriqueAction.creerMouvement(mouvement));

        int n = ressource.nombreCoupsPioche();

        for (int i = 0; i < n; i++)
            getModule().ajouterAction(FabriqueAction.creerCollecte(dernierMouvement));
    }
}
