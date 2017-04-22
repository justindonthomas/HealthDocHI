package healthdocHI.clinicalinterface.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application
{
  
  private SplitPane root;
  private HealthDocController controller;
  @Override
  public void start(Stage stage)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PrimaryWindow.fxml"));
      this.root = (SplitPane)loader.load();
      this.controller = loader.getController();
      stage.setTitle("HealthDoc");
      stage.setScene(new Scene(root, 600, 400));
      stage.show();
      
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
