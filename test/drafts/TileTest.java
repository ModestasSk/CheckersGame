/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drafts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TileTest {
  
    @Test
    public void testGetDefaultIcon() {
        System.out.println("getDefaultIcon");
        Tile instance = new Tile(0,0,'-');
        char expResult = '-';
        char result = instance.getDefaultIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testSetDefaultIcon() {
        System.out.println("setDefaultIcon");
        char defaultIcon = '-';
        Tile instance = new Tile(0,0,'x');
        instance.setDefaultIcon(defaultIcon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
