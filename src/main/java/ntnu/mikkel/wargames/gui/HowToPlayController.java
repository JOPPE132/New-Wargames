package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Class represents a controller for HowToPlayPage.FXML
 */
public class HowToPlayController implements Initializable {

  private Scene homeScene;
  private MenuController menuController;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  /**
   * Changes scene to HomeScene.
   *
   * @param homeScene the new Scene.
   */
  public void setHomeScene(Scene homeScene) {
    this.homeScene = homeScene;
  }

  /**
   * Changes scene to HomePage.FXML
   *
   * @param mouseEvent onMouseClicked button.
   */
  @FXML
  public void homeButtonPressed(MouseEvent mouseEvent) {
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.homeScene);
  }

  /**
   * Changes Scene on Stage.
   *
   * @param primaryStage the stage you want the scene to change on.
   * @param newScene     the scene you want the stage to change on.
   */
  private void setScene(Stage primaryStage, Scene newScene) {
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

  /**
   * Receieve controller-objects from MainWindow. Including objects made
   * within the controller.
   *
   * @param menuController controllerobject.
   */
  public void recieveControllers(MenuController menuController) {
    this.menuController = menuController;
  }
}