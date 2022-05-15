package ntnu.mikkel.wargames.data;

public class DummyUnit extends Unit {

  @Override
  int getResistBonus() {
    return 0;
  }

  @Override
  int getAttackBonus() {
    return 0;
  }


  protected DummyUnit(String name, int health, int armor, int attack){
    super(name,health,armor,attack);
  }

  public DummyUnit(String name, int attack){
    super(name,attack,10,15);
  }


}
