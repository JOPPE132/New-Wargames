package ntnu.mikkel.wargames.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class MainWindow extends Application {

  private Stage primarystage;
  private Scene mainScene;

  @Override
  public void start(Stage primaryStage) throws Exception{

    FXMLLoader homePageLoader = new FXMLLoader(getClass().getResource("/BattlePage.fxml"));
    Parent mainPane = homePageLoader.load();
    this.mainScene = new Scene(mainPane,1440,850);


    primaryStage.setTitle("Wargames");
    primaryStage.setScene(this.mainScene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }




}
