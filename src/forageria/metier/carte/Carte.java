package forageria.metier.carte;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.CaseHerbe;
import forageria.metier.carte.cases.FabriqueCase;


import java.util.*;

import static forageria.metier.carte.cases.TypeCase.HERBE;

/**
 * Classe en charge de stocker la carte.
 */
public class Carte {
    /**
     * Stocke la taille de la carte.
     */
    private int taille;
    /**
     * Variable permettant de stocker les cases de notre jeu.
     */
    private Map<Coordonnee,Case> cases;


    /**
     * Constructeur de la classe Carte.
     *
     *
     * @param messageRecu Message recu par l'IA.
     */
    public Carte(String messageRecu) {
        this.cases = new HashMap<>() ;
        this.taille = (int) Math.sqrt(messageRecu.length()) ;

        // Ajout des cases à la carte
        for(int i=0 ;i<this.taille ;i++) {
            for(int j=0 ;j<this.taille ;j++) {
                this.ajouterCase(new Coordonnee(i,j), messageRecu.charAt(j+this.taille*i));
            }
        }

        //Gestions des voisins
        for(int i=0 ;i<this.taille ;i++) {
            for(int j=0 ;j<this.taille ;j++) {
                Coordonnee cooCase = new Coordonnee(i,j) ;
                for(TypeMouvement mouvement : TypeMouvement.values()) {
                    Coordonnee cooVoisin = cooCase.getVoisin(mouvement);
                    if(this.cases.get(cooVoisin) != null)
                        this.cases.get(cooCase).ajouterVoisin(this.cases.get(cooVoisin));
                }
            }
        }
    }


    /**
     * Assesseur de la variable taille.
     *
     *
     * @return Taille de la carte.
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Permet de récupérer la case avec les coo coordonee.
     *
     *
     * @param coordonnee Place de la case à récupérer.
     *
     * @return Case en question.
     */
    public Case getCase(Coordonnee coordonnee){
        return cases.get(coordonnee);
    }

    /**
     * Renvoie la liste des valeurs stockées dans la HashMap cases.
     *
     *
     * @return Liste des val de HashMap.
     */
    public Collection<Case> getCases(){
        return cases.values();
    }

    /**
     * Permet de vérifier si une zone est libre.
     *
     *
     * @param coinBasGauche Coin en bas à gauche de la zone à vérifier (TP08 Q21)
     *
     * @return TRUE si la zone est libre.
     */
    public boolean estZoneValide(Case coinBasGauche){
        boolean ret = true;

        // Coordonées de la case.
        int l = coinBasGauche.getCoordonnee().getLigne();
        int c = coinBasGauche.getCoordonnee().getColonne();

        // Coordonnées case coin haut gauche;
        int x1 = c - 1;
        int y1 = l - 2;

        // Coordonnées case coin bas droite.
        int x2 = c + 2;
        int y2 = l + 1;

        for (int x = x1; x <= x2; x++)
            for (int y = y1; y <= y2; y++)
                if (cases.get(new Coordonnee(x, y)) == null || cases.get(new Coordonnee(x, y)).getType() != HERBE)
                    ret = false;

        return ret;
    }

    /**
     * Méthode permettant d'ajouter une case à la liste des cases.
     *
     *
     * @param coordonnee  Coordonées de la case à ajouter.
     * @param lettre      Lettre correspondant au type de la case.
     */
    private void ajouterCase(Coordonnee coordonnee, Character lettre){
        Case c = FabriqueCase.creer(coordonnee, lettre);

        cases.put(coordonnee, c);
    }


    /**
     * Permet d'afficher la carte de manière lisible.
     */
    public void afficheConsole() {
        for(int i=0 ;i<this.taille ;i++) {
            for(int j=0 ;j<this.taille ;j++) {
                String affichage = "W" ;
                Case caseEnCours = this.cases.get(new Coordonnee(i,j)) ;
                if(caseEnCours.getType() == HERBE) {
                    if(caseEnCours.getRessource() == null) {
                        affichage = "H" ;
                    }
                    else {
                        switch(caseEnCours.getRessource().getType()) {
                            case ARBRE : affichage = "T" ; break ;
                            case ROCHER :affichage = "R" ; break ;
                            case FER : affichage = "I" ; break ;
                            case OR : affichage = "G" ; break ;
                        }
                    }
                }
                System.out.print(affichage) ;
            }
            System.out.println("") ;
        }
    }
}
