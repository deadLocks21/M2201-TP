package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;

import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;

import static forageria.metier.carte.ressources.TypeMateriau.*;
import static forageria.metier.carte.ressources.TypeRessource.ARBRE;

/**
 * Etat permettant de crafter des ressources.
 */
public class EtatCrafterRessource extends Etat {
    /**
     * Matériau que l'on veut crafter.
     */
    TypeMateriau materiau;

    /**
     * Constructeur d'un EtatCrafterRessource.
     *
     * @param module Valeur de la variable module.
     */
    public EtatCrafterRessource(ModuleDecision module, TypeMateriau materiau) {
        super(module);

        this.materiau = materiau;
    }


    @Override
    public Etat transition() {
        Etat nouvelEtat;

        switch (materiau){
            case CHARBON:
                ArrayList<TypeRessource> bois = new ArrayList<>();
                bois.add(ARBRE);

                nouvelEtat = getMemoire().getQuantiteMateriel(BOIS) < 2 ? new EtatRechercheRessource(getModule(), bois) : new EtatCrafterAuFourneau(getModule(), materiau);
                break;

            case LINGOTFER:
                ArrayList<TypeRessource> fer = new ArrayList<>();
                fer.add(TypeRessource.FER);

                if (getMemoire().getQuantiteMateriel(CHARBON) < 1)
                    nouvelEtat = new EtatCrafterRessource(getModule(), CHARBON);

                else if (getMemoire().getQuantiteMateriel(FER) < 2)
                    nouvelEtat = new EtatRechercheRessource(getModule(), fer);

                else
                    nouvelEtat = new EtatCrafterAuFourneau(getModule(), LINGOTFER);
                break;

            case LINGOTOR:
                ArrayList<TypeRessource> or = new ArrayList<>();
                or.add(TypeRessource.OR);

                if (getMemoire().getQuantiteMateriel(CHARBON) < 1)
                    nouvelEtat = new EtatCrafterRessource(getModule(), CHARBON);

                else if (getMemoire().getQuantiteMateriel(OR) < 2)
                    nouvelEtat = new EtatRechercheRessource(getModule(), or);

                else
                    nouvelEtat = new EtatCrafterAuFourneau(getModule(), LINGOTOR);
                break;

            case PIECE:
                nouvelEtat = getMemoire().getQuantiteMateriel(TypeMateriau.LINGOTOR) < 2 ? new EtatCrafterRessource(getModule(), TypeMateriau.LINGOTOR) : new EtatCrafterALaForge(getModule(), PIECE);
                break;

            default:
                nouvelEtat = new EtatAttendre(getModule());
        }

        return nouvelEtat;
    }

    @Override
    public void action() {

    }
}
