package esof322.a2;

import java.io.IOException;

public class AdventureGameModelFacade {

    // some private fields to reference current location,
    // its description, what I'm carrying, etc.
    //
    // These methods and fields are left as exercises.
    //initialize variables
    Player thePlayer;
    Adventure theCave;
    Room startRm;
    Room currentRm;
    Room previousRoom;
  
    boolean compareRoom; //used for change of room comparison
    boolean door;

    int Up = 4;
    int Down = 5;
    int North = 0;
    int South = 1;
    int East = 2;
    int West = 3;
            
         
    int direction;
    
    AdventureGameModelFacade() throws IOException { // we initialize
        thePlayer = new Player();
        theCave = new Adventure();
        startRm = theCave.createAdventure();
        thePlayer.setRoom(startRm);
        
    }
    
  

    //directional buttons 
    public void goUp() {
                         //Go UP has direction of 4
       
        thePlayer.go(Up);          //moves our player in that direction
     
        enterRoom();
        
        //trying it without the next line of code S.T.
        //thePlayer.setRoom(currentRm);        //set player in the new room
    }

    public void goDown() {
        thePlayer.go(Down);
        enterRoom();
    }

    public void goNorth() {
                        
        thePlayer.go(North);
        enterRoom();
    }

    public void goSouth() {
                        
        thePlayer.go(South);
        enterRoom();
    }

    public void goEast() {
                       
        thePlayer.go(East);
        enterRoom();
    }

    public void goWest() {
                   
        thePlayer.go(West);
        enterRoom();
    }

    
    public void enterRoom(){
        previousRoom = currentRm;           // this will hold the before value 
        currentRm = thePlayer.getLoc();      //get location of current room
        compareRoom = (previousRoom == currentRm);
        
        //this SOOOO doesn't work but I'm still trying
        door = (currentRm.side[direction] == currentRm );
    }
    
    // You need to finish these getView and getItems methods.
    public String getView() {
         if (!compareRoom) {
            currentRm = thePlayer.getLoc();   //get location of room
            return (currentRm.getDesc());     //return the description of the room
        }
         else if(door){
            return("Your key works! The door creaks open, \nand slams behind you after you pass through.\n");
           
         }
         else if(!door){
              return("You don't have the key for this door!\n Sorry.\n");
         }
         else
        return ("Ouch! That hurts.\n\n" + currentRm.getDesc());
    }
    

    public String getItems() {
        return ("My items: " + thePlayer.showMyThings());
    }

    /*Assumptions -AB
        -If there is more than one item to grab, player grabs first item listed
        -After 'Grab' is clicked, carryingArea text will not change again until 'Grab' or 'Drop' is re-clicked 
    */
    public String grab() {
        if (thePlayer.handsFull()) {
            return thePlayer.getFirstItem() + thePlayer.getSecondItem() + " Your hands are full.";
        } else if (thePlayer.getLoc().roomEmpty()) {
            if (thePlayer.numItemsCarried() == 2) {
                return thePlayer.getFirstItem() + thePlayer.getSecondItem() + " The room is empty.";
            } else if (thePlayer.numItemsCarried() == 1) {
                return thePlayer.getFirstItem() + " The room is empty.";
            } else {
                return "Nothing. The room is empty.";
            }
        } else {
            Item[] possibleItems = thePlayer.getLoc().getRoomContents();
            Item itemToGrab = possibleItems[0];
            thePlayer.pickUp(itemToGrab);
            thePlayer.getLoc().removeItem(itemToGrab);
            if (thePlayer.numItemsCarried() == 1) {
                return itemToGrab.getDesc();
            } else {
                return thePlayer.getFirstItem() + itemToGrab.getDesc();
            }
        }
    }
    
    /*Assumptions -Ashley
        -If there is more than one item to drop, player drops first item listed
        -After 'Drop' is clicked, carryingArea text will not change again until 'Drop' or 'Grab' is re-clicked
    */
    public String drop() {
        //Player had 0 items when 'Drop' was clicked
        if (thePlayer.handsEmpty()) {
            return "Nothing. You have nothing to drop.";
        }
        
        String itemToDrop = thePlayer.getFirstItem();
        Item addItemToRoom = new Item();
        addItemToRoom.setDesc(itemToDrop);
        
        //Player had 2 items when 'Drop' was clicked
        if (thePlayer.numItemsCarried() == 2) {
            //need to check numItemsCarried before calling drop() because of different return options
            thePlayer.drop(1);
            return thePlayer.getFirstItem();
        }
        
        //Player had 1 item when 'Drop' was clicked
        thePlayer.drop(1);
        return "Nothing.";
    }
    
}
