package forageria.metier.carte;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.cases.Case;
import forageria.metier.carte.cases.CaseHerbe;
import forageria.metier.carte.cases.FabriqueCase;


import java.util.ArrayList;
import java.util.Arrays;
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

        // Ajout des cases à la carte
        for(int i=0 ;i<this.taille ;i++) {
            for(int j=0 ;j<this.taille ;j++) {
                this.ajouterCase(new Coordonnee(i,j), messageRecu.charAt
                        (j+this.taille*i)) ;
            }
        }

        //Gestions des voisins
        for(int i=0 ;i<this.taille ;i++) {
            for(int j=0 ;j<this.taille ;j++) {
                Coordonnee cooCase = new Coordonnee(i,j) ;
                for(TypeMouvement mouvement : TypeMouvement.values()) {
                    Coordonnee cooVoisin = cooCase.getVoisin(mouvement) ;
                    if(this.cases.get(cooVoisin) != null) {
                        this.cases.get(cooCase).ajouterVoisin(this.cases.get(cooVoisin)) ;
                    }
                }
            }
        }

        // Affichage des voisins
        /*Case c1 = this.cases.get(new Coordonnee(0, 0));
        Case c2 = this.cases.get(new Coordonnee(3, 3));
        Case c3 = this.cases.get(new Coordonnee(6, 4));
        ArrayList<Case> testCo = new ArrayList<>(Arrays.asList(c1, c2, c3));

        for(Case c : testCo){
            System.out.println("Case : " + c.getCoordonnee());
            ArrayList<Case> voisins = c.getVoisins();

            for(Case caseVoisin  : voisins){
                System.out.println("    -> " + caseVoisin.getCoordonnee());
            }
        }*/




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
