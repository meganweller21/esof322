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
        thePlayer.go(theDirection);          //moves our player in that direction
       
        previousRoom = currentRm;   
        currentRm = thePlayer.getLoc();   
        compareRoom = (previousRoom == currentRm);

        //trying it without the next line of code S.T.
        //I'm going to keep it in there,
        //we may need it for the key implementation
        //or we may not.. just in case type of thing
       thePlayer.setRoom(currentRm);
    }

    public void goDown() {
        theDirection = 5;                     //Go DOWN has direction of 5
        thePlayer.go(theDirection);
        
        previousRoom = currentRm;   
        currentRm = thePlayer.getLoc();   
        compareRoom = (previousRoom == currentRm);
        
        thePlayer.setRoom(currentRm);
    }

    public void goNorth() {
        theDirection = 0;                     //Go NORTH has direction of 0
        thePlayer.go(theDirection);
        
        previousRoom = currentRm;   
        currentRm = thePlayer.getLoc();   
        compareRoom = (previousRoom == currentRm);
        
        thePlayer.setRoom(currentRm);
    }

    public void goSouth() {
        theDirection = 1;                     //Go SOUTH has direction of 1
        thePlayer.go(theDirection);
       
        previousRoom = currentRm;   
        currentRm = thePlayer.getLoc();   
        compareRoom = (previousRoom == currentRm);
        
        thePlayer.setRoom(currentRm);
    }

    public void goEast() {
        theDirection = 2;                   //Go EAST has direction of 2
        thePlayer.go(theDirection);
      
        previousRoom = currentRm;   
        currentRm = thePlayer.getLoc();   
        compareRoom = (previousRoom == currentRm);
       
        thePlayer.setRoom(currentRm);
    }

    public void goWest() {
        theDirection = 3;                 //Go WEST has direction of 3
        thePlayer.go(theDirection);
       
        previousRoom = currentRm;   
        currentRm = thePlayer.getLoc();   
        compareRoom = (previousRoom == currentRm);
        
        thePlayer.setRoom(currentRm);
    }

    // You need to finish these getView and getItems methods.
    public String getView() {
        if (!compareRoom) {
            currentRm = thePlayer.getLoc();   //get location of room
            return (currentRm.getDesc());      //return the description of the room
        }
        return ("Ouch! That hurts.\n\n" + currentRm.getDesc());

    }

    
    public String getItems() {

        return ("My items: " + thePlayer.showMyThings());
    }

    // Surely you will need other methods to deal with
    // picking up and dropping things.
    public void grab() {

    }

    public void drop() {

    }

}
