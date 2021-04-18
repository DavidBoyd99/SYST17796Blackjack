/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class PlayerIT {
    
    public PlayerIT() {
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
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCredits method, of class Player.
     */
    @Test
    public void testGetCredits() {
        System.out.println("getCredits");
        Player instance = null;
        int expResult = 0;
        int result = instance.getCredits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateHand method, of class Player.
     */
    @Test
    public void testCalculateHand() {
        System.out.println("calculateHand");
        Player instance = null;
        int expResult = 0;
        int result = instance.calculateHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
