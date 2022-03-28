package ntnu.mikkel.wargames.data;

public class CommanderUnit extends CavalryUnit{

    protected CommanderUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
    }

    protected CommanderUnit(String name, int health){
        super(name, health, 25, 15);
    }

    public int getAttackBonus(){
        return 2;
    }
    
    public int getResistBonus() {
        return 1;
    }
}
