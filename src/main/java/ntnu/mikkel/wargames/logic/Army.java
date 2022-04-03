package ntnu.mikkel.wargames.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import ntnu.mikkel.wargames.data.CavalryUnit;
import ntnu.mikkel.wargames.data.InfantryUnit;
import ntnu.mikkel.wargames.data.Unit;

/**
 * Army is an collection of Units who can attack other units in a battle.
 */
public class Army {

  private final String name;
  private final ArrayList<Unit> units;

  public Army(String name) {
    this.name = name;
    units = new ArrayList<>();
  }

  /**
   * Method returns the name of an army.
   *
   * @return the name of a certain army.
   */
  public String getName() {
    return name;
  }

  /**
   * Method adds a unit to an Army.
   *
   * @param unit name of the unit you wish to add to an army.
   */
  public void addUnit(Unit unit) {
    units.add(unit);
  }

  /**
   * Method adds all units from a collection of units, to an Army.
   *
   * @param listUnits the name of the collection you wish to add to an army.
   */
  public void addAll(List<Unit> listUnits) {
    int index = 0;

    Iterator<Unit> it = listUnits.iterator();

    while (it.hasNext()) {

      if (index >= 0 && index < listUnits.size()) {
        Unit units = it.next();
        this.units.add(units);
      }
      index++;
    }
  }

  public void removeUnit(Unit unit) {
    units.remove(unit);
  }

  /**
   * Checks if there is units in a Army.
   *
   * @return false if list is empty.
   * @return true if list is populated.
   */

  /**
   * Checks if a army has units.
   *
   * @return true if list contains no elements. false if otherwise.
   */
  public boolean hasUnits() {
    return units.isEmpty();
  }

  /**
   * Prints out details about every unit in an Army.
   */
  public void getAllUnits() {
    this.units.forEach((Unit u) -> {
      System.out.println(u.toString());
    });
  }

  /**
   * Method uses the random class to randomly choose a unit from an army of units.
   *
   * @return a random unit from an army.
   */
  public Unit getRandomunit() {
    Random random = new Random();
    Unit randomUnit;
    randomUnit = units.get(random.nextInt(units.size()));
    return randomUnit;
  }

  /**
   * Methods returns a list of units containing only InfantryUnits.
   *
   * @return returns a list of units containing only InfantryUnits.
   */
  public List<Unit> getInfantryUnits(){ //Løsning funker, men ikke optimal. Hva om infantryunit har annet navn et "Infantry"?
  List<Unit> allUnits = new ArrayList();
  allUnits = this.units.stream().
        filter(infantryUnit -> infantryUnit.getName().equals("Infantry")).collect(Collectors.toList());

  return allUnits;
  }

//  public ArrayList<Unit> getRangedUnits(){
//  }
//
//  public ArrayList<Unit> getCavalryUnits(){
//  }
//
//  public ArrayList<Unit> getCommanderUnits(){
//  }
}









