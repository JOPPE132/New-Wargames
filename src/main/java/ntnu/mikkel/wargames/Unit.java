package ntnu.mikkel.wargames;

/**
 * Superclass represents a Unit in a heritage hierarchy.
 */



public abstract class Unit {

    private static final int MAX_HEALTH = 100;
    private String name;
    private int health;
    private int armor;
    private int attack;

    protected Unit(String name, int health, int armor, int attack){

        if(name == null && name == ""){
            name = "Unit";
        }

        if(health <= 0 || MAX_HEALTH){
            health = 50;
        }


        this.name = name;
        this.health = health;
        this.armor = armor;
        this.attack = attack;
    }

    abstract int getResistBonus();
    abstract int getAttackBonus();

    /**
     * Method represents an attack from a unit to another.
     *
     * @param opponent the opponent you wish to attack.
     */
    public void attack(Unit opponent){
        if(opponent.isAlive()){
            opponent.reduceHealth(getAttack() + getAttackBonus());
        }
    }

    /**
     * Method checks if unit is alive.
     *
     * @return true if health is above or equal to 1. False if other.
     */
    public boolean isAlive(){
        return getHealth() <= 1;
    }

    /**
     * Method reduces health of opponent.
     *
     * @param damage the damage the unit does.
     */
    public void reduceHealth(int damage){
        int newHealth = getHealth() - damage + (getArmor() + getResistBonus()); //Attack+Attackbonus + getARmor + getReistbonus må være positiv
        if(health > newHealth){
            health = newHealth;
        }
    }

    /**
     * Method returns the name of a certain unit.
     *
     * @return the name of a certain unit.
     */
    public String getName(){
        return name;
    }

    /**
     * Method returns the health of a certain unit.
     *
     * @return the health of a certain unit.
     */
    public int getHealth(){
        return health;
    }

    /**
     * Method returns the armor of a certain unit.
     *
     * @return the armor of a certain unit.
     */
    public int getArmor(){
        return armor;
    }

    /**
     * Method returns the attack of a certain unit.
     *
     * @return the attack of a certain unit.
     */
    public int getAttack(){
        return attack;
    }

    /**
     * Method sets a new health for a unit.
     *
     * @param newHealth sets the new amount of health of a unit.
     */
    public void setHealth(int newHealth){
            if (newHealth > 0 && newHealth < 100) {
                this.health = newHealth;
            }
        }

    public String toString() {
        return "Unit{" +
        "name='" + name + '\'' +
        ", health=" + health +
        ", armor=" + armor +
        ", attack=" + attack +
        '}';
    }

    /**
     * Prints details of a unit.
     */
    public void show(){
        System.out.println("Name of artillery: " + name);
        System.out.println("Health: " + health);
    }
}
