package ntnu.mikkel.wargames.data;

/**
 * Superclass represents a Unit in a heritage hierarchy.
 */
public abstract class Unit {

  private static final int MAX_HEALTH = 100;
  private static final int MAX_ARMOR = 100;
  private static final int MAX_ATTACK = 100;
  private final String name;
  private int health;
  private final int armor;
  private final int attack;


  /**
   * Constructor creates an object of Unit.
   *
   * @param name   the name of the unit.
   * @param health the health of the unit.
   * @param armor  the armor of the unit.
   * @param attack the attack damage of the unit.
   */
//    protected Unit(String name, int health, int armor, int attack) throws IllegalArgumentException {
//        if (name != null && name.equals("")) {
//            name = "Unit";
//        }
//        if (health < 0 || health > MAX_HEALTH) {
//            health = 50;
//        }
//        if (armor < 0 || armor > MAX_ARMOR) {
//            armor = 20;
//        }
//        if (attack < 0 || attack > MAX_ATTACK) {
//            attack = 10;
//        } else {
//            throw new IllegalArgumentException("Something went wrong. Please try again.");
//        }
//        this.name = name;
//        this.health = health;
//        this.armor = armor;
//        this.attack = attack;
//    }
  protected Unit(String name, int health, int armor, int attack) throws IllegalArgumentException {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name can not be null or blank. Please try again.");
    } else {
      this.name = name;
      this.health = health;
      this.armor = armor;
      this.attack = attack;
    }
  }

  abstract int getResistBonus();

  abstract int getAttackBonus();

  /**
   * Method represents an attack from a unit to another.
   *
   * @param opponent the opponent you wish to attack.
   */
  public void attack(Unit opponent) {
    if (opponent.isAlive()) {
      opponent.reduceHealth();
    }
  }

  /**
   * Method checks if unit is alive.
   *
   * @return true if unit is alive(above 0 health). False otherwise.
   */
  public boolean isAlive() {
    return getHealth() >= 0;
  }

  /**
   * Method checks if unit is dead.
   *
   * @return true if health is dead(below 0 health). False otherwise.
   */
  public boolean isDead() {
    return getHealth() <= 1;
  }

  /**
   * Method reduces health of opponent.
   */
  private void reduceHealth() {
    int newHealth = getHealth() - (attack + getAttackBonus()) + (getArmor() + getResistBonus());
    if (health > newHealth) {
      health = newHealth;
    }
  }

  /**
   * Method returns the name of a certain unit.
   *
   * @return the name of a certain unit.
   */
  public String getName() {
    return name;
  }

  /**
   * Method returns the health of a certain unit.
   *
   * @return the health of a certain unit.
   */
  public int getHealth() {
    return health;
  }

  /**
   * Method returns the armor of a certain unit.
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
   * Method sets a new health for a unit.
   *
   * @param newHealth sets the new amount of health of a unit.
   */
  public void setHealth(int newHealth) {
    if (newHealth > 0 && newHealth < MAX_HEALTH) {
      this.health = newHealth;
    }
  }

  /**
   * Method prints details of a unit.
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