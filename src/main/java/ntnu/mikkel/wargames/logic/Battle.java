package ntnu.mikkel.wargames.logic;

import java.io.IOException;
import java.util.Random;
import ntnu.mikkel.wargames.data.CavalryUnit;
import ntnu.mikkel.wargames.data.CommanderUnit;
import ntnu.mikkel.wargames.data.InfantryUnit;
import ntnu.mikkel.wargames.data.Unit;

public class Battle {

  private static final int ARMY_ONE_WINNER = 1;
  private static final int ARMY_TWO_WINNER = 2;
  private final Army orcArmy;
  private final Army humanArmy;

  public Battle(Army orcArmy, Army humanArmy) {
    this.orcArmy = orcArmy;
    this.humanArmy = humanArmy;
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
  private Army simulate() {
    Army winner = null;
    boolean battling = true;

    while (battling) {

      Unit randomOrcUnit = orcArmy.getRandomunit();
      Unit randomHumanUnit = humanArmy.getRandomunit();

      int combatOrder = firstAttackerNumberGenerator();

      while(orcArmy.hasUnits() && humanArmy.hasUnits()){

        if (combatOrder == 0) {
          randomOrcUnit.attack(randomHumanUnit);
          if (randomHumanUnit.isDead()) {
            humanArmy.removeUnit(randomHumanUnit);
          }
        }

        if (combatOrder == 1) {
          randomHumanUnit.attack(randomOrcUnit);
          if (randomOrcUnit.isDead()) {
            orcArmy.removeUnit(randomOrcUnit);
          }
        }
      }

      int scenario = 0;

      if (orcArmy.hasUnits()) {
        scenario = ARMY_ONE_WINNER; //1, Orcs
      }

      if (humanArmy.hasUnits()) {
        scenario = ARMY_TWO_WINNER; //2, Humans
      }

      switch (scenario) {
        case ARMY_ONE_WINNER:
          winner = orcArmy;
          System.out.println("Winner is Orcs!");
          battling = false;
          break;

        case ARMY_TWO_WINNER:
          winner = humanArmy;
          System.out.println("Winner is humans!");
          battling = false;
          break;
      }
    }
    return winner;
  }

    /**
     * Start method of application.
     *
     * @param args arguments.
     */
    public static void main(String[] args) throws IOException {
      Battle battle = new Battle(new Army("Jon"), new Army("Per"));
      battle.simulate();

    }

  }
