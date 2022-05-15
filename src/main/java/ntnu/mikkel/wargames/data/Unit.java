package ntnu.mikkel.wargames.data;

/**
 * Superclass represents a Unit in a heritage hierarchy.
 */
public abstract class Unit {

  private static final int MAX_HEALTH = 100;
  private static final int MAX_ARMOR = 100;
  private static final int MAX_ATTACK = 100;
  private DamageHandler damageHandler;
  private String name;
  private int health;
  private int armor;
  private int attack;


  /**
   * Constructor creates an object of Unit.
   *
   * @param name   the name of the unit.
   * @param health the health of the unit.
   * @param armor  the armor of the unit.
   * @param attack the attack damage of the unit.
   */
  protected Unit(String name, int health, int armor, int attack) throws IllegalArgumentException {
    if (name == null || name.isBlank() && health >= 0 && health < MAX_HEALTH && //TODO FIKS
        armor >= 0 && armor < MAX_ARMOR && attack >= 0 && attack < MAX_ATTACK) {

      throw new IllegalArgumentException("Something wrong happend. Please try again.");
    }
    this.setName(name);
    this.setHealth(health);
    this.setArmor(armor);
    this.setAttack(attack);
    damageHandler = new DamageHandler();
  }

  abstract int getResistBonus();

  abstract int getAttackBonus();

  /**
   * Represents an attack from a unit to another.
   *
   * @param opponent the opponent you wish to attack.
   */
  public void attack(Unit opponent) {
    if (opponent == null) {
      throw new IllegalArgumentException("Opponent can not be null.");
    }
    if (opponent.isAlive()) {
      damageHandler.reduceHealth(opponent);
    }
  }

  /**
   * Checks if unit is alive.
   *
   * @return true if unit is alive(above 0 health). False otherwise.
   */
  public boolean isAlive() {
    return getHealth() > 0;
  }

  /**
   * Checks if unit is dead.
   *
   * @return true if unit is dead(health 0 or below 0). False otherwise.
   */
  public boolean isDead() {
    return getHealth() <= 0;
  }

  /**
   * Returns the name of a certain unit.
   *
   * @return the name of a certain unit.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the health of a certain unit.
   *
   * @return the health of a certain unit.
   */
  public int getHealth() {
    return health;
  }

  /**
   * Returns the armor of a certain unit.
   *
   * @return the armor of a certain unit.
   */
  public int getArmor() {
    return armor;
  }

  /**
   * Method returns the attack of a certain unit.
   *
   * @return the attack of a certain unit.
   */
  public int getAttack() {
    return attack;
  }

  /**
   * Sets a new health for a unit.
   *
   * @param newHealth sets the new amount of health of a unit.
   */
  public void setHealth(int newHealth) {
    if (newHealth >= 0 && newHealth < MAX_HEALTH) {
      this.health = newHealth;
    }
  }

  public void setName(String name){
    this.name = name;
  }

  public void setArmor(int armor){
    this.armor = armor;
  }

  public void setAttack(int attack){
    this.attack = attack;
  }

  /**
   * Return details of a unit.
   *
   * @return the details of a unit.
   */
  public String toString() {
    return "Unit: " +
        "name: " + name +
        ", health: " + health +
        ", armor: " + armor +
        ", attack: " + attack;
  }
}