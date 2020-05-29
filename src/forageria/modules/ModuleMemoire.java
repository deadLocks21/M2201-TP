package forageria.modules;

import forageria.IA;
import forageria.metier.Joueur;
import forageria.metier.actions.Action;
import forageria.metier.actions.TypeAction;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;

import static forageria.metier.actions.TypeAction.COLLECTE;
import static forageria.metier.actions.TypeAction.MOUVEMENT;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class ModuleMemoire extends Module  {
    /**
     * Stocke la carte du jeu.
     */
    Carte carte;
    /**
     * Stocke notre joueur.
     */
    Joueur joueur;


    /**
     * Construction du ModuleMemoire
     *
     *
     * @param ia IA qui a initialisé ce module.
     */
    public ModuleMemoire(IA ia) {
        super(ia);
    }


    /**
     * Assesseur de la variable joueur.
     *
     *
     * @return Joueur
     */
    public Joueur getJoueur(){
        return joueur;
    }

    /**
     * Assesseur de la variable carte.
     *
     *
     * @return Variable carte.
     */
    public Carte getCarte(){
        return carte;
    }


    /**
     * Vaut TRUE si la carte est settée.
     *
     *
     * @return TRUE | FALSE
     */
    public boolean hasCarte(){
        return carte != null;
    }

    /**
     * Permet de génerer la carte avec le message recu.
     *
     *
     * @param messageRecu Message du serveur contenant la carte.
     */
    public void genererCarte(String messageRecu){
        carte = new Carte(messageRecu);

        // Décommenter pour afficher la carte lors de sa construction
        // carte.afficheConsole();
    }

    /**
     * Vaut TRUE si le joueur est settée.
     *
     *
     * @return TRUE | FALSE
     */
    public boolean hasJoueur(){
        return joueur != null;
    }

    /**
     * Permet de créer un joueur avec les coordonnées fourni par le serveur.
     *
     *
     * @param messageRecu Coo sous forme de String 99/99
     */
    public void genererJoueur(String messageRecu){
        String[] coo = messageRecu.split("/");

        Coordonnee cooJoueur = new Coordonnee(Integer.parseInt(coo[0]), Integer.parseInt(coo[1]));
        joueur = new Joueur(cooJoueur);
    }

    /**
     * Permet de retourner les coordonnées du joueur.
     *
     *
     * @return Coo du joueur.
     */
    public Case getCaseJoueur(){
        return carte.getCase(joueur.getCoordonnee());
    }

    /**
     * Si on déplace le joueur, met à jour sa position.
     *
     *
     * @param action Action que l'on effectue.
     */
    public void effectuerAction(Action action){
        if(action.getType() == MOUVEMENT) {
            joueur.deplacer(action.getDirection()) ;
        }
        else if(action.getType() == COLLECTE) {
            Case caseDestination = this.carte.getCase(this.getCaseJoueur().
                    getCoordonnee().getVoisin(action.getDirection())) ;
            if(!caseDestination.estVide()) {
                caseDestination.setRessource(null) ;
            }
        }
    }
}
