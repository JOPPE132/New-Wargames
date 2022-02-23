package ntnu.mikkel.wargames;

public class CommanderUnit extends CavalryUnit{

    public CommanderUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
    }

    public CommanderUnit(String name, int health){
        super(name, health, 25, 15);
    }

    public int getAttackBonus(){
        return 2;
    }
    
    public int getResistBonus(){
        return 1;
    }
}
