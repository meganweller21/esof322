
import esof322.a1.Vector3D;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Megan Weller, Ashley Bertrand, Sheila Tupker
 */
public class Vector3DTest {
    
    public Vector3DTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //Ashley
    @Test
    public void testAdd() {
    
    }
    
    @Test
    public void testDot() {
    
    }
    
    @Test
    public void testToString() {
    
    }
    
    //Megan
    
    @Test
    public void testEquals(){
        Vector3D expVector = new Vector3D(2,4,6);
        Vector3D vector = new Vector3D(1,2,3);
        vector = vector.scale(2);
        boolean result = vector.equals(expVector, vector);
        System.out.println(result);
        assertTrue(result);
        
    }
    
    @Test
    public void testScale(){
        Vector3D expVector = new Vector3D(0,0,0);
        Vector3D vector = new Vector3D(0,0,0);
        vector = vector.scale(2);
        
        
        //failing for some reason
        assertEquals(expVector, vector);
        
    }
    
    //Sheila
    
    
}
