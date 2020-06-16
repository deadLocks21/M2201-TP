package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

import static forageria.metier.actions.TypeAction.COLLECTE;

/**
 * Action de collecter une ressource.
 */
public class ActionCollecte extends Action {
    private TypeMouvement mouvement;

    public ActionCollecte(TypeMouvement direction){
        mouvement = direction;
    }

    @Override
    public String getMessage() {
        return "COLLECT|" + mouvement;
    }

    @Override
    public TypeAction getType() {
        return COLLECTE;
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
        return null;
    }
}
