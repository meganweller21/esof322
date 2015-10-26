
package esof322.a3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Megan Weller
 */
public class AllTest {
    
    public AllTest() {
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
       
    //Door Class test cases
    //Tests when player enters door
    @Test
    public void testEnterDoor(){
        /*For player to enter the door, they must have the key; it will print that the player
        does not have the key. If they do, it will print that they entered the door and set the
        new location. 
        */
        /*
        This method uses 
            1)Player haveItem()
            2)Player setDesc()
            3)Player getLoc()
            4)Cavesite enter()
        */
        
        Player thePlayer = new Player();
        Key theKey = new Key();
        Room r1 = new Room();
        Room r2 = new Room();
     
          //Make the door and the walls, add Player into room
        Door theDoor = new Door(r1, r2, theKey); 
        
        r1.setSide(4, theDoor);
        r2.setSide(5, theDoor);
        thePlayer.setRoom(r1);
        
        //fix r1 to be a new room
        Room expectedRoom1 = r1;
       
        //Test r1 into r2 without the key
        theDoor.enter(thePlayer);
        Room actualRoom1 = thePlayer.getLoc();
        assertTrue(actualRoom1.equals(expectedRoom1));
        
        //Test r1 into r2 with the key
        Room expectedRoom2 = r2; 
        
        r1.addItem(theKey);
        thePlayer.pickUp(theKey);
        theDoor.enter(thePlayer);
        Room actualRoom2 = thePlayer.getLoc();
        assertTrue(actualRoom2.equals(expectedRoom2));
        
        
        //Test r2 into r1 with the key
        thePlayer.setRoom(r2);
        Room expectedRoom3 = r1;
        
        theDoor.enter(thePlayer);
        Room actualRoom3 = thePlayer.getLoc();
        assertTrue(actualRoom3.equals(expectedRoom3));
        
        
        //Test r2 into r1 without the key
        thePlayer.setRoom(r2);
        Room expectedRoom4 = r2;
        thePlayer.drop(1);
        theDoor.enter(thePlayer);
        Room actualRoom4 = thePlayer.getLoc();
        assertTrue(actualRoom4.equals(expectedRoom4));
         
    }
    //--------------------------------------------------------------------------
    //Player Class test cases
    //Tests the player to go into a room
    @Test
    public void testGoPlayer(){
        /* For the player to enter the room, we need to use these methods:
            1) Room setLoc()
            2) Room exit()
            3) Room setSide()
        
        */
        Player thePlayer = new Player();
        Room r1 = new Room();
        Room r2 = new Room();
        
        //Expected Room is r2, where we are intending to end up
        Room expectedRoom = r2; 
        
        //Making the sides and adding the Player into Room 1
        r1.setSide(4, r2);      
        r2.setSide(5, r1);      
        thePlayer.setRoom(r1); 
        
        thePlayer.go(4);
        Room actual = thePlayer.getLoc();
        
        //check to see if player is in the expected room which is r2
        assertTrue(actual.equals(expectedRoom));        
    }
    //-------------------------------------------
    //Test for player to pick up an item
    @Test
    public void testPickUpItem(){
        /* Test case uses methods:
            1) Player setLoc()
            2) Room addItem()
            3) Room removeItem()
           
        */
        Player thePlayer = new Player();
        Room r1 = new Room();
        Key key1 = new Key();
        int numExpected1 = 1;
        int numExpected2 = 2;
        
        //Test for one item
        thePlayer.setLoc(r1);
        r1.addItem(key1);
        thePlayer.pickUp(key1);
        assertTrue(thePlayer.numItemsCarried() == numExpected1);
      
        
        //Test for three items to test all cases
        Key key2 = new Key();
        Key key3 = new Key();
        r1.addItem(key2);
        r1.addItem(key3);
        thePlayer.pickUp(key2);
        thePlayer.pickUp(key3);
        assertTrue(thePlayer.numItemsCarried() == numExpected2);
        //Expected only two because there is a limit of 2   
        
    }
    //-------------------------------------------
    //Tests for the player to drop an item
    @Test 
    public void testDropItem(){
        /*Test cases uses methods:
            1) Room addItem()
            2) Player setRoom()
            3) Player pickUp()
        
        */
        Player thePlayer = new Player();
        Room r1 = new Room();
        Key key1 = new Key();
        Key key2 = new Key();
        int numExpectedTest1 = 1;
        int numExpectedTest0 = 0;
      
 
        r1.addItem(key1);
        r1.addItem(key2);
        
        thePlayer.setRoom(r1);
        thePlayer.pickUp(key1);
        thePlayer.pickUp(key2);
        
        //Drop one item from two items in inventory
        thePlayer.drop(2);
        assertEquals(thePlayer.numItemsCarried(), numExpectedTest1);
        
        //Drop the 'third' item - to check the if statement
        thePlayer.drop(3);
        assertEquals(thePlayer.numItemsCarried(), numExpectedTest1);
        
        //Drop the 'zero' item - to check the if statement
        thePlayer.drop(0);
        assertEquals(thePlayer.numItemsCarried(), numExpectedTest1);
        
        //Drop one item from one item in inventory
        thePlayer.drop(1);
        assertEquals(thePlayer.numItemsCarried(), numExpectedTest0);
    }
    
    //--------------------------------------------------------------------------
    //Room Class test cases
    //Tests adding an item into a room
    @Test
    public void testAddItem(){
        /* Test case uses methods:
            1) Room getRoomContents()
        
        */
        Room r1 = new Room();
        Key theKey = new Key();
        Key expectedKey = theKey;
        
        r1.addItem(theKey);
        Item[] actual = new Item[1];
        
        //returns the key added in the room
        actual = r1.getRoomContents();
        //checks if the key in the array macthes the original key
            
    }
      //-------------------------------------------
    @Test
    //Tests removing an item from a room
    public void testRemoveItem(){
          /* Test case uses methods:
            1) Room addItem()    
            2) Room roomEmpty()
        */
        
        Room r1 = new Room();
        Key theKey = new Key();
      
        //Expecting the room to be empty
        boolean expectedEmpty = true;
        
        r1.addItem(theKey);
        r1.removeItem(theKey);
        
        boolean empty = r1.roomEmpty();
        
    }
      //-------------------------------------------
    @Test
    //tests entering a room
    public void testEnterRoom(){
        /* Test case uses methods: 
            1) Room setSide()
            2) Room setRoom()
            3) Player getLoc()
        */
        Player thePlayer = new Player();
        Room r1 = new Room();
        Room r2 = new Room();
        Room expectedRoom = r2;
        
        r1.setSide(4, r2);
        r2.setSide(5, r1);
        
        thePlayer.setRoom(r1);
        r2.enter(thePlayer);
        Room actualRoom = thePlayer.getLoc();
        
        assertTrue(actualRoom.equals(expectedRoom));           
    }
      //-------------------------------------------
    @Test
    //tests exiting a room
    public void testExitRoom(){
         /* Test case uses methods:
            1) Room setSide()
            2) Room setRoom()
            3) Player getLoc()
        */
        Player thePlayer = new Player();
        Room r1 = new Room();
        Room r2 = new Room();
        Room expectedRoom = r2;
        
        r1.setSide(4, r2);
        r2.setSide(5, r1);
        
        thePlayer.setRoom(r1);
        r1.exit(4, thePlayer);
        Room actualRoom = thePlayer.getLoc();
        
        assertTrue(actualRoom.equals(expectedRoom)); 
        
    }
    
    
}