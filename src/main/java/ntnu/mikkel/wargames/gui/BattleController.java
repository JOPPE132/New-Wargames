package ntnu.mikkel.wargames.gui;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ntnu.mikkel.wargames.logic.Army;
import ntnu.mikkel.wargames.logic.Battle;

public class BattleController implements Initializable {

  //FXML ELEMENTS
  @FXML
  private Label winnerLabel;

  private Scene armyScene;
  private ArmySetupController armySetupController;
  private Battle battle;
  private Army armyOne;
  private Army armyTwo;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    armySetupController = new ArmySetupController();
    armyOne = armySetupController.getArmy();
    armyTwo = armySetupController.getArmy2();
      this.battle = new Battle(armyOne, armyTwo);

  }


  public void simulateButtonPressed(MouseEvent mouseEvent){
    Army winner = battle.simulate(armyOne, armyTwo);
    winnerLabel.setText(winner.toString());
  }



  public void setArmyScene(Scene armyScene) {
    this.armyScene = armyScene;
  }

  /**
   * Changes the Scene back to ArmyScene.
   *
   * @param mouseEvent
   */
  @FXML
  protected void backButtonPressed(MouseEvent mouseEvent) {
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyScene);
  }

  public void resetButtonPressed(ActionEvent actionEvent) {
  }

  @FXML
  public void ExitButtonPressed(MouseEvent mouseEvent) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Exit");
    alert.setHeaderText("You are about to exit Wargames.");
    alert.setContentText("Are you sure you want to exit?");
    if (alert.showAndWait().get() == ButtonType.OK) {
      System.exit(0);
    }
  }

  private void setScene(Stage primaryStage, Scene newScene) {
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }
}
