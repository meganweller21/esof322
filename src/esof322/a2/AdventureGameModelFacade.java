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
    int theDirection;
    boolean compareRoom; //used for change of room comparison

    AdventureGameModelFacade() throws IOException { // we initialize
        thePlayer = new Player();
        theCave = new Adventure();
        startRm = theCave.createAdventure();
        thePlayer.setRoom(startRm);
        
    }

    //directional buttons 
    public void goUp() {
        theDirection = 4;                    //Go UP has direction of 4
        Room previousRoom;
        thePlayer.go(theDirection);          //moves our player in that direction
        previousRoom = currentRm;           // this will hold the before value 
        currentRm = thePlayer.getLoc();      //get location of current room
        compareRoom = (previousRoom == currentRm);

        //trying it without the next line of code S.T.
        //thePlayer.setRoom(currentRm);        //set player in the new room
    }

    public void goDown() {
        theDirection = 5;                     //Go DOWN has direction of 5
        thePlayer.go(theDirection);
        currentRm = thePlayer.getLoc();
        //thePlayer.setRoom(currentRm);
    }

    public void goNorth() {
        theDirection = 0;                     //Go NORTH has direction of 0
        thePlayer.go(theDirection);
        currentRm = thePlayer.getLoc();
        thePlayer.setRoom(currentRm);
    }

    public void goSouth() {
        theDirection = 1;                     //Go SOUTH has direction of 1
        thePlayer.go(theDirection);
        currentRm = thePlayer.getLoc();
        thePlayer.setRoom(currentRm);
    }

    public void goEast() {
        theDirection = 2;                   //Go East has direction of 2
        thePlayer.go(theDirection);
        currentRm = thePlayer.getLoc();
        thePlayer.setRoom(currentRm);
    }

    public void goWest() {
        theDirection = 3;                 //Go West has direction of 3
        thePlayer.go(theDirection);
        currentRm = thePlayer.getLoc();
        thePlayer.setRoom(currentRm);
    }

    // You need to finish these getView and getItems methods.
    public String getView() {
        if (!compareRoom) {
            currentRm = thePlayer.getLoc();   //get location of room
            return (currentRm.getDesc());      //return the description of the room
        }
        return ("Ouch! That hurts.");

    }

    public String getItems() {
        return ("My items: " + thePlayer.showMyThings());
    }

    /*Assumptions -AB
        -Player does not select what item to grab
        -After 'Grab' is clicked, carryingArea text will not change again until 'Grab' or 'Drop' is re-clicked 
    */
    public String grab() {
        if (thePlayer.handsFull()) {
            return "Your hands are full.";
        } else if (thePlayer.getLoc().roomEmpty()) {
            return "The room is empty.";
        } else {
            Item[] possibleItems = thePlayer.getLoc().getRoomContents();
            Item itemToGrab = possibleItems[0];
            thePlayer.pickUp(itemToGrab);
            thePlayer.getLoc().removeItem(itemToGrab);
            if (thePlayer.numItemsCarried() == 1) {
                return itemToGrab.getDesc();
            } else {
                // hard-coded in for better formatting because key's description (an immutable String)
                // is  Your key works! The door creaks open,and slams behind you after you pass through.
                return thePlayer.getFirstItem() + " and " + itemToGrab.getDesc();
            }
        }
    }
    
    /*Assumptions -AB
        -Player does not select what item to drop
        -Player always drops one item
        -Player always drops the first item that was collected
        -After 'Drop' is clicked, carryingArea text will not change again until 'Drop' or 'Grab' is re-clicked  
    */
    public String drop() {
        //Player had 0 items when 'Drop' was clicked
        if (thePlayer.handsEmpty()) {
            return "You have nothing to drop.";
        }
        String itemToDrop = thePlayer.getFirstItem();
        Item addItemToRoom = new Item();
        addItemToRoom.setDesc(itemToDrop);
        
        //Player had 2 items when 'Drop' was clicked
        //HAS NOT BEEN TESTED
        if (thePlayer.numItemsCarried() == 2) {
            //need to check numItemsCarried before calling drop() because of different return options
            thePlayer.drop(1);
            return thePlayer.getFirstItem();
        }
        thePlayer.drop(1);
        //Player had 1 item when 'Drop' was clicked
        return "Nothing";
    }

}
