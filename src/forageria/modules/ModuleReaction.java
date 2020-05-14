package forageria.modules;

import forageria.IA;

/**
 * Module en charge de la réaction de l'IA à un message du serveur
 * @author Matthieu
 */
public class ModuleReaction extends Module {

    public ModuleReaction(IA ia) {
        super(ia);
    }
    
    /**
     * Méthode principale de réaction à un message du serveur
     * @param messageEnvoye dernier message envoyé au serveur
     * @param messageRecu dernier message reçu du serveur
     */
    public void reagirAuMessageRecu(String messageEnvoye, String messageRecu) {
        switch(messageEnvoye) {
            case "MAP" :
                reactionCarte(messageRecu) ;
                break ;
            case "PLAYER" :
                reactionJoueur(messageRecu); ;
                break ;
        }
    }

    /**
     * Réaction si on a demandé la carte
     *
     *
     * @param messageRecu Message recu contenant la carte.
     */
    public void reactionCarte(String messageRecu) {
        this.getIA().getModuleMemoire().genererCarte(messageRecu) ;
    }

    public void reactionJoueur(String messageRecu){
        this.getIA().getModuleMemoire().genererJoueur(messageRecu);
    }

}
