package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HowToPlayController implements Initializable {

  private Scene homeScene;

  public void setHomeScene(Scene homeScene){
    this.homeScene = homeScene;
  }

  @FXML
  public void homeButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.homeScene);
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
