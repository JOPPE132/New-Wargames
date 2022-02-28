
package ntnu.mikkel.wargames;

public class Battle {

     private Unit unit;
     private Army army;
     private Army orcs;
     private Army humans;
     
     public Battle(Army orcs, Army humans){

          orcs = new Army("Nadagogs");
          humans = new Army("Footmen");
          army.fillArmy();

     }

     public void simulate(){

          while(army.hasUnits()){

               unit.attack();


               }
          }
     }
