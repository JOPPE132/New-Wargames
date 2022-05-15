package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattleController implements Initializable {

  private Scene menuScene;
  private Scene armyScene;



  public void sethomeScene(Scene homeScene){
    this.menuScene = homeScene;
  }

  public void setArmyScene(Scene armyScene){
    this.armyScene = armyScene;
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
