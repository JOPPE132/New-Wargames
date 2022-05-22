package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test the CavalryUnit class by:
 * <ul>
 *   <li>Test creation of object with valid parameters.</li>
 *   <li>Test creation with invalid <b>name</b>.</li>
 *
 *
 * </ul>
 */
public class CavalryUnitTest {

  @Test
  void testConstructor() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 50, 10, 15);

    assertEquals("Name", cavalryUnit.getName());
    assertEquals(15, cavalryUnit.getArmor());
    assertEquals(10, cavalryUnit.getAttack());
    assertEquals(50, cavalryUnit.getHealth());
  }

  @Test
  void testConstructorAgain(){
    CavalryUnit cavalryUnit = new CavalryUnit("Unit", 50, 10, 20);

    assertEquals("Unit", cavalryUnit.getName());
    assertEquals(50, cavalryUnit.getHealth());
    assertEquals(10, cavalryUnit.getAttack());
    assertEquals(20, cavalryUnit.getArmor());
  }

  @Test
  void testConstructorWithFewerParameters() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 50);

    assertEquals(12, cavalryUnit.getArmor());
    assertTrue(cavalryUnit.isAlive());
    assertEquals("Name", cavalryUnit.getName());
    assertEquals(20, cavalryUnit.getAttack());
  }

  @Test
  void testGetAttackBonus() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 10);

    assertEquals(2, cavalryUnit.getAttackBonus());
  }

  @Test
  void testGetResistBonus() {
    CavalryUnit cavalryUnit = new CavalryUnit("Name", 10);

    assertEquals(1, cavalryUnit.getResistBonus());
  }
}