module NEW.WARAGAMES {
  requires javafx.controls;
  requires java.desktop;
  requires javafx.fxml;


  exports ntnu.mikkel.wargames.data;
  exports ntnu.mikkel.wargames.logic;

  opens ntnu.mikkel.wargames.gui to javafx.fxml, javafx.graphics;
  opens ntnu.mikkel.wargames;
  opens ntnu.mikkel.wargames.logic;
}