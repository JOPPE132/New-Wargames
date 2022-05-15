package ntnu.mikkel.wargames.gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainSceneController {

  private Scene howToPlayScene;
  private Scene armySetupScene;

  public void setHowToPlayScene(Scene howToPlayScene){
    this.howToPlayScene = howToPlayScene;
  }

  public void setArmySetupScene(Scene armySetupScene){
    this.armySetupScene = armySetupScene;
  }


  public void openHowToPlayScene(ActionEvent actionEvent){
    Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.howToPlayScene);
  }

  private void setScene(Stage primaryStage, Scene newScene){
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }




}
