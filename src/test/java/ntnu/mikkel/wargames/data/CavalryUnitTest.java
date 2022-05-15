package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    //assertEquals(15, cavalryUnit.getArmor());
    //assertEquals(10, cavalryUnit.getAttack());
    assertEquals(50, cavalryUnit.getHealth());
  }

  @Test
  void testConstructorAgain(){
    CavalryUnit cavalryUnit = new CavalryUnit("", 5000, 5000, 5000);

    //assertEquals("Unit", cavalryUnit.getName());
    //assertEquals(50, cavalryUnit.getHealth());
    //assertEquals(10, cavalryUnit.getAttack());
    //assertEquals(20, cavalryUnit.getArmor());
  }

  @Test
  void testConstructorWithFewerParameters() {
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