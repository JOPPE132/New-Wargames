package ntnu.mikkel.wargames.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import ntnu.mikkel.wargames.data.Unit;

/**
 * Army is an collection of Units who can attack other units in a battle.
 */
public class Army {

  private String name;
  private final ArrayList<Unit> units;

  /**
   * Creates an object of Army.
   *
   * @param name the name of the army.
   * @throws IllegalArgumentException illegal argument in Army.
   */
  public Army(String name) throws IllegalArgumentException {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name can not be null.");
    }
    this.name = name;
    this.units = new ArrayList<>();
  }

  /**
   * Returns arraylist of Army.
   *
   * @return returns arraylist of Army.
   */
  public List<Unit> getArrayList() {
    return this.units;
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
    if (unit == null) {
      throw new IllegalArgumentException("Unit can not be null");
    } else {
      units.add(unit);
    }
  }

  /**
   * Method adds all units from a collection of units, to an Army.
   *
   * @param newUnits the name of the collection you wish to add to an army.
   */
  public void addAll(List<Unit> newUnits) {
    if (newUnits.isEmpty()) {
      System.out.println("There is nothing to be added.");
    }
    int index = 0;

    Iterator<Unit> it = newUnits.iterator();

    while (it.hasNext()) {

      if (index >= 0 && index < newUnits.size()) {
        Unit unit = it.next();
        this.units.add(unit);
      }
      index++;
    }
  }

  /**
   * Sets a new name to the Army.
   *
   * @param newName the new name of the Army.
   */
  public void setName(String newName) {
    this.name = newName;
  }

  /**
   * Method removes a unit from an army.
   *
   * @param unit the unit you wish to remove.
   */
  public void removeUnit(Unit unit) {
    units.remove(unit);
  }

  /**
   * Checks if a army has units.
   *
   * @return true if list contains no elements. false if otherwise.
   */
  public boolean hasUnits() {
    return units.size() > 0;
  }

  /**
   * Returns the size of an Army.
   *
   * @return the size of an Army.
   */
  public int getSize() {
    return units.size();
  }

  /**
   * Prints out details about every unit in an Army.
   */
  public void getAllUnits() {
    if (units.isEmpty()) {
      System.out.println("The army is currently empty.");
    }
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
  public List<Unit> getInfantryUnits() { //Løsning funker, men ikke optimal. Hva om infantryunit har annet navn et "Infantry"?
    List<Unit> infantryUnits = new ArrayList();
    infantryUnits = this.units.stream().
        filter(infantryUnit -> infantryUnit.getName().equals("Infantry"))
        .collect(Collectors.toList());

    return infantryUnits;
  }

  /**
   * Method compares two objects.
   *
   * @param o the object to compare.
   * @return true or false whether the objects are equal or not.
   * True if equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Army army = (Army) o;
    return name.equals(army.name) && units.equals(army.units);
  }

  /**
   * Returns the hashcode of the object.
   *
   * @return returns the hashcode of the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, units);
  }

  /**
   * Method returns a list of units containing only RangedUnits.
   *
   * @return returns a list of units only containing RangedUnits.
   */
  public List<Unit> getRangedUnits() {
    List<Unit> rangedUnits = new ArrayList();
    rangedUnits = this.units.stream().filter(rangedUnit -> rangedUnit.getName().equals("Ranged"))
        .collect(Collectors.toList());

    return rangedUnits;
  }

  /**
   * Method returns a list of units containing only CavalryUnits.
   *
   * @return returns a list of units only containing CavalryUnits.
   */
  public List<Unit> getCavalryUnits() {
    List<Unit> cavalryUnits = new ArrayList();
    cavalryUnits = this.units.stream().filter(rangedUnit -> rangedUnit.getName().equals("Cavalry"))
        .collect(Collectors.toList());

    return cavalryUnits;
  }

  /**
   * Method returns a list of units containing only CmmanderUnits.
   *
   * @return returns a list of units only containing CommanderUnits.
   */
  public List<Unit> getCommanderUnits() {
    List<Unit> commanderUnits = new ArrayList();
    commanderUnits =
        this.units.stream().filter(commanderUnit -> commanderUnit.getName().equals("Commander"))
            .collect(Collectors.toList());

    return commanderUnits;
  }
}