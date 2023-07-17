import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Symbol class
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author Brandon N. Wroblewski
 */
public class SymbolTest { 

    /** Symbol giraffe for testing */
    private Symbol giraffe;

    /** Symbol lion for testing */
    private Symbol lion;

    /**
     * Create Symbols for testing
     */
    @BeforeEach
    public void setUp() {
        giraffe = new Symbol("giraffe", 25);
        lion = new Symbol("lion", 30);
    }

    /** test GetName method with giraffe symbol*/
    @Test
    public void testGetNameGiraffe() {
        assertEquals("giraffe", giraffe.getName(), "giraffe name");
    }   
    
    /** test GetName method with lion symbol */
    @Test
    public void testGetNameLion() {
        assertEquals("lion", lion.getName(), "lion name");
    }  

    /** test getPoints with Giraff symbol */
    @Test
    public void testGetPointsGiraffe() {
        assertEquals(25, giraffe.getPoints(), "giraffe points");
    }   
    
    /** test getPoints with Lion symbol */
    @Test
    public void testGetPointsLion() {
        assertEquals(30, lion.getPoints(), "lion points");
    }    

    /** test toString method with Giraff symbol */
    @Test
    public void testToStringGiraffe() {
        assertEquals("giraffe 25 false", giraffe.toString(), "giraffe toString");        
    }

    /** test toString method with Lion symbol */
    @Test
    public void testToStringLion() {
        assertEquals("lion 30 false", lion.toString(), "lion toString");        
    }

    /** test hasBeenClickedOn method with Giraffe Symbol */
    @Test
    public void testHasBeenClickedOnGiraffe() {
        assertFalse(giraffe.hasBeenClickedOn(), "giraffe hasBeenClickedOn");
    }

    /** test hasBeenClickedOn method with Lion Symbol */
    @Test
    public void testHasBeenClickedOnLion() {
        assertFalse(lion.hasBeenClickedOn(), "lion hasBeenClickedOn");
    }

    /** test setHasBeenClickedOn method with true and false boolean for Giraffe */
    @Test
    public void testSetHasBeenClickedOnGiraffe() {
        giraffe.setHasBeenClickedOn(true);
        assertTrue(giraffe.hasBeenClickedOn(), "giraffe setHasBeenClickedOn true");
        giraffe.setHasBeenClickedOn(false);
        assertFalse(giraffe.hasBeenClickedOn(), "giraffe setHasBeenClickedOn false");
    }

    /** test setHasBeenClickedOn method with true and false boolean for Lion */
    @Test
    public void testSetHasBeenClickedOnLion() {
        lion.setHasBeenClickedOn(true);
        assertTrue(lion.hasBeenClickedOn(), "lion setHasBeenClickedOn true");
        lion.setHasBeenClickedOn(false);
        assertFalse(lion.hasBeenClickedOn(), "lion setHasBeenClickedOn false");
    }

    /** test equals method with Giraffe Symbol as current instance */
    @Test
    public void testEqualsGiraffe() {
        assertTrue(giraffe.equals(giraffe), "giraffe equals with same instance");
        assertTrue(giraffe.equals(new Symbol("giraffe", 25)), 
                   "giraffe equals with different instances");
        assertFalse(giraffe.equals(new Symbol("cow", 25)), "giraffe with different name");
        assertFalse(giraffe.equals(new Symbol("giraffe", 4)), "giraffe with different points");
        assertFalse(giraffe.equals(new Symbol("horse", 5)), 
                    "giraffe with different name and points");
        assertFalse(giraffe.equals(null), "giraffe compared to null object");
        assertFalse(giraffe.equals("giraffe"), "giraffe compared to String");
    }

    /** test equals method with Lion Symbol as current instance */
    @Test
    public void testEqualsLion() {
        assertTrue(lion.equals(lion), "lion equals with same instance");
        assertTrue(lion.equals(new Symbol("lion", 30)), 
                   "lion equals with different instances");
        assertFalse(lion.equals(new Symbol("cow", 30)), "lion with different name");
        assertFalse(lion.equals(new Symbol("lion", 4)), "lion with different points");
        assertFalse(lion.equals(new Symbol("horse", 5)), 
                    "lion with different name and points");
        assertFalse(lion.equals(null), "lion compared to null object");
        assertFalse(lion.equals("lion"), "lion compared to String");
    }
    
    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        
        // Testing constructor with null name
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol(null, 1), "Constructor name null");
        assertEquals("Null name", exception.getMessage(),
                "Testing null name message");
                
        // Testing constructor with 0 points
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol("snake", 0), "Constructor points 0");
        assertEquals("Invalid points", exception.getMessage(),
                "Testing points 0 message");
                
        // Testing constructor with negative points
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Symbol("frog", -5), "Constructor points -5");
        assertEquals("Invalid points", exception.getMessage(),
                "Testing negative points message");
                
    }

}
