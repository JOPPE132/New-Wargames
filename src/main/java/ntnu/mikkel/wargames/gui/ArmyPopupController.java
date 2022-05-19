package ntnu.mikkel.wargames.gui;


import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.legacy.MFXLegacyComboBox;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.text.TableView;
import ntnu.mikkel.wargames.data.Unit;
import ntnu.mikkel.wargames.logic.Army;

public class ArmyPopupController implements Initializable {

  //FXML Elements
  @FXML
  private MFXTextField armyName = new MFXTextField();
  @FXML
  private MFXTextField unitName = new MFXTextField();
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

  private Army army;
  private Unit unit;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    ObservableList<String>
        list = FXCollections.observableArrayList("InfantryUnit", "CommanderUnit", "RangedUnit",
        "CavalryUnit");
    unitType.setItems(list);
    unitType.setPromptText("Unit");
  }


  public void setArmyScene(Scene armyScene) {
    this.armySetupScene = armyScene;
  }


  private void setScene(Stage primaryStage, Scene newScene) {
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

  private void clearTextFields() {
    this.armyName.clear();
    this.amount.clear();
    this.armor.clear();
    this.attack.clear();
    this.health.clear();
  }


  private void noNameAlert() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Name is blank");
    alert.setHeaderText("Error");
    alert.setContentText("Please fill in Army name");
    alert.show();
  }


  @FXML
  public void ExitButtonPressed(javafx.event.ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Exit");
    alert.setHeaderText("You are about to exit Wargames.");
    alert.setContentText("Are you sure you want to exit?");
    if (alert.showAndWait().get() == ButtonType.OK) {
      System.exit(0);
    }


  }
}
