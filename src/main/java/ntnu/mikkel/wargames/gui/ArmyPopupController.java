package ntnu.mikkel.wargames.gui;


import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ArmyPopupController {

  //FXML Elements
  @FXML
  private MFXTextField armyName = new MFXTextField();
  @FXML
  private MFXTextField amount = new MFXTextField();
  @FXML
  private MFXTextField health = new MFXTextField();
  @FXML
  private MFXTextField attack = new MFXTextField();
  @FXML
  private MFXTextField armor = new MFXTextField();
  @FXML
  private MFXFilterComboBox unitType = new MFXFilterComboBox();

  //scenes
  private Scene armySetupScene;



  public void setArmyScene(Scene armyScene){
    this.armySetupScene = armyScene;
  }

  @FXML
  protected void cancelButtonPressed(MouseEvent mouseEvent){
    clearTextFields();
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armySetupScene);
  }

  @FXML
  protected void saveButtonPressed(MouseEvent mouseEvent){
    clearTextFields();
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armySetupScene);
  }

  private void setScene(Stage primaryStage, Scene newScene){
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

  private void clearTextFields(){
    this.armyName.clear();
    this.amount.clear();
    this.armor.clear();
    this.attack.clear();
    this.unitType.clear();
    this.health.clear();
  }



}
