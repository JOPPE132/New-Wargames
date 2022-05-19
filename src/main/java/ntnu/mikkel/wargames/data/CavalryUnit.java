package ntnu.mikkel.wargames.data;

public class CavalryUnit extends Unit {

  /**
   * Creates an object ov CavalryUnit.
   *
   * @param name   name of the unit.
   * @param health health of the unit.
   * @param attack attack damage of the unit.
   * @param armor  armor value of the unit.
   */
  public CavalryUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  /**
   * Creates an object of CavalryUnit.
   *
   * @param name   name of the unit.
   * @param health health of the unit.
   */
  public CavalryUnit(String name, int health) {
    super(name, health, 20, 12);
  }

  /**
   * Adds attack bonus to the unit when it attacks.
   *
   * @return the value of the attack bonus.
   */
  public int getAttackBonus() {
    return 2;
  }

  /**
   * Adds defence bonus to the unit when its attacked.
   *
   * @return the value of the resist bonus.
   */
  public int getResistBonus() {
    return 1;
  }
}

