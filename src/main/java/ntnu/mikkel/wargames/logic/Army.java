package ntnu.mikkel.wargames.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ntnu.mikkel.wargames.data.Unit;

/**
 * Army is an collection of Units who can attack other units in a battle.
 */
public class Army {

      private final String name;
      private final List<Unit> army;

      public Army(String name){
        this.name = name;
        army = new ArrayList<>();
      }

  /**
   * Method returns the name of an army.
   *
   * @return the name of a certain army.
   */
  public String getName(){
        return name;
      }

    /**
     * Method adds a unit to an Army.
     *
     * @param unit
     */
      public void addUnit(Unit unit){
        army.add(unit);
      }



      public void addAll(ArrayList<Unit> allUnits){
      }
    
      public void removeUnit(Unit unit){
        army.remove(unit);
      }
    
      /**
       * Checks if there is units in a Army.
       *
       * @return false if list is empty.
       * @return true if list is populated.
       */

      public boolean hasUnits(){
        return army.size() > 0;
      }

      public void getAllUnits(){ //Med lambdautrykk
        this.army.forEach((Unit u)-> {
          System.out.println(u.toString());
        });
      }

      public Unit getRandomunit() {
        Random random = new Random();
        Unit randomUnit;
        randomUnit = army.get(random.nextInt(army.size()));
        return randomUnit;
      }
}









