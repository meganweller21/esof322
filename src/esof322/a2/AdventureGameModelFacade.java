package esof322.a2;

import java.io.IOException;

public class AdventureGameModelFacade {

 // some private fields to reference current location,
 // its description, what I'm carrying, etc.
 //
 // These methods and fields are left as exercises.
   
    Player thePlayer;
    Adventure theCave;
    Room startRm;
    Room currentRm;
         
  AdventureGameModelFacade() throws IOException { // we initialize
        thePlayer = new Player();
        theCave = new Adventure();
        startRm = theCave.createAdventure();
        thePlayer.setRoom(startRm);
     
  }
  
  int theDirection;

   public void goUp(){
       theDirection = 4;
       thePlayer.go(theDirection);
       currentRm = thePlayer.getLoc();
       thePlayer.setRoom(currentRm);
      
   }

  public void goDown(){
      theDirection = 5;
      thePlayer.go(theDirection);
      currentRm = thePlayer.getLoc();
      thePlayer.setRoom(currentRm);
    }

  public void goNorth(){
      theDirection = 0;
       thePlayer.go(theDirection);
      currentRm = thePlayer.getLoc();
      thePlayer.setRoom(currentRm);
    }
      
  public void goSouth(){
      theDirection = 1;
       thePlayer.go(theDirection);
      currentRm = thePlayer.getLoc();
      thePlayer.setRoom(currentRm);
    }

  public void goEast(){
      theDirection = 2;
       thePlayer.go(theDirection);
      currentRm = thePlayer.getLoc();
      thePlayer.setRoom(currentRm);
    }
      
  public void goWest(){
      theDirection = 3;
       thePlayer.go(theDirection);
      currentRm = thePlayer.getLoc();
      thePlayer.setRoom(currentRm);
    }

  // You need to finish these getView and getItems methods.
  public String getView(){ 
     currentRm = thePlayer.getLoc(); 
     currentRm.getDesc();
     thePlayer.look(); 
     
     return(currentRm.getDesc());
     }

  public String getItems(){

     return("My items: " + thePlayer.showMyThings());
     }

 // Surely you will need other methods to deal with
 // picking up and dropping things.
  
  public void grab(){
     
  }
  
  public void drop(){
      
  }

}
