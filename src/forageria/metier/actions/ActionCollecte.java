package forageria.metier.actions;

import forageria.metier.TypeMouvement;

import static forageria.metier.actions.TypeAction.COLLECTE;

/**
 * Action de collecter une ressource.
 */
public class ActionCollecte extends Action {
    TypeMouvement mouvement;

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
}
