package forageria.modules;

import forageria.IA;
import forageria.metier.Joueur;
import forageria.metier.actions.Action;
import forageria.metier.actions.TypeAction;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.ressources.Ressource;
import forageria.metier.carte.ressources.TypeMateriau;

import java.util.ArrayList;
import java.util.HashMap;

import static forageria.metier.actions.TypeAction.COLLECTE;
import static forageria.metier.actions.TypeAction.MOUVEMENT;
import static forageria.metier.carte.ressources.TypeMateriau.*;

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
     * Permet de savoir ou se situe la forge
     */
    private Coordonnee siteForge;
    /**
     * Stocke les coordonnées des cases du fourneau.
     */
    private ArrayList<Coordonnee> fourneaux;
    /**
     * Stocke les coordonnées des cases de la forge.
     */
    private ArrayList<Coordonnee> forges;
    /**
     * Stocke le temps avant de pouvoir récupérer une ressource dans le fourneau.
     */
    private int timerCraftFourneau;
    /**
     * Stocke le temps avant de pouvoir récupérer une ressource dans la forge.
     */
    private int timerCraftForge;
    /**
     * Liste des matériaux qui sont en train de se crafter dans le fourneau.
     */
    private ArrayList<TypeMateriau> listeCraftEnCoursFourneau;
    /**
     * Liste des matériaux qui sont en train de se crafter dans la forge.
     */
    private ArrayList<TypeMateriau> listeCraftEnCoursForge;


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
        siteForge = new Coordonnee(-1, -1);
        fourneaux = new ArrayList<>();
        forges = new ArrayList<>();
        timerCraftFourneau = 0;
        timerCraftForge = 0;
        listeCraftEnCoursFourneau = new ArrayList<>();
        listeCraftEnCoursForge = new ArrayList<>();

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
     * Assesseur de la variable siteForge.
     *
     *
     * @return Valeur de siteForge.
     */
    public Coordonnee getSiteForge() {
        return siteForge;
    }

    /**
     * Assesseur de la variable fourneaux.
     *
     *
     * @return Valeur de fourneaux.
     */
    public ArrayList<Coordonnee> getFourneaux() {
        return fourneaux;
    }

    /**
     * Assesseur de la variable forges.
     *
     *
     * @return Valeur de forges.
     */
    public ArrayList<Coordonnee> getForges() {
        return forges;
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
     * Mutateur de la variable siteFourneau.
     *
     *
     * @param siteFourneau Nouvelle valeur de siteFourneau.
     */
    public void setSiteFourneau(Coordonnee siteFourneau) {
        this.siteFourneau = siteFourneau;
    }

    /**
     * Mutateur de la variable siteForge.
     *
     *
     * @param siteForge Nouvelle valeur de siteForge.
     */
    public void setSiteForge(Coordonnee siteForge) {
        this.siteForge = siteForge;
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
     * Vaut TRUE si le joueur est settée.
     *
     *
     * @return TRUE | FALSE
     */
    public boolean hasJoueur(){
        return joueur != null;
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

        for (Coordonnee coo : this.fourneaux)
            carte.getCase(coo).setBatiment(TypeBatiment.FURNACE);

        for (Coordonnee coo : this.forges)
            carte.getCase(coo).setBatiment(TypeBatiment.FORGE);

        // Décommenter pour afficher la carte lors de sa construction
        // carte.afficheConsole();
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
     * Si on déplace le joueur, met à jour sa position.
     *
     *
     * @param action Action que l'on effectue.
     */
    public void effectuerAction(Action action){
        avancerTimerCraf();

        switch (action.getType()){
            case MOUVEMENT:
                joueur.deplacer(action.getDirection()) ;
                dureeValiditeCarte --;
                break;

            case COLLECTE:
                Case caseDestination = this.carte.getCase(this.getCaseJoueur().getCoordonnee().getVoisin(action.getDirection())) ;
                if(!caseDestination.estVide() && caseDestination.getBatiment() == null) {
                    recolter(caseDestination.getRessource());
                    caseDestination.setRessource(null) ;
                }
                break;

            case CONSTRUCTION:
                int c = joueur.getCoordonnee().getColonne();
                int l = joueur.getCoordonnee().getLigne();

                for (int x = c + 1; x < c + 3; x ++)
                    for(int y = l - 1; y < l + 1; y ++)
                        switch (action.getBatiment()){
                            case FURNACE:
                                fourneaux.add(new Coordonnee(y, x));
                                break;
                            case FORGE:
                                forges.add(new Coordonnee(y, x));
                                break;
                        }

                switch (action.getBatiment()){
                    case FURNACE:
                        inventaire.put(PIERRE, inventaire.get(PIERRE) - 10);
                        break;
                    case FORGE:
                        inventaire.put(PIERRE, inventaire.get(PIERRE) - 4);
                        inventaire.put(LINGOTFER, inventaire.get(LINGOTFER) - 4);
                        break;
                }

                dureeValiditeCarte = 0;
                break;

            case CRAFT:
                switch (action.getMateriau()){
                    case CHARBON:
                        inventaire.put(BOIS, inventaire.get(BOIS) - 2);
                        break;
                    case LINGOTFER:
                        inventaire.put(CHARBON, inventaire.get(CHARBON) - 1);
                        inventaire.put(FER, inventaire.get(FER) - 2);
                        break;
                    case LINGOTOR:
                        inventaire.put(CHARBON, inventaire.get(CHARBON) - 1);
                        inventaire.put(OR, inventaire.get(OR) - 2);
                        break;
                    case PIECE:
                        inventaire.put(LINGOTOR, inventaire.get(LINGOTOR) - 2);
                        break;
                }

                ajouterCraft(action.getMateriau());
                break;
        }
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

    /**
     * Incrémente les variables qui prennent en compte le timer de création de ressources.
     *
     *
     * @param materiau Matériau à construire.
     */
    private void ajouterCraft(TypeMateriau materiau){
        if (materiau == PIECE) {
            timerCraftForge += 14;
            listeCraftEnCoursForge.add(materiau);
        } else {
            timerCraftFourneau += 14;
            listeCraftEnCoursFourneau.add(materiau);
        }
    }

    /**
     * Permet d'avancer le timer.
     */
    private void avancerTimerCraf() {
        if (timerCraftFourneau > 0){
            timerCraftFourneau --;

            if (timerCraftFourneau % 14 == 0){
                TypeMateriau m = listeCraftEnCoursFourneau.get(0);
                inventaire.put(m, inventaire.get(m) + 1);
                listeCraftEnCoursFourneau.remove(0);
            }
        }

        if (timerCraftForge > 0){
            timerCraftForge --;

            if (timerCraftForge % 14 == 0){
                TypeMateriau m = listeCraftEnCoursForge.get(0);
                inventaire.put(m, inventaire.get(m) + 1);
                listeCraftEnCoursForge.remove(0);
            }
        }
    }
}
