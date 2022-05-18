package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ArmySetupController implements Initializable {

  private Scene homeScene;
  private Scene battleScene;
  private Scene armyPopup;


  public void setMenuScene(Scene menuScene){
    this.homeScene= menuScene;
  }

  public void setBattleScene(Scene battleScene){
    this.battleScene = battleScene;
  }

  public void setEditArmyScene(Scene armyPopup){
    this.armyPopup = armyPopup;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  @FXML
  protected void battleButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.battleScene);
  }

  @FXML
  protected void editArmyButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyPopup);
  }

  @FXML
  protected void homeButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.homeScene);
  }

  private void setScene(Stage primaryStage, Scene newScene){
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

}
