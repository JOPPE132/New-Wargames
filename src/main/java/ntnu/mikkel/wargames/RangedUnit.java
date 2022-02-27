package ntnu.mikkel.wargames;

public class RangedUnit extends Unit {

    private int attackedCounter;
    private boolean attacked;

    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    public RangedUnit(String name, int health) {
        super(name, health, 8, 15);
    }

    public int getAttackBonus() {
        return 3;
    }

    public int getResistBonus() {

        if(attacked){
            attackedCounter++;
            return 6;
        }

        //TODO Fikse resistdamage (6,4,2)
        return 6;

        //if attacked
        //attackedCounter++;
    }
}







