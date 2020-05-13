package forageria.metier.carte;

import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.FabriqueCase;


import java.util.HashMap;
import java.util.Map;

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
    public Map<Coordonnee,Case> cases;


    /**
     * Constructeur de la classe Carte.
     *
     *
     * @param messageRecu Message recu par l'IA.
     */
    public Carte(String messageRecu) {
        this.cases = new HashMap<>() ;
        this.taille = (int) Math.sqrt(messageRecu.length()) ;

        for(int i=0 ;i<this.taille ;i++) {
            for(int j=0 ;j<this.taille ;j++) {
                this.ajouterCase(new Coordonnee(i,j), messageRecu.charAt
                        (j+this.taille*i)) ;
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
