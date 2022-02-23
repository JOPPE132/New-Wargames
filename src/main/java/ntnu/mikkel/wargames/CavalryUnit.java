package ntnu.mikkel.wargames;

public class CavalryUnit extends Unit {

    public CavalryUnit(String name, int health, int attack, int armor){
        super(name, health, attack, armor);
    }

    public CavalryUnit(String name, int health){
        super(name, health, 20, 12);
    }
    
    public int getAttackBonus(){
        return 2;
    }

    public int getResistBonus(){
        return 1;
    }
}

