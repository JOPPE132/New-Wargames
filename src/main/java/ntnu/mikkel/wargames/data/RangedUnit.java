package ntnu.mikkel.wargames.data;

public class RangedUnit extends Unit {

  protected RangedUnit(String name, int health, int attack, int armor) {
    super(name, health, attack, armor);
  }

  protected RangedUnit(String name, int health) {
    super(name, health, 8, 15);
  }

  public int getAttackBonus() {
    return 3;
  }

  public int getResistBonus() {
    return 6;
  }
}







