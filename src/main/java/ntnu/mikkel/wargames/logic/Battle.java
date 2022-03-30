package ntnu.mikkel.wargames.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ntnu.mikkel.wargames.data.Unit;

public class Battle {

     private Army armyOne;
     private Army armyTwo;

     public Battle(Army orcs, Army humans) {
          this.armyOne = orcs;
          this.armyTwo = humans;
     }

     private void fillArmyOneWithUnits(){
          armyOne.addAll();
     }

     private void fillArmyTwoWithUnits(){
          List<Unit> allUnits = new ArrayList<>();

          for(i = 0; )

          armyTwo.addAll(allUnits);
     }

     public void simulate(){
          Random random = new Random();

          while (armyOne.hasUnits() && armyTwo.hasUnits()){



               Unit randomArmy1Unit = armyOne.getRandomunit();
               Unit randomArmy2Unit = armyTwo.getRandomunit();

               randomArmy1Unit.attack(randomArmy2Unit);
               randomArmy2Unit.attack(randomArmy1Unit);









          }
     }
}
