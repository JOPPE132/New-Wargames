package ntnu.mikkel.wargames.gui;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * Class sets up all different scenes with corresponding FXML-page.
 */
public class MainWindow extends Application {

  //Scenes
  private Scene menuScene;
  private Scene howToPlayScene;
  private Scene battleScene;
  private Scene armySetupScene;
  private Scene armyPopupScene;
  private Scene addUnitScene;

  //Controllers
  private MenuController menuController;
  private ArmySetupController armySetupController;
  private HowToPlayController howToPlayController;
  private BattleController battleController;
  private ArmyPopupController armyPopupController;
  private AddUnitController addUnitController;

  //@SuppressWarnings("unchecked")
  @Override
  public void start(Stage primaryStage) throws Exception {
    try{
    //Loader for HomePage.FXML
    FXMLLoader homePageLoader = new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/HomePage.fxml"));
    Parent homePagePane = homePageLoader.load();
    this.menuScene = new Scene(homePagePane, 1440, 850);


    //Getting loader and a pane for ArmySetup scene.
    FXMLLoader armySetupLoader = new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/ArmySetupPage.fxml"));
    Parent armySetupPane = armySetupLoader.load();
    this.armySetupScene = new Scene(armySetupPane, 1440, 850);
    armySetupController = armySetupLoader.getController();

    //Loader for HowToPlayPage.FXML
    FXMLLoader howToPlayPageLoader = new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/HowToPlayPage.fxml"));
    Parent howToPlayPagePane = howToPlayPageLoader.load();
    this.howToPlayScene = new Scene(howToPlayPagePane, 1440, 850);
    howToPlayController = howToPlayPageLoader.getController();


    //Loader for BattlePage.FXML
    FXMLLoader battleLoader = new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/BattlePage.fxml"));
    Parent battlePane = battleLoader.load();
    this.battleScene = new Scene(battlePane, 1440, 850);
    battleController = battleLoader.getController();

    //Loader for ArmyPopup.FXML
    FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/ArmyPopup.fxml"));
    Parent popupPane = popupLoader.load();
    this.armyPopupScene = new Scene(popupPane, 750,550);
    armyPopupController = popupLoader.getController();

    //Loader for AddUnitsPage.FXML
    FXMLLoader addUnitsLoader = new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/AddUnitsPage.fxml"));
    Parent addUnitsPane = addUnitsLoader.load();
    this.addUnitScene = new Scene(addUnitsPane, 750, 550);
    addUnitController = addUnitsLoader.getController();

    //Gets the different controllers in MenuController class
    menuController = homePageLoader.getController();
    menuController.setHowToPlayScene(this.howToPlayScene);
    menuController.setArmySetupScene(this.armySetupScene);

    //Setting up the Army scenes.
    this.armySetupController.setMenuScene(this.menuScene);
    this.armySetupController.setBattleScene(this.battleScene);
    this.armySetupController.setEditArmyScene(this.armyPopupScene);
    this.armySetupController.setAddUnitsScene(this.addUnitScene);
    this.armySetupController.setArmyScene(this.armySetupScene);

    //Setting up the how to play scenes.
    this.howToPlayController.setHomeScene(menuScene);

    //Setting up the Battle scenes.
    this.battleController.setArmyScene(this.armySetupScene);

    //Setting the ArmyPopup scenes.
    this.armyPopupController.setArmyScene(this.armySetupScene);

    //Setting the AddUnits scenes.
    this.addUnitController.setArmyScene(this.armySetupScene);



    primaryStage.setTitle("Wargames");
    primaryStage.setResizable(false);
    primaryStage.setScene(this.menuScene);
    primaryStage.show();
  }
    catch(Exception e){
    System.out.println(e.getMessage());
  }
  }

  @FXML
  private void exitApplication(Stage stage){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Exit");
    alert.setHeaderText("You are about to exit Wargames.");
    alert.setContentText("Are you sure you want to exit?");

    if(alert.showAndWait().get() == ButtonType.OK){
      stage.close();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
