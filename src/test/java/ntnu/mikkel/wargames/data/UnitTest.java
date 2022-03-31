package ntnu.mikkel.wargames.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UnitTest {

  @Test
  void testAttackMethod(){
    CavalryUnit cavalryUnit = new CavalryUnit("Mikkel", 10);
    InfantryUnit infantryUnit = new InfantryUnit("Åsmund", 10);

    //assertEquals(15, cavalryUnit.attack(infantryUnit));



  }

}
