package ntnu.mikkel.wargames.gui;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.Action;
import ntnu.mikkel.wargames.data.CavalryUnit;
import ntnu.mikkel.wargames.data.CommanderUnit;
import ntnu.mikkel.wargames.data.InfantryUnit;
import ntnu.mikkel.wargames.data.RangedUnit;
import ntnu.mikkel.wargames.data.Unit;
import ntnu.mikkel.wargames.data.UnitType;
import ntnu.mikkel.wargames.logic.Army;


public class ArmySetupController implements Initializable {

  @FXML
  private Label armyOneLabel1 = new Label();
  @FXML
  private MFXTextField armyName1 = new MFXTextField();
  @FXML
  private MFXTextField unitType1 = new MFXTextField();
  @FXML
  private MFXTextField unitName1 = new MFXTextField();
  @FXML
  private MFXTextField health1 = new MFXTextField();
  @FXML
  private MFXTextField attack1 = new MFXTextField();
  @FXML
  private MFXTextField armor1 = new MFXTextField();
  @FXML
  private Label armyOneLabel2 = new Label();
  @FXML
  private MFXTextField armyName2 = new MFXTextField();
  @FXML
  private MFXTextField unitType2 = new MFXTextField();
  @FXML
  private MFXTextField unitName2 = new MFXTextField();
  @FXML
  private MFXTextField amount2 = new MFXTextField();
  @FXML
  private MFXTextField health2 = new MFXTextField();
  @FXML
  private MFXTextField attack2 = new MFXTextField();
  @FXML
  private MFXTextField armor2 = new MFXTextField();
  @FXML
  private MFXButton addUnits1Button = new MFXButton();

  //TableView
  @FXML
  TableView<Unit> tableView;
  @FXML
  TableColumn<Unit, String> nameCol;
  @FXML
  TableColumn<Unit, Integer> healthCol;
  @FXML
  TableColumn<Unit, Integer> attackCol;
  @FXML
  TableColumn<Unit, Integer> armorCol;

  //Scenes
  private Scene homeScene;
  private Scene battleScene;
  private Scene armyScene;

  private Army army;
  private ObservableList<Unit> observableList;

  public void setMenuScene(Scene menuScene){
    this.homeScene= menuScene;
  }

  public void setArmyScene(Scene armyScene){
    this.armyScene = armyScene;
  }

  public void setBattleScene(Scene battleScene){
    this.battleScene = battleScene;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
      try{
        //Create business logic.
        this.army = new Army("");


      tableView.getColumns().addAll(nameCol, healthCol, attackCol, armorCol);

      nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
      healthCol.setCellValueFactory(new PropertyValueFactory<>("Health"));
      attackCol.setCellValueFactory(new PropertyValueFactory<>("Attack"));
      armorCol.setCellValueFactory(new PropertyValueFactory<>("Armor"));

      this.observableList = FXCollections.observableArrayList(this.army.getArrayList());
      this.tableView.setItems(this.observableList);


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  protected void battleButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.battleScene);
  }

  @FXML
  protected void prepareArmiesButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyScene);
  }

  @FXML
  protected void homeButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.homeScene);
  }

  private void setScene(Stage primaryStage, Scene newScene){
    primaryStage.hide();
    primaryStage.setScene(newScene);
    primaryStage.show();
  }

  @FXML
  public void addUnitButtonPressed(MouseEvent mouseEvent) {

      if (unitType1.getText().equals("InfantryUnit")) {
        Unit unit = new InfantryUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));

        this.army.addUnit(unit);
        this.updateObservableList();
      }

      if (unitType1.getText().equals("CavalryUnit")) {
        Unit unit = new CavalryUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));
        this.army.addUnit(unit);
        this.updateObservableList();
      }

      if (unitType1.getText().equals("CommanderUnit")) {
        Unit unit = new CommanderUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));
        this.army.addUnit(unit);
        this.updateObservableList();
      }

      if (unitType1.getText().equals("CavalryUnit")) {
        Unit unit = new RangedUnit(unitName1.getText(), Integer.parseInt(health1.getText()),
            Integer.parseInt(armor1.getText()), Integer.parseInt(attack1.getText()));
        this.army.addUnit(unit);
        this.updateObservableList();
      }

      //clear alle felt
    }

    public ObservableList<Unit> getObservableList(){
      ObservableList<Unit> units = FXCollections.observableArrayList();
      return units;
    }

    public void setArmyName(MouseEvent mouseEvent){
      armyOneLabel1.setText(armyName1.getText());
      armyName1.clear();
    }

    private void updateObservableList(){
    this.observableList.setAll(this.army.getArrayList());
    }


//    private void fillDummyWithData(){
//    this.army.addUnit(new CavalryUnit("CavalryUnit", 10, 10, 10));
//    this.army.addUnit(new InfantryUnit("InfantryUnit", 10, 10, 10));
//    }

}
