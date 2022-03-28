package ntnu.mikkel.wargames.data;

public class InfantryUnit extends Unit {
    
    protected InfantryUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
    }

    protected InfantryUnit(String name, int health){
        super(name, health, 10, 15);
    }

    public int getAttackBonus(){
        return 2;
    }
    
    public int getResistBonus(){
        return 1;
    }
}
