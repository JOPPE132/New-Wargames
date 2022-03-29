package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RangedUnitTest {

  @Test
  void testConstructor(){
    RangedUnit rangedUnit =new RangedUnit("Name", 10, 10, 10);
    assertEquals("Name", rangedUnit.getName());
    assertEquals(10, rangedUnit.getHealth());
    assertEquals(10, rangedUnit.getAttack());
    assertEquals(10,rangedUnit.getArmor());
  }

  @Test
  void testConstructor2(){
    RangedUnit rangedUnit = new RangedUnit("Name", 10);
    assertEquals("Name", rangedUnit.getName());
    assertEquals(10, rangedUnit.getHealth());
  }

  @Test
  void testGetResistBonus(){
    RangedUnit rangedUnit = new RangedUnit("Name", 10, 10, 10);
    assertEquals(6, rangedUnit.getResistBonus());
  }

  @Test
  void testGetAttackBonus(){
    RangedUnit rangedUnit = new RangedUnit("Name", 10, 10, 10);
    assertEquals(3, rangedUnit.getAttackBonus());
  }
}
