package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController implements Initializable {

  //Scenes
  private Scene armySetupScene;
  private Scene newHowToPlayScene;

  //Controllers
  private HowToPlayController howToPlayController;
  private ArmySetupController armySetupController;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  /**
   * Changes Scene on Stage.
   *
   * @param primaryStage the stage you want the scene to change on.
   * @param newScene     the scene you want the stage to change on.
   */
  public void setScene(Stage primaryStage, Scene newScene) {
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

  /**
   * Changes scene to HowToPlayScene.
   *
   * @param howToPlayScene the new Scene.
   */
  public void setHowToPlayScene(Scene howToPlayScene) {
    this.newHowToPlayScene = howToPlayScene;
  }

  /**
   * Changes scene to ArmyScene.
   *
   * @param armyScene the new Scene.
   */
  public void setArmySetupScene(Scene armyScene) {
    this.armySetupScene = armyScene;
  }

  @FXML
  protected void howToPlayClick(MouseEvent mouseEvent) {
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.newHowToPlayScene);
  }

  /**
   * Changes the Scene back to Army scene.
   *
   * @param mouseEvent on mousedClicked button.
   */
  @FXML
  protected void PlayClick(MouseEvent mouseEvent) {
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armySetupScene);
  }

  /**
   * Exits application with confirmation alert.
   *
   * @param event
   */
  @FXML
  public void ExitButtonPressed(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Exit");
    alert.setHeaderText("You are about to exit Wargames.");
    alert.setContentText("Are you sure you want to exit?");
    if (alert.showAndWait().get() == ButtonType.OK) {
      System.exit(0);
    }
  }

  /**
   * Receieve controller-objects from MainWindow. Including objects made
   * within the controller.
   *
   * @param armySetupController controllerobject.
   */
  public void recieveControllers(HowToPlayController howToPlayController,
                                 ArmySetupController armySetupController) {
    this.armySetupController = armySetupController;
    this.howToPlayController = howToPlayController;
  }

}