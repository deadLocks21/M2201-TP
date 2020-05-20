package forageria.modules;

import forageria.IA;
import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.algorithmes.ParcoursLargeur;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.FabriqueCase;
import forageria.metier.carte.cases.TypeCase;

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
            getIA().getModuleMemoire().effectuerAction(listeDesActionsARealiser.get(0));
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
        Random rand = new Random();
        Coordonnee coo = new Coordonnee(0, 0);
        Case caseA = getIA().getModuleMemoire().getCarte().getCase(coo);

        while(caseA.getType() != TypeCase.HERBE){
            coo = new Coordonnee(
                    rand.nextInt(getIA().getModuleMemoire().getCarte().getTaille()),
                    rand.nextInt(getIA().getModuleMemoire().getCarte().getTaille())
            );
            caseA = getIA().getModuleMemoire().getCarte().getCase(coo);
        }

        seDeplacerEn(coo);
    }

    /**
     * Permet de déplacer le joueur jusqu'à des coo.
     *
     *
     * @param coordonnee Coo ou l'on veut déplacer le joueur.
     */
    private void seDeplacerEn(Coordonnee coordonnee){
        System.out.println("--- Je veux aller en " + coordonnee + " ---");

        Carte carte = getIA().getModuleMemoire().getCarte();

        ParcoursLargeur parcoursLargeur = new ParcoursLargeur(carte);

        Case caseJoueur = getIA().getModuleMemoire().getCaseJoueur();
        parcoursLargeur.calculerDistancesDepuis(caseJoueur);

        Case caseDestination = carte.getCase(coordonnee);
        ArrayList<TypeMouvement> chemin = parcoursLargeur.getChemin(caseDestination);

        for(TypeMouvement mvt : chemin){
            Action action = FabriqueAction.creerMouvement(mvt);
            listeDesActionsARealiser.add(action);
        }

    }
}
