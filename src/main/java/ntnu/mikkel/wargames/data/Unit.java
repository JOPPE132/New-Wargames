package ntnu.mikkel.wargames.data;

/**
 * Superclass represents a Unit in a heritage hierarchy.
 */
public class Unit {

  private static final int MAX_HEALTH = 100;
  private static final int MAX_ARMOR = 100;
  private static final int MAX_ATTACK = 100;
  private final DamageHandler damageHandler;
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
  protected Unit(String name, int health, int attack, int armor) throws IllegalArgumentException {
    this.setName(name);
    this.setHealth(health);
    this.setArmor(armor);
    this.setAttack(attack);
    this.damageHandler = new DamageHandler();
  }

  /**
   * Represents an attack from a unit to another.
   *
   * @param opponent the opponent you wish to attack.
   */
  public void attack(Unit opponent) throws IllegalArgumentException {
    if (opponent == null) {
      throw new IllegalArgumentException("Opponent can not be null.");
    } else {
      this.damageHandler.reduceHealth(opponent);
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
   * @throws IllegalArgumentException invalid value.
   */
  public void setHealth(int newHealth) throws IllegalArgumentException {
    if (newHealth <= 0 || newHealth >= MAX_HEALTH) { //MAX_HEALTH = 100;
      throw new IllegalArgumentException("Illegal value.");
    } else {
      this.health = newHealth;
    }
  }

  /**
   * Sets a new name of Unit.
   *
   * @param newName the new Name of the Unit.
   * @throws IllegalArgumentException invalid value.
   */
  public void setName(String newName) throws IllegalArgumentException {
    if (newName.isBlank() || newName == null) { //Name can not be blank or null.
      throw new IllegalArgumentException("Illegal value.");
    } else {
      this.name = newName;
    }
  }

  /**
   * Sets a new amount of Armor of Unit.
   *
   * @param newArmor the new amount of Armor of Unit.
   * @throws IllegalArgumentException invalid value.
   */
  public void setArmor(int newArmor) throws IllegalArgumentException {
    if (newArmor <= 0 || newArmor >= MAX_ARMOR) { //MAX_ARMOR = 100
      throw new IllegalArgumentException("Illegal value.");
    } else {
      this.armor = newArmor;
    }
  }

  /**
   * Sets a new amount of Attack of Unit.
   *
   * @param newAttack the new amount of attack of Unit.
   * @throws IllegalArgumentException invalud value.
   */
  public void setAttack(int newAttack) throws IllegalArgumentException {
    if (newAttack <= 0 || newAttack >= MAX_ATTACK) { //MAX_ATTACK = 100
      throw new IllegalArgumentException("Illegal value.");
    } else {
      this.attack = newAttack;
    }
  }

  /**
   * Sets new health in damagedealer with no exception.
   *
   * @param newHealth new health of Unit.
   */
  public void setHealthFromDamageDealer(int newHealth) {
    this.health = newHealth;
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

  /**
   * Adds attack bonus to the unit when its attacking.
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
    return 2;
  }
}