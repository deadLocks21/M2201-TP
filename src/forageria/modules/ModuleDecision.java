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
    public ArrayList<Action> listeDesActionsARealiser ;
    /**
     * Etat dans lequel se trouve notre automate.
     */
    private Etat etatCourant;


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
     * Méthode principale de prise de décision
     *
     *
     * @param messageRecu dernier message reçu du serveur
     *
     * @return Le prochain message à envoyer
     */
    public String determinerNouvelleAction(String messageRecu) {
        String messageReponse = "END";

        //Gestion de la carte
        if(!this.getIA().getModuleMemoire().hasCarte()) {
            this.listeDesActionsARealiser.add(FabriqueAction.creerDemande(CARTE));
        }

        //Gestion de la position du joueur
        if(!this.getIA().getModuleMemoire().hasJoueur()) {
            this.listeDesActionsARealiser.add(FabriqueAction.creerDemande(JOUEUR));
        }

        //L'IA n'a plus rien à faire
        if(this.listeDesActionsARealiser.isEmpty()) {
            this.determinerNouvellesActions();
        }


        //Réalisation de la première action
        if(!this.listeDesActionsARealiser.isEmpty()) {
            Action action = this.listeDesActionsARealiser.get(0);
            if(action.getType() == TypeAction.MOUVEMENT) {
                Coordonnee coordonneDestination = this.getIA().getModuleMemoire().getCaseJoueur().getCoordonnee().getVoisin(action.getDirection());
                Case caseDestination = this.getIA().getModuleMemoire().getCarte().getCase(coordonneDestination);
                if(!caseDestination.estVide()) {
                    for(int i=0;i<caseDestination.getRessource().nombreCoupsPioche();i++) {
                        this.listeDesActionsARealiser.add(0,FabriqueAction.creerCollecte(action.getDirection()));
                    }
                }
            }
            messageReponse = this.listeDesActionsARealiser.get(0).getMessage();
            this.getIA().getModuleMemoire().effectuerAction(this.listeDesActionsARealiser.get(0));
            this.listeDesActionsARealiser.remove(0);
        }
        else {
            messageReponse = "WAIT";
        }

        return messageReponse;
    }

    /**
     * Méthode permettant de déterminer les nouvelles actions.
     */
    private void determinerNouvellesActions(){
        Random generateur = new Random();
        int ligne = generateur.nextInt(this.getIA().getModuleMemoire().getCarte().getTaille());
        int colonne = generateur.nextInt(this.getIA().getModuleMemoire().getCarte().getTaille());
        this.seDeplacerEn(new Coordonnee(ligne,colonne));
        // this.seDeplacerEn(new Coordonnee(7,2));
    }

    /**
     * Permet de déplacer le joueur jusqu'à des coo.
     *
     *
     * @param coordonnee Coo ou l'on veut déplacer le joueur.
     */
    private void seDeplacerEn(Coordonnee coordonnee){
        System.out.println("--- Je veux me déplacer en "+coordonnee+" ---");

        Carte carte = this.getIA().getModuleMemoire().getCarte();
        AlgorithmeCalculDistance algorithme = new Dijkstra(carte);

        algorithme.calculerDistancesDepuis(this.getIA().getModuleMemoire().getCaseJoueur());
        ArrayList<TypeMouvement> listeMouvement = algorithme.getChemin(carte.getCase(coordonnee));

        for(TypeMouvement mouvement : listeMouvement) {
            this.listeDesActionsARealiser.add(FabriqueAction.creerMouvement(mouvement));
        }
    }
}
