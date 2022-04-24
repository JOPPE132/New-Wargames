package ntnu.mikkel.wargames.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class MainWindow extends Application {

  private Stage primarystage;
  private Scene mainScene;
  private Scene playScene;
  private Scene helpScene;

  @Override
  public void start(Stage primaryStage) throws Exception{
    this.primarystage = primaryStage;

    FXMLLoader mainPaneLoader = new FXMLLoader(getClass().getResource("/HomePage.fxml"));
    Parent mainPane = mainPaneLoader.load();
    this.mainScene = new Scene(mainPane,1000,770);


    primaryStage.setTitle("Wargames");
    primaryStage.setScene(this.mainScene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }




}
