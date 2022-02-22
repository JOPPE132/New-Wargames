 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {

      private Unit unit;
      private String name;
      private List<Unit> units;

      public Army(String name){
        this.name = name;
        units = new ArrayList<Unit>();
      }
    
      public String getName(){
        return name;
      }
    
      public void addUnit(Unit unit){
        units.add(unit);
      }
    
      public void addAll(){

      }
    
      public void removeUnit(Unit unit){
        units.remove(unit);
      }
    
      /**
       * Checks if there is units in a Army.
       * @return false if list is empty.
       * @return true if list is populated.
       */
      public boolean hasUnits(){
        if(units.isEmpty()){
          return false;
        }
        else{
          return true;
        }
      }
    
      /**
       * Prints all units in a certain army. 
       */
      public void getAllUnits() { // ????
        
          for(Unit unit : units){
              unit.show();
              System.out.println();
          }
      }
      
      /**
       * Må bruke toString.. Returns a string representation of the object.
       */
      // public Unit getRandom(){
          
          // Random random = new Random();
        
          // String randomUnit = unit.toString();
          
          // if(units.isEmpty()){
              // System.out.println("There is nothing to return.");
          // }
          
          // else{
              // for(Unit units : units){
                  
                  // units.randomUnit.
                  
                  
                  
              // }
              
              
              
              
          // }
            
          
      // } 
        
}









