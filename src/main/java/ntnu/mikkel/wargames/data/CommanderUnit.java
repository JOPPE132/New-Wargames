package ntnu.mikkel.wargames.data;

public class CommanderUnit extends CavalryUnit {

  /**
   * Creates an object ov CavalryUnit.
   *
   * @param name   name of the unit.
   * @param health health of the unit.
   * @param attack attack damage of the unit.
   * @param armor  armor value of the unit.
   */
  protected CommanderUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  /**
   * Creates an object ov CavalryUnit.
   *
   * @param name   name of the unit.
   * @param health health of the unit.
   */
  public CommanderUnit(String name, int health) {
    super(name, health, 25, 15);
  }

  /**
   * Adds attack bonus to the unit when it attacks.
   *
   * @return the value of the attack bonus.
   */
  @Override
  public int getAttackBonus() {
    return 2;
  }

  /**
   * Adds defence bonus to the unit when its attacked.
   *
   * @return the value of the resist bonus.
   */
  @Override
  public int getResistBonus() {
    return 1;
  }
}
