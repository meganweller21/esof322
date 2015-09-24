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

    // I'm assuming there's only one potential item to grab...is this allowed??? -A
//    public String getItemSelection() {
//        String items="";
//        for (int i = 0; i < contentsArray.length; i++) {
//                items += ((i + 1) + ": "+ contentsArray[i].getDesc());
//            }
//        return "The room has:" + items;
//    }
    
    // Surely you will need other methods to deal with
    // picking up and dropping things.
    //THIS DID HAVE A VOID RETURN TYPE, MIGHT NOT BE ALLOWED TO CHANGE? -A...Pretty Little Liars reference :)
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
            return itemToGrab.getDesc();
        }
    }

    //I'll get rid of this once I know for sure it is safe to assume the user won't be picking an item to grab -A
//    public Item choosePickupItem() {
//        String inputString = "prepare";
//        int theChoice = -1;
//
//        do {
//            getItemSelection();
//                
//            System.out.print("Enter the number of the item to grab: ");
//            inputString = keyB.readLine();
//            System.out.println('\n');
//            if (inputString.equals("")) {
//                inputString = " ";
//            }
//            try {
//                theChoice = Integer.parseInt(inputString);
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input.");
//                theChoice = -1;
//            }
//            if (theChoice < 0 || theChoice > contentsArray.length) {
//                System.out.print("That item is not in the room.");
//            }
//        } while (theChoice < 0 || theChoice > contentsArray.length);
//
//        return contentsArray[theChoice - 1];
//    }
    
    public void drop() {

    }

}
