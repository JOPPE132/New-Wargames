package ntnu.mikkel.wargames;

/**
 * Superclass represents a Unit in a heritage hierarchy.
 */

public abstract class Unit {

    private String name;
    private int health;
    private int armor;
    private int attack;
    private int testField;

    protected Unit(String name, int health, int armor, int attack){
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.attack = attack;
    }
    abstract int getResistBonus();
    abstract int getAttackBonus();

    public void firstStrike(){
        if(
    }
    
    public void attack(Unit opponent){
        
        if(opponent instanceof RangedUnit){
            opponent.setHealth(10);
        }
        
        if(opponent instanceof CavalryUnit){
            opponent.setHealth(20);
        }
        
        if(opponent instanceof InfantryUnit){
            opponent.setHealth(30);
        }
            
        if(opponent instanceof CommanderUnit){
            opponent.setHealth(5);
        }
        
    }
        
    
    // public void attack(Unit opponent){
        // if(opponent instanceof RangedUnit){
            // opponent.set
        // }
        
        // if(opponent instanceof CavalryUnit){
            
        // }
        
    // }


    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getArmor(){
        return armor;
    }

    public int getAttack(){
        return attack;
    }

    /**
     * Method sets a new health for a unit.
     *
     * @param newHealth the new amount of health of a unit.
     */
    public void setHealth(int newHealth){

        try {


            if (newHealth == n) {
                newHealth //EXCEPTIONHANDLING
            } else {
                this.health = newHealth;
            }
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
