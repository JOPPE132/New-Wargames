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

  //Controllers
  private MenuController menuController;
  private ArmySetupController armySetupController;
  private HowToPlayController howToPlayController;
  private BattleController battleController;

  @Override
  public void start(Stage primaryStage) throws Exception{
    try{
      //Loader for HomePage.FXML
      URL homePageURL = getClass().getResource("/HomePage.fxml");
      FXMLLoader homePageLoader = new FXMLLoader(homePageURL);
      Parent homePagePane = homePageLoader.load();
      this.menuScene = new Scene(homePagePane,1440,850);

      //Loader for ArmySetupPage.FXML
      URL armySetupURL = getClass().getResource("/ArmySetupPage.fxml");
      FXMLLoader armySetupLoader = new FXMLLoader(armySetupURL);
      Parent armySetupPane = armySetupLoader.load();
      this.armySetupScene = new Scene(armySetupPane, 1440, 850);

      //Loader for HowToPlayPage.FXML
      URL howToPlayURL = getClass().getResource("/HowToPlayPage.fxml");
      FXMLLoader howToPlayPageLoader = new FXMLLoader(howToPlayURL);
      Parent howToPlayPagePane = howToPlayPageLoader.load();
      this.howToPlayScene= new Scene(howToPlayPagePane, 1440, 850);

      //Loader for BattlePage.FXML
      URL battleURL = getClass().getResource("/BattlePage.fxml");
      FXMLLoader battleLoader = new FXMLLoader(battleURL);
      Parent battlePane = battleLoader.load();
      this.battleScene = new Scene(battlePane, 1440, 850);




      //Gets the different controllers in MenuController class
      this.menuController = homePageLoader.getController();
      this.menuController.setHowToPlayScene(this.howToPlayScene);
      this.menuController.setArmySetupScene(this.armySetupScene);

      //Setting up the MenuController scenes.
      this.menuController.setArmySetupScene(armySetupScene);
      this.menuController.setHowToPlayScene(howToPlayScene);

      //Setting up the Army scenes.
      this.armySetupController.setArmySetupScene(armySetupScene);
      this.armySetupController.setBattleScene(battleScene);

      //Setting up the how to play scenes.
      this.howToPlayController.setHomeScene(menuScene);


      //Setting up the Battle scenes.
      this.battleController.setArmyScene(armySetupScene);
      this.battleController.sethomeScene(menuScene);


      primaryStage.setResizable(false);
      primaryStage.setScene(this.menuScene);
      primaryStage.show();

      primaryStage.setOnCloseRequest(event -> {
        event.consume();
        exitApplication(primaryStage);
      });
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
