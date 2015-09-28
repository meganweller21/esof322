package esof322.a2;

/**
 * Adventure Game Program Code Copyright (c) 1999 James M. Bieman
 *
 * To compile: javac AdventureGame.java To run: java AdventureGame
 *
 * The main routine is AdventureGame.main
 *
 *
 */
// class Door
public class Door implements CaveSite {


  private Key myKey;
  private String description;
  private Room theDoor;
  private Room currentRm;
  
  /** The door's location. */
  private CaveSite outSite;
  private CaveSite inSite;

    /**
     * In this implementation doors are always locked. A player must have the
     * correct key to get through a door. Doors automatically lock after a
     * player passes through.
     */
  
     /** We can construct a door at the site. */
  Door(CaveSite out, CaveSite in, Key k){
    outSite = out;
    inSite = in;
    myKey = k;
  }
  
 /** A player will need the correct key to enter. */
 public void enter(Player p){
 if (p.haveItem(myKey)) {
    System.out.println("Your key works! The door creaks open,");
    System.out.println("and slams behind you after you pass through.");
    
    //Ashley changed for display purposes in carryingArea  
    myKey.setDesc("A shiny gold key.");
    
    if (p.getLoc() == outSite){
        inSite.enter(p);
        description = ("Your keys works! The door creaks open,\n and slams behind you after you pass through.\n");
        
        
    }
    else if (p.getLoc() == inSite){
        outSite.enter(p);
        theDoor.setDesc("Your keys works! The door creaks open,\n and slams behind you after you pass through.\n");
        
    } 
  }
  else {System.out.println("You don't have the key for this door!");
       System.out.println("Sorry.");   
       
       currentRm = p.getLoc();
       description = currentRm.getDesc();
       theDoor = p.getLoc();
    
       
       theDoor.setDesc("You don't have the key for this door!\n Sorry. \n");
       theDoor.setDesc(description);
       
      }
 
 }

}
