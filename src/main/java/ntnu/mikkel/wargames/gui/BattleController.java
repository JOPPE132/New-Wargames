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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BattleController implements Initializable {

  private Scene armyScene;

  public void setArmyScene(Scene armyScene){
    this.armyScene = armyScene;
  }

  @FXML
  protected void backButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyScene);
  }

  public void resetButtonPressed(ActionEvent actionEvent){
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

  private void setScene(Stage primaryStage, Scene newScene){
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
