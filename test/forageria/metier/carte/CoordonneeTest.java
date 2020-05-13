/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.carte;

import forageria.metier.TypeMouvement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deadLocks21
 */
public class CoordonneeTest {
    
    public CoordonneeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLigne method, of class Coordonnee.
     */
    @Test
    public void testGetLigne() {
        System.out.println("getLigne");
        Coordonnee instance = null;
        int expResult = 0;
        int result = instance.getLigne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColonne method, of class Coordonnee.
     */
    @Test
    public void testGetColonne() {
        System.out.println("getColonne");
        Coordonnee instance = null;
        int expResult = 0;
        int result = instance.getColonne();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVoisin method, of class Coordonnee.
     */
    @Test
    public void testGetVoisin() {
        System.out.println("getVoisin");
        TypeMouvement mouvement = null;
        Coordonnee instance = null;
        Coordonnee expResult = null;
        Coordonnee result = instance.getVoisin(mouvement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMouvementPourAller method, of class Coordonnee.
     */
    @Test
    public void testGetMouvementPourAller() {
        System.out.println("getMouvementPourAller");
        Coordonnee destination = null;
        Coordonnee instance = null;
        TypeMouvement expResult = null;
        TypeMouvement result = instance.getMouvementPourAller(destination);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Coordonnee.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Coordonnee instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Coordonnee.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Coordonnee instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
