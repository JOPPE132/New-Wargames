package ntnu.mikkel.wargames.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

  @Test
  void testConstructor(){
    Unit unit = new Unit("Unit", 50, 50, 50);

    Assertions.assertEquals(50, unit.getHealth());
    Assertions.assertEquals("Unit", unit.getName());
    Assertions.assertEquals(50, unit.getAttack());
    Assertions.assertEquals(50, unit.getArmor());
  }

  @Test
  void testisAliveMethod(){
    Unit unit = new Unit("Unit", 50, 50, 50);
    Assertions.assertTrue(unit.isAlive());
  }

  @Test
  void testIsDeadMethod() {
    Unit unit = new Unit("Unit", 50, 50, 50);
    Assertions.assertFalse(unit.isDead());

  }

  @Test
  void testAttackMethod(){
    Unit unit = new Unit("Unit", 50, 10, 10);
    Unit unit2 = new Unit("Unit2", 50, 10, 10);

    unit.attack(unit);
    //IF WE ROLL 0-10 UPON ATTACK
    Assertions.assertEquals(35, unit2.getHealth());
  }


}
