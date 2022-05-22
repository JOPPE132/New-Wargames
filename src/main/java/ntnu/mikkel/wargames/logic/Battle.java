package ntnu.mikkel.wargames.logic;

import java.util.Random;
import ntnu.mikkel.wargames.data.Unit;

/**
 * Represents a battle between two Armies. The Armies are passed through battles constructor,
 * and assigned as a field. The Armies in the fields are used for Simulate method.
 */
public class Battle {

  private Army armyOne;
  private Army armyTwo;

  /**
   * Creates an object of Battle.
   *
   * @param armyOne the first Army to Battle.
   * @param armyTwo the second Army to Battle.
   */
  public Battle(Army armyOne, Army armyTwo) {
    this.armyOne = armyOne;
    this.armyTwo = armyTwo;
  }

  /**
   * Method randomly chooses a number between 0 and 2.
   *
   * @return returns a random integer between 0 and 2.
   */
  private int firstAttackerNumberGenerator() {
    Random random = new Random();
    int combat;
    combat = random.nextInt(2); //Including 0, exclude 2.
    return combat;
  }

  /**
   * Method simulates a battle between two armies. The units in the armies are chosen randomly from
   * random class. The random chosen unit from Army 1 attacks a randomly chosen unit
   * from Army 2. If an unit dies from an attack, it is then removed from the army.
   */
  public Army simulate(Army armyOne, Army armyTwo) {

    Army winner = null;


    while (this.armyOne.hasUnits() && this.armyTwo.hasUnits()) {

      int combatOrder = firstAttackerNumberGenerator();
      Unit randomArmyOneUnit = armyOne.getRandomunit();
      Unit randomArmyTwoUnit = armyTwo.getRandomunit();

      if (combatOrder == 0) {
        randomArmyOneUnit.attack(randomArmyTwoUnit);
        if (randomArmyTwoUnit.isAlive()) {
          randomArmyTwoUnit.attack(randomArmyOneUnit);
        }
        if (randomArmyTwoUnit.isDead()) {
          armyTwo.removeUnit(randomArmyTwoUnit);
        }
      }

      if (combatOrder == 1) {
        randomArmyTwoUnit.attack(randomArmyOneUnit);
        if (randomArmyOneUnit.isAlive()) {
          randomArmyOneUnit.attack(randomArmyTwoUnit);
        }
        if (randomArmyOneUnit.isDead()) {
          armyOne.removeUnit(randomArmyOneUnit);
        }
      }
      }
      if (armyOne.hasUnits()) {
        winner = armyOne;
      }
      if (armyTwo.hasUnits()) {
        winner = armyTwo;
      }
      return winner;
    }
  }

