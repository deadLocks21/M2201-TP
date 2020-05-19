package forageria.modules;

import forageria.IA;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;

import java.util.ArrayList;
import java.util.Random;

import static forageria.metier.actions.TypeDemande.CARTE;
import static forageria.metier.actions.TypeDemande.JOUEUR;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class ModuleDecision extends Module {
    /**
     * Liste des actions à effectuer.
     */
    public ArrayList<Action> listeDesActionsARealiser ;


    /**
     * Constructeur du module de décision.
     *
     *
     * @param ia IA qui a créé le module.
     */
    public ModuleDecision(IA ia) {
        super(ia);
        listeDesActionsARealiser = new ArrayList<Action>();
    }


    /**
     * Méthode principale de prise de décision
     *
     *
     * @param messageRecu dernier message reçu du serveur
     *
     * @return Le prochain message à envoyer
     */
    public String determinerNouvelleAction(String messageRecu) {
        String messageReponse = "END";

        //Gestion de la carte et du joueur
        if(!super.getIA().getModuleMemoire().hasCarte()) {
            listeDesActionsARealiser.add(FabriqueAction.creerDemande(CARTE));
            listeDesActionsARealiser.add(FabriqueAction.creerDemande(JOUEUR));
        }

        //Détermine de nouvelles actions si besoin
        if (listeDesActionsARealiser.size() == 0)
            determinerNouvellesActions();

        //Réalisation de la première action de la liste
        if (listeDesActionsARealiser.size() != 0) {
            messageReponse = listeDesActionsARealiser.get(0).getMessage();
            listeDesActionsARealiser.remove(0);
        } else {
            messageReponse = "WAIT";
        }


        return messageReponse;
    }

    /**
     * Méthode permettant de déterminer les nouvelles actions.
     */
    private void determinerNouvellesActions(){
    }
}
