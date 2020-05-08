package M2201.TP;

import java.io.IOException;

/**
 *
 * @author Hamadi & Timothé
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.connexion();
        c.creationFlux();
        c.boucleDeDiscussion();
    }
    
}
