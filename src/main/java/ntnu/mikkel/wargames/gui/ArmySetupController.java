package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

public class ArmySetupController implements Initializable {

  private Scene homeScene;
  private Scene battleScene;


  public void setArmySetupScene(Scene armySetupScene){
    this.homeScene= armySetupScene;
  }

  public void setBattleScene(Scene battleScene){
    this.battleScene = battleScene;
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
