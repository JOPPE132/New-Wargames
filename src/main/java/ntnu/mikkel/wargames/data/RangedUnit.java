package ntnu.mikkel.wargames.data;

public class RangedUnit extends Unit {

  /**
   * Creates an object ov CavalryUnit.
   *
   * @param name   name of the unit.
   * @param health health of the unit.
   * @param attack attack damage of the unit.
   * @param armor  armor value of the unit.
   */
  protected RangedUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  /**
   * Creates an object ov CavalryUnit.
   *
   * @param name   name of the unit.
   * @param health health of the unit.
   */
  public RangedUnit(String name, int health) {
    super(name, health, 8, 15);
  }

  /**
   * Adds attack bonus to the unit when it attacks.
   *
   * @return the value of the attack bonus.
   */
  public int getAttackBonus() {
    return 3;
  }

  /**
   * Adds defence bonus to the unit when its attacked.
   *
   * @return the value of the resist bonus.
   */
  public int getResistBonus() {
    return 6;
  }
}







