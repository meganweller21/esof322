package esof322.a2;


/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    
**/

// class Door

public class Door implements CaveSite {
  /** In this implementation doors are always locked.
      A player must have the correct key to get through
      a door.  Doors automatically lock after a player
      passes through. */

  private Key myKey;
  private String description;
  private Door door;
  
  /** The door's location. */
  private CaveSite outSite;
  private CaveSite inSite;

  public void setDesc(String d){
    description = d;
    }
  
  public String getDesc(){
      return description;
  }
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
   // door.setDesc("Your key works! The door creaks open,");
     //Ashley changed for display purposes in carryingArea
    myKey.setDesc(/*"Your key works! The door creaks open," + "and slams behind you after you pass through."*/"A shiny gold key." );
    if (p.getLoc() == outSite) inSite.enter(p);
    else if (p.getLoc() == inSite) outSite.enter(p); 
 }
 else {System.out.println("You don't have the key for this door!");
       System.out.println("Sorry.");    
       //door.setDesc("You don't have the key for this door!");
      }
 }

}

