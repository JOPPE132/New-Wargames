package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CommanderUnitTest {
  @Test
  void testConstructor() {
    CommanderUnit commanderUnit = new CommanderUnit("Name", 1, 1, 1);

    assertEquals(1, commanderUnit.getArmor());
    assertTrue(commanderUnit.isDead());
    assertEquals("Name", commanderUnit.getName());
    assertEquals(1, commanderUnit.getAttack());
  }

  @Test
  void testConstructor2() {
    CommanderUnit commanderUnit = new CommanderUnit("Name", 100, 1, 1);

    assertEquals(1, commanderUnit.getArmor());
    assertFalse(commanderUnit.isDead());
    assertEquals("Name", commanderUnit.getName());
    assertEquals(1, commanderUnit.getAttack());
  }

  @Test
  void testGetAttackBonus(){
    CommanderUnit commanderUnit = new CommanderUnit("Name", 10,10,10);
    assertEquals(2,commanderUnit.getAttackBonus());
    }

  @Test
  void testGetResistBonus(){
    CommanderUnit commanderUnit = new CommanderUnit("Name", 10, 10 ,10);
    assertEquals(1, commanderUnit.getResistBonus());
  }
}