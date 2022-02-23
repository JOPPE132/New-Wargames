package ntnu.mikkel.wargames;

public class RangedUnit extends Unit {

    private int resistBonus;

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


    }
}







