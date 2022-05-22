package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import ntnu.mikkel.wargames.logic.Army;
import org.junit.jupiter.api.Test;

public class ArmyTest {

  private Army army;
  private Unit unit = new Unit("Unit", 50, 50, 50);
  private Unit unit2 = new Unit("Unit2", 50, 50, 50);
  private Unit unit3 = null;

  @Test
  void testAddUnitMethod(){ //Positive
    this.army = new Army("Army");
    army.addUnit(unit);
    army.addUnit(unit2);
    assertEquals(2,army.getSize());
  }

  @Test
  void testAddUnitMethodWithNull(){ //Negative
    this.army = new Army("Army");
    army.addUnit(unit);
    army.addUnit(unit2);
    assertThrows(IllegalArgumentException.class, () -> army.addUnit(unit3)); //Kaster
  }

  @Test
  void testRemoveUnit(){ //Positive
    this.army = new Army("Army");
    army.addUnit(unit);
    army.removeUnit(unit);
    assertEquals(0,army.getSize());
  }

  @Test
  void testHasUnits(){ //Positive
    this.army = new Army("Army");
    army.addUnit(unit);
    assertTrue(army.hasUnits());
  }

  @Test
  void testAddAllMethod(){ //Positive
    this.army = new Army("Army");

    ArrayList<Unit> units = new ArrayList<>();
    Unit unit = new CavalryUnit("Cavalry", 50, 50, 50);
    Unit unit2 = new InfantryUnit("Infantry", 50, 50, 50);
    units.add(unit);
    units.add(unit2);

    army.addAll(units);
    assertEquals(2, army.getSize());
  }






}
