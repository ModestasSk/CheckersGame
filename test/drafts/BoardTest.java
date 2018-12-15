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
public class BoardTest {   
    @Test
    public void testGetBoardSize() {
        System.out.println("getBoardSize");
        Board instance = new Board(8, 3, 'O', 'X', ' ', '-');
        int expResult = 8;
        int result = instance.getBoardSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    
    
}
