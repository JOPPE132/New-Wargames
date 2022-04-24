package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InfantryUnitTest {

  @Test
  void testConstructor(){
    InfantryUnit infantryUnit = new InfantryUnit("Name", 10, 10, 10);

    assertEquals(10, infantryUnit.getArmor());
    assertEquals(10, infantryUnit.getAttack());
    assertEquals(10, infantryUnit.getHealth());
    //assertTrue(infantryUnit.isDead());
  }

  @Test
  void testConstructor2(){
    InfantryUnit infantryUnit = new InfantryUnit("Name", 10);

    assertEquals(10, infantryUnit.getHealth());
    assertEquals("Name", infantryUnit.getName());
  }

  @Test
  void testGetAttackBonus(){
    InfantryUnit infantryUnit = new InfantryUnit("Name", 10, 10, 10);
    //assertEquals(2,infantryUnit.getAttackBonus());
  }

  @Test
  void testGetResistBonus(){
    InfantryUnit infantryUnit = new InfantryUnit("Name", 10, 10, 10);
    assertEquals(1, infantryUnit.getResistBonus());
  }
}
