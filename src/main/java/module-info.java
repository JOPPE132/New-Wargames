/**
 * All packages used in Wargames.
 */
module ntnu.mikkel.wargames {

  requires javafx.controls;
  requires javafx.graphics;
  requires javafx.fxml;
  requires MaterialFX;

  opens ntnu.mikkel.wargames.data to javafx.fxml;
  opens ntnu.mikkel.wargames.gui to javafx.fxml;

  exports ntnu.mikkel.wargames;
    opens ntnu.mikkel.wargames to javafx.fxml;
  exports ntnu.mikkel.wargames.data;
  exports ntnu.mikkel.wargames.gui;
  exports ntnu.mikkel.wargames.logic;





}