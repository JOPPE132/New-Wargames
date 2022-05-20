package ntnu.mikkel.wargames.data;

import java.util.Random;

/**
 * Class represents any type of damage dealing.
 */
public class DamageHandler {

  private final Random random;

  /**
   * Creates an object of Damagehandler.
   */
  public DamageHandler() {
    random = new Random();
  }

  /**
   * Returns a random number between 0(inclusive) and 19. 20 is exclusive.
   *
   * @return a random number between 1 and 19.
   */
  private int getRandomNumber() {
    int randomNumber = random.nextInt(16);
    return randomNumber;
  }

  /**
   * Algorithm for damage dealing. Before an attack the dice is always rolled for a chance for critical strike.  Inclusive 0, exclusive 16
   * If randomNumber() rolls 0 or 10, damage is normal.
   * If randomNumber() rolls 11 or 12, damage is increased by 1.
   * If randomNumber() rolls 13 or 14, damage is increased by 2.
   * If randomNumber() rolls 15, damage is increased by 3.
   *
   *
   * @param unit the Unit you wish to attack.
   */
  public void reduceHealth(Unit unit) {
    int randomNumber = getRandomNumber();

    if (0 <= randomNumber && randomNumber <= 10) { //Normal damage
      int newHealth = unit.getHealth() -
          ((unit.getAttack() + unit.getAttackBonus()) + (unit.getArmor() + unit.getResistBonus()));
      if (unit.getHealth() > newHealth) {
        if (newHealth <= 0) {
          unit.setHealthFromDamageDealer(0);
        } else {
          unit.setHealth(newHealth);
        }
      }
    }

    if (11 <= randomNumber && randomNumber <= 12) { //+1 Damage
      int newHealth = unit.getHealth() -
          ((unit.getAttack() + unit.getAttackBonus()) + (unit.getArmor() + unit.getResistBonus()));
      if (unit.getHealth() > newHealth) {
        if (newHealth <= 0) {
          unit.setHealthFromDamageDealer(0);
        } else {
          unit.setHealth(newHealth);
        }
      }
    }

    if (13 <= randomNumber && randomNumber <= 14) { //+2 Damage
      int newHealth = unit.getHealth() -
          ((unit.getAttack() + unit.getAttackBonus()) + (unit.getArmor() + unit.getResistBonus()));
      if (unit.getHealth() > newHealth) {
        if (newHealth <= 0) {
          unit.setHealthFromDamageDealer(0);
        } else {
          unit.setHealth(newHealth);
        }
      }
    }

    if (randomNumber == 15) { //+3 Damage
      int newHealth = unit.getHealth() -
          ((unit.getAttack() + unit.getAttackBonus()) + (unit.getArmor() + unit.getResistBonus()));
      if (unit.getHealth() > newHealth) {
        if (newHealth <= 0) {
          unit.setHealthFromDamageDealer(0);
        } else {
          unit.setHealth(newHealth);
        }
      }
    }
  }
}