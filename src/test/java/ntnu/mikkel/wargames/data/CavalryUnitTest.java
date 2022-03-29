package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CavalryUnitTest {

  @Test
  void testConstructor() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 1, 1, 1);

    assertEquals(1, cavalryUnit.getArmor());
    assertTrue(cavalryUnit.isDead());
    assertEquals("Name", cavalryUnit.getName());
    assertEquals(1, cavalryUnit.getAttack());
  }

  @Test
  void testConstructor2() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 100, 1, 1);

    assertEquals(1, cavalryUnit.getArmor());
    assertFalse(cavalryUnit.isDead());
    assertEquals("Name", cavalryUnit.getName());
    assertEquals(1, cavalryUnit.getAttack());
  }

  @Test
  void testGetAttackBonus() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 1, 1, 1);

    assertEquals(2, cavalryUnit.getAttackBonus());
  }

  @Test
  void testGetResistBonus() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 1, 1, 1);

    assertEquals(1, cavalryUnit.getResistBonus());
  }
}