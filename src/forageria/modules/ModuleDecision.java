package forageria.modules;

import forageria.IA;
import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.actions.TypeAction;
import forageria.metier.algorithmes.AlgorithmeCalculDistance;
import forageria.metier.algorithmes.Dijkstra;
import forageria.metier.algorithmes.ParcoursLargeur;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.FabriqueCase;
import forageria.metier.carte.cases.TypeCase;
import forageria.modules.etats.Etat;
import forageria.modules.etats.EtatInitial;

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
    private  ArrayList<Action> listeDesActionsARealiser ;
    /**
     * Etat dans lequel se trouve notre automate.
     */
    private  Etat etatCourant;
    /**
     * Stocke la réponse pourle serveur.
     */
    private String messageReponse;


    /**
     * Constructeur du module de décision.
     *
     *
     * @param ia IA qui a créé le module.
     */
    public ModuleDecision(IA ia) {
        super(ia);

        listeDesActionsARealiser = new ArrayList<Action>();
        etatCourant = new EtatInitial(this);
    }


    /**
     * Ajoute une action au début de la liste, elle sera traité en premier.
     *
     *
     * @param action Action à ajouter.
     */
    public void ajouterActionPrioritaire(Action action){
        listeDesActionsARealiser.add(0, action);
    }

    /**
     * Permet d'ajouter une action à la fin de la liste.
     *
     *
     * @param action Action à ajouter.
     */
    public void ajouterAction(Action action){
        listeDesActionsARealiser.add(action);
    }

    /**
     * Permet de savoir s'il y a qqc dans la liste des actions.
     *
     *
     * @return TRUE si on a des actions dans la liste.
     */
    public boolean hasAction(){
        return listeDesActionsARealiser.size() != 0;
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
        //On fait tourner l'automate de décision jusqu'à avoir qqchose à faire
        this.messageReponse = "" ;

        while(this.messageReponse.equals("")) {
            etatCourant = etatCourant.transition() ;
            etatCourant.action() ;
        }

        return messageReponse;
    }

    /**
     * Permet de réaliser la première action de la liste.
     */
    public void realiserAction(){
        //On réalise la première action de la liste
        Action action = this.listeDesActionsARealiser.get(0);

        if (action.getType() == TypeAction.MOUVEMENT) {
            Coordonnee coordonneDestination = this.getIA().getModuleMemoire().getCaseJoueur().getCoordonnee().getVoisin(action.getDirection()) ;
            Case caseDestination = this.getIA().getModuleMemoire().getCarte().getCase(coordonneDestination) ;

            if (!caseDestination.estVide() && caseDestination.getBatiment() == null)
                for (int i = 0 ; i < caseDestination.getRessource().nombreCoupsPioche() ; i++)
                    this.listeDesActionsARealiser.add(0, FabriqueAction.creerCollecte(action.getDirection()));
        }

        this.messageReponse = this.listeDesActionsARealiser.get(0).getMessage();
        this.getIA().getModuleMemoire().effectuerAction(this.listeDesActionsARealiser.get(0));
        this.listeDesActionsARealiser.remove(0) ;
    }
}
