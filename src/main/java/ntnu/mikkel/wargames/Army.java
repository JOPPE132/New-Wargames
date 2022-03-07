package ntnu.mikkel.wargames;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {

      private boolean hasUnits;
      private final String name;
      private final List<Unit> units;

      public Army(String name){
        this.name = name;
        units = new ArrayList<>();
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
        return hasUnits = units.size() > 0;
      }

      public void getAllUnits(){ //Med lambdautrykk
        this.units.forEach(
          u -> System.out.println(u)); //Kan bruke toString i sout(..).
      }

      public Unit getRandomunit() {
        Random random = new Random();
        Unit randomUnit;

        randomUnit = units.get(random.nextInt(units.size()));

        return randomUnit;
      }






}









