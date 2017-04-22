package healthdocHI.clinicalinterface.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;

public class HealthDocController implements Initializable
{

  @FXML
  private Pane subPane;
  
  @FXML
  private Button calandarButton;
  @FXML
  private Button patientRecButton;
  @FXML
  private Button billingButton;
  @FXML
  private Button pharmButton;
  @FXML
  private Button labButton;
  @FXML
  private Button employeeButton;
  @FXML
  private Button notificationButton;
  
  
  
  
  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    // TODO Auto-generated method stub
    
  }
  
  @FXML
  private void handleNotificationButtonPress()
  {
    
  }
  
  @FXML
  private void handleCalandarButtonPress()
  {
    
  }
  
  @FXML
  private void handleRecordButtonPress()
  {
    try
    {
      SplitPane recordPane = FXMLLoader.load(getClass().getResource("fxml/NursePatientRecordView.fxml"));
      getSubPane().getChildren().add(recordPane);
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @FXML
  private void handleEmployeeButtonPress()
  {
    
  }
  
  @FXML
  private void handlePharmButtonPress()
  {
    
  }
  
  @FXML
  private void handleBillingButtonPress()
  {
    
  }
  
  @FXML
  private void handleLabButtonPress()
  {
    
  }
  
  private Pane getSubPane()
  {
    return this.subPane;
  }
}
