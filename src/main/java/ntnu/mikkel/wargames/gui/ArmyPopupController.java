package ntnu.mikkel.wargames.gui;


import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ArmyPopupController implements Initializable {

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
  private MFXComboBox unitType = new MFXComboBox();

  //Scenes
  private Scene armySetupScene;

  //Controllers
  private ArmySetupController armySetupController;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle){
    ObservableList<String>
        list = FXCollections.observableArrayList("InfantryUnit", "CommanderUnit", "RangedUnit", "CavalryUnit");
    unitType.setItems(list);
    unitType.setPromptText("Unit");

  }


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
    this.health.clear();
  }
}
