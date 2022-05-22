package ntnu.mikkel.wargames.gui;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ntnu.mikkel.wargames.data.CavalryUnit;
import ntnu.mikkel.wargames.data.CommanderUnit;
import ntnu.mikkel.wargames.data.InfantryUnit;
import ntnu.mikkel.wargames.data.RangedUnit;
import ntnu.mikkel.wargames.data.Unit;
import ntnu.mikkel.wargames.logic.Army;

/**
 * Class represents a Controller in the Application. This class does most of the
 * back-end work. Here units and armies are created and put into tableviewes ready
 * to battle. Class also includes methods for changing Scenes and alerts as well as
 * creating new Armies and Units.
 */
public class ArmySetupController implements Initializable {

  //FXML ELEMENTS IN SCENE
  @FXML
  private MFXTextField armyName1 = new MFXTextField();
  @FXML
  private MFXTextField unitName1 = new MFXTextField();
  @FXML
  private MFXTextField health1 = new MFXTextField();
  @FXML
  private MFXTextField attack1 = new MFXTextField();
  @FXML
  private MFXTextField armor1 = new MFXTextField();
  @FXML
  private MFXTextField armyName2 = new MFXTextField();
  @FXML
  private MFXTextField unitName2 = new MFXTextField();
  @FXML
  private MFXTextField health2 = new MFXTextField();
  @FXML
  private MFXTextField attack2 = new MFXTextField();
  @FXML
  private MFXTextField armor2 = new MFXTextField();
  @FXML
  private MFXComboBox comboBox = new MFXComboBox();
  @FXML
  private MFXComboBox comboBox2 = new MFXComboBox();
  @FXML
  private Label sizeLabel = new Label();
  @FXML
  private Label sizeLabelArmy2 = new Label();
  @FXML
  Label armyOneLabel1 = new Label();
  @FXML
  Label armyTwoLabel1 = new Label();

  //TableView ARMY 1
  @FXML
  TableView<Unit> tableView;
  @FXML
  TableColumn<Unit, String> nameColumn;
  @FXML
  TableColumn<Unit, Integer> healthColumn;
  @FXML
  TableColumn<Unit, Integer> attackColumn;
  @FXML
  TableColumn<Unit, Integer> armorColumn;
  @FXML
  TableColumn<Unit, String> unitTypeColumn;

  //TableView ARMY 2
  @FXML
  TableView<Unit> tableView2;
  @FXML
  TableColumn<Unit, String> nameColumn2;
  @FXML
  TableColumn<Unit, Integer> healthColumn2;
  @FXML
  TableColumn<Unit, Integer> attackColumn2;
  @FXML
  TableColumn<Unit, Integer> armorColumn2;
  @FXML
  TableColumn<Unit, Integer> unitTypeColumn2;

  //Controllers
  private BattleController battleController;
  private MenuController menuController;

  //Scenes
  private Scene homeScene;
  private Scene battleScene;
  private Scene armyScene;

  private Army army;
  private Army army2;
  private ObservableList<Unit> observableList;
  private ObservableList<Unit> observableList2;

  /**
   * Changes scene to MenuScene.
   *
   * @param menuScene the new Scene.
   */
  public void setMenuScene(Scene menuScene) {
    this.homeScene = menuScene;
  }

  /**
   * Changes scene to ArmyScene.
   *
   * @param armyScene the new Scene.
   */
  public void setArmyScene(Scene armyScene) {
    this.armyScene = armyScene;
  }

  /**
   * Changes scene to BattleScene.
   *
   * @param battleScene the new Scene.
   */
  public void setBattleScene(Scene battleScene) {
    this.battleScene = battleScene;
  }

  /**
   * Initializes two new Armies for Battle. The different Armies
   * are put into a TableView for a good presentation.
   *
   * @param url
   * @param resourceBundle
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //Create the Armies.
    this.army = new Army("Army1");
    this.army2 = new Army("Army2");

    //TableView ARMY1
    this.comboBox.getItems().addAll("InfantryUnit", "CavalryUnit", "RangedUnit", "CommanderUnit");
    this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
    this.healthColumn.setCellValueFactory(new PropertyValueFactory<>("Health"));
    this.attackColumn.setCellValueFactory(new PropertyValueFactory<>("Attack"));
    this.armorColumn.setCellValueFactory(new PropertyValueFactory<>("Armor"));
    this.tableView.getColumns().addAll(nameColumn, healthColumn, attackColumn, armorColumn);
    this.observableList = FXCollections.observableArrayList(this.army.getArrayList());
    this.tableView.setItems(this.observableList);

    //TableView ARMY2
    this.comboBox2.getItems().addAll("InfantryUnit", "CavalryUnit", "RangedUnit", "CommanderUnit");
    this.nameColumn2.setCellValueFactory(new PropertyValueFactory<>("Name"));
    this.healthColumn2.setCellValueFactory(new PropertyValueFactory<>("Health"));
    this.attackColumn2.setCellValueFactory(new PropertyValueFactory<>("Attack"));
    this.armorColumn2.setCellValueFactory(new PropertyValueFactory<>("Armor"));
    this.tableView2.getColumns().addAll(nameColumn2, healthColumn2, attackColumn2, armorColumn2);
    this.observableList2 = FXCollections.observableArrayList(this.army2.getArrayList());
    this.tableView2.setItems(this.observableList2);
  }

  /**
   * Changes scene to BattlePage.FXML
   *
   * @param mouseEvent onMouseClicked button.
   */
  @FXML
  protected void battleButtonPressed(MouseEvent mouseEvent) {
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.battleScene);
  }

  /**
   * Resets the Armies by clearing their ArrayList of elements. Updates
   * ObservableList used in TableView. Updates Armies size.
   *
   * @param mouseEvent on mouseClicked button.
   */
  public void resetArmiesButtonPressed(MouseEvent mouseEvent) {
    this.army.getArrayList().clear();
    this.army2.getArrayList().clear();
    updateObservableList();
    updateObservableList2();
    this.sizeLabel.setText(String.valueOf(army.getSize()));
    this.sizeLabelArmy2.setText(String.valueOf(army2.getSize()));
    battleController.clearArmy();
  }

  /**
   * Changes scene to HomePage.FXML
   *
   * @param mouseEvent onMouseClicked button.
   */
  @FXML
  protected void homeButtonPressed(MouseEvent mouseEvent) {
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
   * Adds a new Unit to the TableView 2. Exception are thrown if values are
   * >0 and <100, empty or Strings.
   *
   * @param mouseEvent onMouseClicked button.
   */
  @FXML
  public void addUnitButtonPressed(MouseEvent mouseEvent) {
    try {
      if (comboBox.getText().equals("InfantryUnit")) { //If unit in combobox is InfantryUnit.
        Unit unit = new InfantryUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));
        this.army.addUnit(unit);
        this.updateObservableList();
        this.sizeLabel.setText(String.valueOf(army.getSize()));
      }

      if (comboBox.getText().equals("CavalryUnit")) { //If unit in combobox is CavalryUnit.
        Unit unit = new CavalryUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));
        this.army.addUnit(unit);
        this.updateObservableList();
        this.sizeLabel.setText(String.valueOf(army.getSize()));
      }

      if (comboBox.getText().equals("CommanderUnit")) { //If unit in combobox is CommanderUnit.
        Unit unit = new CommanderUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));
        this.army.addUnit(unit);
        this.updateObservableList();
        this.sizeLabel.setText(String.valueOf(army.getSize()));
      }

      if (comboBox.getText().equals("RangedUnit")) { //If unit in combobox is RangedUnit.
        Unit unit = new RangedUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));
        this.army.addUnit(unit);
        this.updateObservableList();
        this.sizeLabel.setText(String.valueOf(army.getSize()));
      }
    } catch (IllegalArgumentException illegalArgumentException) {
      missingFieldsAlert(); //Throw alert.
    }
  }

  /**
   * Adds a new Unit to the TableView 2. Exception are thrown if values are
   * >0 and <100, empty or Strings.
   *
   * @param mouseEvent onMouseClicked button.
   */
  @FXML
  public void addUnitButton2Pressed(MouseEvent mouseEvent) {
    try {
      if (comboBox2.getText().equals("InfantryUnit")) { //If unit in combobox is InfantryUnit.
        Unit unit = new InfantryUnit(unitName2.getText(), Integer.parseInt(health2.getText()),
            Integer.parseInt(armor2.getText()), Integer.parseInt(attack2.getText()));
        this.army2.addUnit(unit);
        this.updateObservableList2();
        this.sizeLabelArmy2.setText(String.valueOf(army2.getSize()));
      }

      if (comboBox2.getText().equals("CavalryUnit")) { //If unit in combobox is CavalryUnit.
        Unit unit = new CavalryUnit(unitName2.getText(), Integer.parseInt(health2.getText()),
            Integer.parseInt(armor2.getText()), Integer.parseInt(attack2.getText()));
        this.army2.addUnit(unit);
        this.updateObservableList2();
        this.sizeLabelArmy2.setText(String.valueOf(army2.getSize()));
      }

      if (comboBox2.getText().equals("CommanderUnit")) { //If unit in combobox is CommanderUnit.
        Unit unit = new CommanderUnit(unitName2.getText(), Integer.parseInt(health2.getText()),
            Integer.parseInt(armor2.getText()), Integer.parseInt(attack2.getText()));
        this.army2.addUnit(unit);
        this.updateObservableList2();
        this.sizeLabelArmy2.setText(String.valueOf(army2.getSize()));
      }

      if (comboBox2.getText().equals("RangedUnit")) { //If unit in combobox is RangedUnit.
        Unit unit = new RangedUnit(unitName2.getText(), Integer.parseInt(health2.getText()),
            Integer.parseInt(armor2.getText()), Integer.parseInt(attack2.getText()));
        this.army2.addUnit(unit);
        this.updateObservableList2();
        this.sizeLabelArmy2.setText(String.valueOf(army2.getSize()));
      }
    } catch (IllegalArgumentException illegalArgumentException) {
      missingFieldsAlert();
    }
  }

  /**
   * Set Army 1 label to desired Army 1 name.
   *
   * @param mouseEvent onMouseClicked.
   */
  public void setArmyName(MouseEvent mouseEvent) {
    if (armyName1.getText().isBlank()) {
      missingFieldsAlert();
    } else {
      armyOneLabel1.setText(armyName1.getText());
      armyName1.clear();
    }
  }

  /**
   * Set Army 2 label to desired Army 2 name.
   *
   * @param mouseEvent
   */
  public void setArmy2Name(MouseEvent mouseEvent) {
    if (armyName2.getText().isBlank()) {
      missingFieldsAlert();
    } else {
      armyTwoLabel1.setText(armyName2.getText());
      armyName2.clear();
    }
  }

  /**
   * Updates the observableList overlooking the ArrayList in Army.
   */
  private void updateObservableList() {
    this.observableList.setAll(this.army.getArrayList());
  }

  /**
   * Updates the observableList overlooking the ArrayList in Army2.
   */
  private void updateObservableList2() {
    this.observableList2.setAll(this.army2.getArrayList());
  }

  /**
   * Alert for no selected unit while trying to remove Unit.
   */
  private void noSelectedUnitAlert() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("No selected Unit to remove.");
    alert.show();
  }

  /**
   * Removes an exisiting Unit from the tableView and Army.
   *
   * @param mouseEvent onMouseClicked button.
   */
  public void removeUnit(MouseEvent mouseEvent) {
    Unit selectedUnit = this.tableView.getSelectionModel().getSelectedItem();
    if (selectedUnit == null) {
      noSelectedUnitAlert();
    } else {
      this.army.removeUnit(selectedUnit);
      this.updateObservableList();
      this.sizeLabel.setText(String.valueOf(army.getSize()));
    }
  }

  /**
   * Removes an existing Unit from the tableView and Army2.
   *
   * @param mouseEvent onMouseClicked button.
   */
  public void removeUnit2(MouseEvent mouseEvent) {
    Unit selectedUnit = this.tableView2.getSelectionModel().getSelectedItem();
    if (selectedUnit == null) {
      noSelectedUnitAlert();
    } else {
      this.army2.removeUnit(selectedUnit);
      this.updateObservableList2();
      this.sizeLabelArmy2.setText(String.valueOf(army2.getSize()));
    }
  }

  /**
   * Returns Army 1.
   *
   * @return returns Army 1.
   */
  public Army getArmy() {
    return army;
  }

  /**
   * Returns Army 2.
   *
   * @return returns Army 2.
   */
  public Army getArmy2() {
    return army2;
  }

  /**
   * Receive controllers.
   *
   * @param battleController
   * @param menuController
   */
  public void receiveControllers(BattleController battleController, MenuController menuController) {
    this.battleController = battleController;
    this.menuController = menuController;
  }

  /**
   * Alert for missing fields or wrong values in adding units.
   */
  private void missingFieldsAlert() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Please fill out the missing fields or change the values.");
    alert.setHeaderText(
        "Remember minimum value is 1 and maximum value is 99. Otherwise, fill out the empty textfields.");
    alert.show();
  }
}