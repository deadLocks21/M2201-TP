package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

import static forageria.metier.actions.TypeAction.MOUVEMENT;

/**
 * Permet de préparer le message de demande de mouvement.
 */
public class ActionMouvement extends Action {
    /**
     * Mouvement dont on a besoin.
     */
    private TypeMouvement typeMouvement;


    /**
     * Constructeur de ActionMouvement.
     *
     *
     * @param typeMouvement Mouvement à affeceter à typeMouvement.
     */
    public ActionMouvement(TypeMouvement typeMouvement){
        this.typeMouvement = typeMouvement;
    }

    @Override
    public String getMessage() {
        return "MOVE|" + typeMouvement;
    }

    @Override
    public TypeAction getType() {
        return MOUVEMENT;
    }

    @Override
    public TypeMouvement getDirection() {
        return typeMouvement;
    }

    @Override
    public TypeMateriau getMateriau() {
        return null;
    }

    @Override
    public TypeBatiment getBatiment() {
        return null;
    }
}
