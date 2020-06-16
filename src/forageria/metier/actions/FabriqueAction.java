package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

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

    /**
     * Action de collecter une ressource.
     *
     *
     * @param direction Sens ou l'on doit récolter.
     *
     * @return ActionCollecte correspondante
     */
    public static Action creerCollecte(TypeMouvement direction){
        return new ActionCollecte(direction);
    }

    /**
     * Permet de fabriquer une ActionConstruction.
     *
     *
     * @param mouvement Mouvement souhaité.
     * @param batiment  Batiment voulu.
     *
     * @return Action souhaité.
     */
    public static Action creerConstruire(TypeMouvement mouvement, TypeBatiment batiment){
        return new ActionConstruire(mouvement, batiment);
    }

    /**
     * Permet de créer une action de craft.
     *
     *
     * @param mouvement Sens ou se trouve le batiment.
     * @param materiau  Matériau à crafter.
     *
     * @return ActionCraft qui correspond au paramètres.
     */
    public static Action creerCraft(TypeMouvement mouvement, TypeMateriau materiau){
        return new ActionCraft(mouvement, materiau);
    }
}
