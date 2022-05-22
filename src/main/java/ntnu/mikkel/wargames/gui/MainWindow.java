package ntnu.mikkel.wargames.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

  /**
   * Main start method of application.
   *
   * @param primaryStage the first stage.
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    try {
      //Loader for HomePage.FXML
      FXMLLoader homePageLoader =
          new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/HomePage.fxml"));
      Parent homePagePane = homePageLoader.load();
      this.menuScene = new Scene(homePagePane, 1440, 850);

      //Getting loader and a pane for ArmySetup scene.
      FXMLLoader armySetupLoader =
          new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/ArmySetupPage.fxml"));
      Parent armySetupPane = armySetupLoader.load();
      this.armySetupScene = new Scene(armySetupPane, 1440, 850);
      armySetupController = armySetupLoader.getController();

      //Loader for HowToPlayPage.FXML
      FXMLLoader howToPlayPageLoader =
          new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/HowToPlayPage.fxml"));
      Parent howToPlayPagePane = howToPlayPageLoader.load();
      this.howToPlayScene = new Scene(howToPlayPagePane, 1440, 850);
      howToPlayController = howToPlayPageLoader.getController();

      //Loader for BattlePage.FXML
      FXMLLoader battleLoader =
          new FXMLLoader(getClass().getResource("/ntnu.mikkel.wargames/BattlePage.fxml"));
      Parent battlePane = battleLoader.load();
      this.battleScene = new Scene(battlePane, 1440, 850);
      battleController = battleLoader.getController();

      //Gets the different controllers in MenuController class
      menuController = homePageLoader.getController();
      menuController.setHowToPlayScene(this.howToPlayScene);
      menuController.setArmySetupScene(this.armySetupScene);

      //Setting up the Army scenes.
      this.armySetupController.setMenuScene(this.menuScene);
      this.armySetupController.setBattleScene(this.battleScene);
      this.armySetupController.setArmyScene(this.armySetupScene);

      //Setting up the how to play scenes.
      this.howToPlayController.setHomeScene(menuScene);

      //Setting up the Battle scenes.
      this.battleController.setArmyScene(this.armySetupScene);

      //Recieve controllers
      this.armySetupController.receiveControllers(this.battleController, this.menuController);
      this.battleController.recieveControllers(this.armySetupController);
      this.menuController.recieveControllers(this.howToPlayController, this.armySetupController);
      this.howToPlayController.recieveControllers(this.menuController);

      //Set first scene.
      primaryStage.setTitle("Wargames");
      primaryStage.setResizable(false);
      primaryStage.setScene(this.menuScene);
      primaryStage.show();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Alternative start method for application,
   *
   * @param args string of arguments.
   */
  public static void main(String[] args) {
    launch(args);
  }
}