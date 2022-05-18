package ntnu.mikkel.wargames.gui;

import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.text.TableView;
import ntnu.mikkel.wargames.data.Unit;

public class ArmySetupController implements Initializable {

  //FXML Elements
  @FXML
  private MFXButton editArmy1 = new MFXButton();
  @FXML
  private MFXButton setTerrrain = new MFXButton();
  @FXML
  private MFXButton addUnits = new MFXButton();
  @FXML
  private MFXButton removeUnits = new MFXButton();
  @FXML
  private MFXButton editArmy2 = new MFXButton();
  @FXML
  private MFXButton addunits2 = new MFXButton();
  @FXML
  private MFXButton removeUnits2 = new MFXButton();
  @FXML
  private TableView armyOneTableView;


  //Scenes
  private Scene homeScene;
  private Scene battleScene;
  private Scene armyPopup;
  private Scene addUnitScene;
  private Scene armyScene;

  //Controllers

  public void setMenuScene(Scene menuScene){
    this.homeScene= menuScene;
  }

  public void setArmyScene(Scene armyScene){
    this.armyScene = armyScene;
  }

  public void setBattleScene(Scene battleScene){
    this.battleScene = battleScene;
  }

  public void setEditArmyScene(Scene armyPopup){
    this.armyPopup = armyPopup;
  }

  public void setAddUnitsScene(Scene addUnitScene){
    this.addUnitScene = addUnitScene;
  }

  public void setAddUnitScene(Scene addUnitScene){
    this.addUnitScene = addUnitScene;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

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
  protected void editArmyButtonPressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyPopup);
  }

  @FXML
  protected void addUnitsButton1Pressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.addUnitScene);
  }

  @FXML
  protected void addUnitsButton2Pressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.addUnitScene);
  }


  @FXML
  protected void editArmyButton2Pressed(MouseEvent mouseEvent){
    Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
    this.setScene(primaryStage, this.armyPopup);
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

}
