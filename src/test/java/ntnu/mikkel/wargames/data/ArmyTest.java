package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ntnu.mikkel.wargames.logic.Army;
import org.junit.jupiter.api.Test;

public class ArmyTest {

  private Army army;
  private Unit unit = new Unit("Unit", 50, 50, 50);
  private Unit unit2 = new Unit("Unit2", 50, 50, 50);
  private Unit unit3 = null;

  @Test
  void testAddUnitMethod(){
    this.army = new Army("Army");
    army.addUnit(unit);
    army.addUnit(unit2);
    assertEquals(2,army.getSize());
  }

  @Test
  void testAddUnitMethodWithNull(){ //Negativ
    this.army = new Army("Army");
    army.addUnit(unit);
    army.addUnit(unit2);
    army.addUnit(unit3); //NULL-UNIT
    assertTrue(unit.getName().equals("Joppe"));
  }

  @Test
  void testRemoveUnit(){
    army.addUnit(unit);
    army.removeUnit(unit);
    assertEquals(0,army.getSize());
  }


  @Test
  void testHasUnits(){
    army.addUnit(unit);
    assertTrue(army.hasUnits());


  }






}
