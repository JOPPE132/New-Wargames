package ntnu.mikkel.wargames.logic;

import java.util.Random;
import ntnu.mikkel.wargames.data.CavalryUnit;
import ntnu.mikkel.wargames.data.CommanderUnit;
import ntnu.mikkel.wargames.data.Unit;

public class Battle {

     private static final int ARMY_ONE_WINNER = 1;
     private static final int ARMY_TWO_WINNER = 2;
     private final Army armyOne;
     private final Army armyTwo;

     public Battle() {
          this.armyOne = new Army("Orcs");
          this.armyTwo = new Army("Humans");
          this.fillOrcArmyWithUnits();
          this.fillHumanArmyWithUnits();
     }

     private void fillOrcArmyWithUnits(){
          for(int i = 0; i < 50; i++){
               CavalryUnit cavalryUnit = new CavalryUnit("Cavalry", 100);
               armyOne.addUnit(cavalryUnit);

               CommanderUnit commanderUnit = new CommanderUnit("Commander", 100);
               armyOne.addUnit(commanderUnit);
          }
     }

     private void fillHumanArmyWithUnits(){
          for(int i = 0; i < 20; i++){
               CavalryUnit cavalryUnit = new CavalryUnit("Cavalry", 10);
               armyTwo.addUnit(cavalryUnit);

               CommanderUnit commanderUnit = new CommanderUnit("Commander", 10);
               armyTwo.addUnit(commanderUnit);
          }
     }

     private int randomCombatGenerator(){
          Random random = new Random();
          int combat;
          combat = random.nextInt(2);
          return combat;
     }

     /**
      * Method simulates a battle between two armies. The units in the armies are chosen randomly from
      * random class. The random chosen unit from Army 1 attacks a randomly chosen unit
      * from Army 2. If an unit dies from an attack, it is then removed from the army.
      */
     public void simulate() {
          Army winner = null;
          boolean battling = true;

          while (battling) {

               Unit randomOrcUnit = armyOne.getRandomunit();
               Unit randomHumanUnit = armyTwo.getRandomunit();

               int combatOrder = randomCombatGenerator();

               if (combatOrder == 0) {
                    randomOrcUnit.attack(randomHumanUnit);
                    if (randomHumanUnit.isDead()) {
                         armyTwo.removeUnit(randomHumanUnit);
                    }
               }

               if (combatOrder == 1) {
                    randomHumanUnit.attack(randomOrcUnit);
                    if (randomOrcUnit.isDead()) {
                         armyOne.removeUnit(randomOrcUnit);
                    }
               }

               int scenario = 0;

               if (armyOne.hasUnits()) {
                    scenario = ARMY_ONE_WINNER; //1, Orcs
               }

               if (armyTwo.hasUnits()) {
                    scenario = ARMY_TWO_WINNER; //2, Humans
               }

               switch (scenario) {
                    case ARMY_ONE_WINNER -> {
                         winner = armyOne;
                         System.out.println("Winner is Orcs!");
                         battling = false;
                    }

                    case ARMY_TWO_WINNER -> {
                         winner = armyTwo;
                         System.out.println("Winner is humans!");
                         battling = false;
                    }
               }
          }
     }

     public static void main(String[] args) {
          Battle battle = new Battle();
          battle.simulate();
     }
}
