package ntnu.mikkel.wargames;
import java.util.Random;


public class Battle {

     private Army orcs;
     private Army humans;
     
     public Battle(Army orcs, Army humans){

          orcs = new Army("Orcs");
          humans = new Army("Humans");

          CavalryUnit cavalryUnit = new CavalryUnit("Knight", 100);
          CommanderUnit commanderUnit = new CommanderUnit("Mountain King", 200);
          InfantryUnit infantryUnit = new InfantryUnit("Footman", 100);
          RangedUnit rangedUnit = new RangedUnit("Archer", 100);

          for(int i = 0; i < 50; i++){
               orcs.addUnit(cavalryUnit);
          }

          //TODO ADD UNITS TO ARMIES





     }

     public void simulate(){
          Random random = new Random();

          while (orcs.hasUnits() && humans.hasUnits()){

               if(random.nextBoolean()){
                    orcs.getRandomunit();

                    orcs.





                    }
               else{
                    humans.getRandomunit();





               }


          }
     }
}
