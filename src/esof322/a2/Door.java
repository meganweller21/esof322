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
  Room theDoor;
  
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
   
    public void setDesc(String d) {
        description = d;
    }

  
  public String getDesc(){
      return description;
  }
 
 
 /** A player will need the correct key to enter. */
 public void enter(Player p){
 if (p.haveItem(myKey)) {
    System.out.println("Your key works! The door creaks open,");
    System.out.println("and slams behind you after you pass through.");
    theDoor = p.getLoc();
    theDoor.setDesc("Your keys works! The door creaks open,\n and slams behind you after you pass through.\n"  + p.look());
     //Ashley changed for display purposes in carryingArea
    
    myKey.setDesc("A shiny gold key." );
    if (p.getLoc() == outSite) inSite.enter(p);
    else if (p.getLoc() == inSite) outSite.enter(p); 
 }
 else {System.out.println("You don't have the key for this door!");
       System.out.println("Sorry.");   
       
       theDoor = p.getLoc();
       theDoor.setDesc("You don't have the key for this door!\n Sorry.\n" + p.look());
      }
 }

}
