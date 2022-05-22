package ntnu.mikkel.wargames.gui;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ntnu.mikkel.wargames.data.Unit;
import ntnu.mikkel.wargames.logic.Army;

/**
 * Class represents a controller for BattlePage.FXML
 */
public class BattleController implements Initializable {

  @FXML
  private Label winnerLabel;
  private Scene armyScene;
  private ObservableList observableList;

  //Controllers
  ArmySetupController armySetupController;

  //Tableview
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

  /**
   * Recieve controller from ArmySetupController and initialize tableview.
   *
   * @param url
   * @param resourceBundle
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    recieveControllers(armySetupController);
    this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
    this.healthColumn.setCellValueFactory(new PropertyValueFactory<>("Health"));
    this.attackColumn.setCellValueFactory(new PropertyValueFactory<>("Attack"));
    this.armorColumn.setCellValueFactory(new PropertyValueFactory<>("Armor"));
    this.tableView.getColumns().addAll(nameColumn, healthColumn, attackColumn, armorColumn);
  }

  /**
   * Simulates a battle and updates tableview with remaining units in Army.
   *
   * @param mouseEvent on mouseClicked button.
   */
  public void simulateButtonPressed(MouseEvent mouseEvent) {
    Army winner = simulate(armySetupController.getArmy(), armySetupController.getArmy2());
    if (winner.getName().equals("Army1")) {
      winnerLabel.setText(armySetupController.armyOneLabel1.getText());
    }
    if (winner.getName().equals("Army2")) {
      winnerLabel.setText(armySetupController.armyTwoLabel1.getText());
    }
    this.observableList = FXCollections.observableList(winner.getArrayList());
    this.tableView.setItems(this.observableList);
  }

  /**
   * Simulate a battle between two Armies and return winner.
   *
   * @param armyOne first Army in battle.
   * @param armyTwo second Army in battle.
   * @return returns winner of the two Armies.
   */
  private Army simulate(Army armyOne, Army armyTwo) {
    if (armyOne.getArrayList().isEmpty() && armyTwo.getArrayList().isEmpty()) {
      invalidBattleAlert();
    }
    Army winner = null;

    while (armyOne.hasUnits() && armyTwo.hasUnits()) {

      int combatOrder = firstAttackerNumberGenerator();
      Unit randomArmyOneUnit = armyOne.getRandomunit();
      Unit randomArmyTwoUnit = armyTwo.getRandomunit();

      if (combatOrder == 0) {
        randomArmyOneUnit.attack(randomArmyTwoUnit);
        if (randomArmyTwoUnit.isAlive()) {
          randomArmyTwoUnit.attack(randomArmyOneUnit);
        }
        if (randomArmyTwoUnit.isDead()) {
          armyTwo.removeUnit(randomArmyTwoUnit);
        }
      }

      if (combatOrder == 1) {
        randomArmyTwoUnit.attack(randomArmyOneUnit);
        if (randomArmyOneUnit.isAlive()) {
          randomArmyOneUnit.attack(randomArmyTwoUnit);
        }
        if (randomArmyOneUnit.isDead()) {
          armyOne.removeUnit(randomArmyOneUnit);
        }
      }
    }
    if (armyOne.hasUnits()) {
      winner = armyOne;
    }
    if (armyTwo.hasUnits()) {
      winner = armyTwo;
    }
    return winner;
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
   * Changes scene to ArmySetupPage.FXML
   *
   * @param mouseEvent onMouseClicked button.
   */
  @FXML
  protected void backButtonPressed(MouseEvent mouseEvent) {
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyScene);
  }

  /**
   * Quits application if user presses yes on Alert.
   *
   * @param mouseEvent on mouseClicked button.
   */
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
   * Generates a random number between 0-1.
   *
   * @return returns a random number 0 or 1.
   */
  private int firstAttackerNumberGenerator() {
    Random random = new Random();
    int combat;
    combat = random.nextInt(2); //Including 0, exclude 2.
    return combat;
  }

  /**
   * Receieve controller-objects from MainWindow. Including objects made
   * within the controller.
   *
   * @param armySetupController controllerobject.
   */
  public void recieveControllers(ArmySetupController armySetupController) {
    this.armySetupController = armySetupController;
  }

  private void invalidBattleAlert(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText("Simulation can not be done with empty armies.");
    alert.setTitle("Error");
    alert.setContentText("Please add units to the Armies in the Army Setup.");
    alert.show();
  }
}