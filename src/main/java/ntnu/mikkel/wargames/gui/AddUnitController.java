package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AddUnitController implements Initializable {

  private Scene armyScene;
  private ArmySetupController armySetupController;

  public void setArmyScene(Scene armySetupScene) {
    this.armyScene = armySetupScene;
  }

  private void setScene(Stage primaryStage, Scene newScene){
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

  @FXML
  protected void cancelButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyScene);
  }

  @FXML
  protected void saveButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyScene);
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
