package ntnu.mikkel.wargames.logic;
import java.util.Random;
import ntnu.mikkel.wargames.logic.Army;


public class Battle {

     private Army orcs;
     private Army humans;

     public Battle(Army orcs, Army humans){
          orcs = new Army(null);
          humans = new Army(null);
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
