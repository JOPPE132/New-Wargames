package ntnu.mikkel.wargames.gui;

import java.awt.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.Action;

public class MainSceneController {

  private Scene helpScene;
  private Scene playScene;

  public void setHelpScene(Scene helpController){
    this.helpScene = helpController;
  }

  public void setPlayScene(Scene playController){
    this.playScene = playController;
  }

  public void openHelpScene(ActionEvent actionEvent){
    Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage,this.helpScene);
  }

  public void openPlayScene(ActionEvent actionEvent){
    Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage,this.playScene);
  }

  private void setScene(Stage primaryStage, Scene newScene){
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }
}
