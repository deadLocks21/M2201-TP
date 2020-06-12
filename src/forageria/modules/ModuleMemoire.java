package forageria.modules;

import forageria.IA;
import forageria.metier.Joueur;
import forageria.metier.actions.Action;
import forageria.metier.actions.TypeAction;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.ressources.Ressource;
import forageria.metier.carte.ressources.TypeMateriau;

import java.util.HashMap;

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
    private Carte carte;
    /**
     * Stocke notre joueur.
     */
    private Joueur joueur;
    /**
     * Durée de validité de la carte avant de la recharger.
     */
    private int dureeValiditeCarte;
    /**
     * Représente l'inventaire du joueur.
     */
    private HashMap<TypeMateriau,Integer> inventaire;


    /**
     * Stocke l'emplacement du fourneau.
     */
    private Coordonnee siteFourneau;


    /**
     * Construction du ModuleMemoire
     *
     *
     * @param ia IA qui a initialisé ce module.
     */
    public ModuleMemoire(IA ia) {
        super(ia);

        carte = null;
        joueur = null;
        dureeValiditeCarte = 0;
        inventaire = new HashMap<>();
        siteFourneau = new Coordonnee(-1, -1);

        // Initialisation de toutes les valeurs possibles de inventaire.
        for (TypeMateriau TM : TypeMateriau.values()) {
            inventaire.put(TM, 0);
        }
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
     * Assesseur de la variable siteFourneau.
     *
     *
     * @return Valeur de siteFourneau.
     */
    public Coordonnee getSiteFourneau() {
        return siteFourneau;
    }

    /**
     * Mutateur de la variable siteFourneau.
     *
     *
     * @param siteFourneau Nouvelle valeur de siteFourneau.
     */
    public void setSiteFourneau(Coordonnee siteFourneau) {
        this.siteFourneau = siteFourneau;
    }


    /**
     * Vaut TRUE si la carte est settée.
     *
     *
     * @return TRUE | FALSE
     */
    public boolean hasCarte(){
        return carte != null && dureeValiditeCarte > 0;
    }

    /**
     * Permet de génerer la carte avec le message recu.
     *
     *
     * @param messageRecu Message du serveur contenant la carte.
     */
    public void genererCarte(String messageRecu){
        carte = new Carte(messageRecu);
        dureeValiditeCarte = 2;

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
            dureeValiditeCarte --;
        }
        else if(action.getType() == COLLECTE) {
            Case caseDestination = this.carte.getCase(this.getCaseJoueur().getCoordonnee().getVoisin(action.getDirection())) ;
            if(!caseDestination.estVide() && caseDestination.getBatiment() == null) {
                recolter(caseDestination.getRessource());
                caseDestination.setRessource(null) ;
            }
        }
    }

    /**
     * Permet de récupérer la quantité d'un matériaux de l'inventaire.
     *
     *
     * @param type Type de la quantité du matos à récup.
     *
     * @return Quantité du matos à récup.
     */
    public int getQuantiteMateriel(TypeMateriau type){
        return inventaire.get(type);
    }

    /**
     * Pour chaque loot de la ressource, on en ajoute un à l'inventaire.
     *
     *
     * @param ressource Ressource dont on récupère le loot.
     */
    private void recolter(Ressource ressource){
        for (TypeMateriau TM : ressource.getLoot())
            inventaire.put(TM, inventaire.get(TM) + 1);
    }
}
