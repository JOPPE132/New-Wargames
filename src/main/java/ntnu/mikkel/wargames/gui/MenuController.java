package ntnu.mikkel.wargames.gui;

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

public class MenuController implements Initializable {

  //Scenes
  private Scene armySetupScene;
  private Scene howToPlayScene;

  //Controllers
  private HowToPlayController howToPlayController;
  private ArmySetupController armySetupController;

  public void setScene(Stage primaryStage, Scene newScene) {
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

  public void setHowToPlayScene(Scene howToPlayScene) {
    this.howToPlayScene = howToPlayScene;
  }

  public void setArmySetupScene(Scene armySetupScene){
    this.armySetupScene = armySetupScene;
  }

  @FXML
  protected void howToPlayClick(MouseEvent mouseEvent){
    Stage primaryStage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.howToPlayScene);
  }

  @FXML
  protected void PlayClick(MouseEvent mouseEvent){
    Stage primaryStage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armySetupScene);
  }







  @FXML
  public void ExitButtonPressed(MouseEvent event) {
    System.out.println("dwjdj");
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Exit");
    alert.setHeaderText("You are about to exit Wargames.");
    alert.setContentText("Are you sure you want to exit?");
    if (alert.showAndWait().get() == ButtonType.OK) {
      System.exit(0);
    }
  }

  public void recieveControllers(ArmySetupController armySetupController, HowToPlayController howToPlayController){
    this.armySetupController = armySetupController;
    this.howToPlayController = howToPlayController;
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }
}