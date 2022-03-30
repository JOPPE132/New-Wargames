package ntnu.mikkel.wargames.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import ntnu.mikkel.wargames.data.Unit;

/**
 * Army is an collection of Units who can attack other units in a battle.
 */
public class Army {

    private String name;
    private final List<Unit> army;

  /**
   * Constructor creates an object of Army.
   *
   * @param name the name of the Army.
   */
  public Army(String name){
      if(name == null || name.equals("")){
        name = "SomeArmy";
      }
        this.name = name;
        army = new ArrayList<>();
      }

    public Army(String name, List<Unit> units){
      if(name == null || name.equals("")){
        name = "SomeArmy";
      }
      this.name = name;
      this.army = units;
    }

    /**
     * Method returns the name of an army.
     *
     * @return the name of an army.
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

    /**
    * Method adds all units from a list to the Army list.
    *
    * @param listUnits variable of the list you wish to add to Army.
    */
    public void addAll(List<Unit> listUnits){
      int index = 0;

      Iterator<Unit> it = listUnits.iterator();

      while(it.hasNext()){

      if(index >= 0 && index < army.size()){
        Unit units = it.next();
        army.add(units);
      }
      index++;
    }
    }

    /**
    * Method removes an unit from the Army.
    *
    * @param unit the unit you wish to remove.
    */
    public void removeUnit(Unit unit){
        army.remove(unit);
      }
    
      /**
       * Checks if there are units in an Army.
       *
       * @return false if list is empty.
       * @return true if list is populated.
       */
      public boolean hasUnits(){
        return !army.isEmpty();
      }

      public void getAllUnits(){
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

  /**
   *
   *
   * @return
   */
  @Override
      public String toString() {
        return "Army{" +
            "name='" + name + '\'' +
            ", army=" + army +
            '}';
  }
}









