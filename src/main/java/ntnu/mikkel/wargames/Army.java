package ntnu.mikkel.wargames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {

      private Unit unit;
      private String name;
      private List<Unit> units;

      public Army(String name){
        this.name = name;
        units = new ArrayList<Unit>();
      }

  /**
   * Method returns the name of a certain army.
   *
   * @return the name of a certain army.
   */
  public String getName(){
        return name;
      }

  /**
   * Method adds
   *
   * @param unit
   */
  public void addUnit(Unit unit){
        units.add(unit);
      }




      public void addAll(){
      }
    
      public void removeUnit(Unit unit){
        units.remove(unit);
      }
    
      /**
       * Checks if there is units in a Army.
       *
       * @return false if list is empty.
       * @return true if list is populated.
       */

      public boolean hasUnits(){
        return units.isEmpty();
      }
    
      /**
       * Prints all units in a certain army. 
       */
      public void getAllUnits() { // ????
        
          for(Unit unit : units){
              unit.show();
              System.out.println();
          }
      }
      

      public int getRandom() {
        Random random = new Random();
        int randomizer = random.nextInt();

        if (randomizer <= units.size()) {
          return randomizer;
        }
      }


}









