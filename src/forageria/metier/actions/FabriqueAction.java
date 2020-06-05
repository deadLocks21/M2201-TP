package forageria.metier.actions;

import forageria.metier.TypeMouvement;

/**
 * Fabrique à actions.
 */
public class FabriqueAction {
    /**
     * Permet de créer le mouvement souhaité.
     *
     *
     * @param mouvement Mouvement que l'on désire.
     *
     * @return Mouvement correspondant.
     */
    public static Action creerMouvement(TypeMouvement mouvement){
        return new ActionMouvement(mouvement);
    }

    /**
     * Permet de créer une ActionDemande en fonction de la demande.
     *
     *
     * @param demande Demande que l'on veut.
     *
     * @return ActionDemande avec le message correspondant.
     */
    public static Action creerDemande(TypeDemande demande){
        ActionDemande actionDemande = null;

        switch (demande){
            case JOUEUR:
                actionDemande = new ActionDemande("PLAYER");
                break;
            case CARTE:
                actionDemande = new ActionDemande("MAP");
                break;
            case ATTENDRE:
                actionDemande = new ActionDemande("WAIT");
        }

        return actionDemande;
    }

    public static Action creerCollecte(TypeMouvement direction){
        return new ActionCollecte(direction);
    }
}
