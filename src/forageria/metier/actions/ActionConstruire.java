package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

import static forageria.metier.actions.TypeAction.CONSTRUCTION;

/**
 * Permet de demander la construction d'un batiment.
 */
public class ActionConstruire extends Action {
    /**
     * Stocke le sens de construction.
     */
    TypeMouvement mouvement;
    /**
     * Stocke le batiment à construire.
     */
    TypeBatiment batiment;


    /**
     * Constructeur de ActionConstruire.
     *
     *
     * @param mouvement Valeur de mouvement
     * @param batiment  Valeur de batiment.
     */
    public ActionConstruire(TypeMouvement mouvement, TypeBatiment batiment){
        this.mouvement = mouvement;
        this.batiment = batiment;
    }


    @Override
    public String getMessage() {
        return "BUILD|" + mouvement + "|" + batiment;
    }

    @Override
    public TypeAction getType() {
        return CONSTRUCTION;
    }

    @Override
    public TypeMouvement getDirection() {
        return mouvement;
    }

    @Override
    public TypeMateriau getMateriau() {
        return null;
    }

    @Override
    public TypeBatiment getBatiment() {
        return batiment;
    }
}
