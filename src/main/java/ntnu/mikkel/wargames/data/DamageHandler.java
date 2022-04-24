package ntnu.mikkel.wargames.data;

import java.util.Random;

public class DamageHandler {

  private Random random;

  public DamageHandler(){
    random = new Random();
  }

  private int getRandomNumber(){
    int randomNumber = random.nextInt(20);
    return randomNumber;
  }

  public void reduceHealth(Unit unit) {
    int randomNumber = getRandomNumber();
    try {
      if(0 <= randomNumber && randomNumber <= 10){ //Normal damage
        int newHealth = unit.getHealth() - ((unit.getAttack() + unit.getAttackBonus()) + (unit.getArmor() + unit.getResistBonus()));
        if(unit.getHealth() > newHealth){
          unit.setHealth(newHealth);
        }
      }

      if(11 <= randomNumber && randomNumber <= 12){ //+1 damage
        int newHealth = unit.getHealth() - ((unit.getAttack() + unit.getAttackBonus() + 1) + (unit.getArmor() + unit.getResistBonus()));
        if(unit.getHealth() > newHealth){
          unit.setHealth(newHealth);
        }
      }

      if(13 <= randomNumber && randomNumber <= 14){ //+2 damage
        int newHealth = unit.getHealth() - ((unit.getAttack() + unit.getHealth() + 2) + (unit.getHealth() + unit.getResistBonus()));
        if(unit.getHealth() > newHealth){
          unit.setHealth(newHealth);
        }
      }

      if(randomNumber == 15){ //+3 damage
        int newHealth = unit.getHealth() - ((unit.getAttack() + unit.getAttack() + 3) + (unit.getArmor() + unit.getResistBonus()));
        if(unit.getHealth() > newHealth){
          unit.setHealth(newHealth);
        }
      }
    } catch (Exception e) {
      System.out.println("New health can not increase.");
    }
  }
}
