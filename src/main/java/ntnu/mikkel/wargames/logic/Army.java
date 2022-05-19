package ntnu.mikkel.wargames.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import ntnu.mikkel.wargames.data.Unit;

/**
 * Army is an collection of Units who can attack other units in a battle.
 */
public class Army {

  private String name;
  private final ArrayList<Unit> units;
  private final ArmyHandler armyHandler;


  public Army(String name) throws IOException {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name can not be null.");
    }
    this.name = name;
    armyHandler = new ArmyHandler();
    units = new ArrayList<>();
  }

  public List<Unit> getArrayList() {
    return units;
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
   * @param listUnits the name of the collection you wish to add to an army.
   */
  public void addAll(List<Unit> listUnits) {
    if (listUnits.isEmpty()) {
      System.out.println("There is nothing to be added.");
    }
    int index = 0;

    Iterator<Unit> it = listUnits.iterator();

    while (it.hasNext()) {

      if (index >= 0 && index < listUnits.size()) {
        Unit unit = it.next();
        this.units.add(unit);
      }
      index++;
    }
  }

  public void setName(String name) {
    this.name = name;
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

  public List<Unit> getRangedUnits() {
    List<Unit> rangedUnits = new ArrayList();
    rangedUnits = this.units.stream().filter(rangedUnit -> rangedUnit.getName().equals("Ranged"))
        .collect(Collectors.toList());

    return rangedUnits;
  }

  public List<Unit> getCavalryUnits() {
    List<Unit> cavalryUnits = new ArrayList();
    cavalryUnits = this.units.stream().filter(rangedUnit -> rangedUnit.getName().equals("Cavalry"))
        .collect(Collectors.toList());

    return cavalryUnits;
  }

  public List<Unit> getCommanderUnits() {
    List<Unit> commanderUnits = new ArrayList();
    commanderUnits =
        this.units.stream().filter(commanderUnit -> commanderUnit.getName().equals("Commander"))
            .collect(Collectors.toList());

    return commanderUnits;
  }
}