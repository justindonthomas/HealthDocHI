package healthdocHI.clinicalinterface.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import healthdocHI.clinicalinterface.ClinicalInterfaceAccess;
import healthdocHI.clinicalinterface.humanInterfaceMessages.DataRequest;
import healthdocHI.clinicalinterface.humanInterfaceMessages.RequestedData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class HealthDocController implements Initializable, ClinicalInterfaceAccess
{

  @FXML
  private Pane subPane;
  
  @FXML
  private Label greetingsLabel;
  
  @FXML
  private MenuItem closeOption;
  
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
  
  private Node currentNode;
  
  
  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    greetingsLabel.setText("Greetings Dr. Roman, please choose an option above to continue.");
    currentNode = null;
  }
  
  @Override
  public RequestedData sendDataRequest(DataRequest request)
  {
    // TODO Auto-generated method stub
    return null;
  }
  
  @FXML
  private void handleClose()
  {
    Platform.exit();
  }
  
  @FXML
  private void handleNotificationButtonPress()
  {
    
  }
  
  @FXML
  private void handleCalendarButtonPress()
  {
    try
    {
      SplitPane calendarPane = FXMLLoader.load(getClass().getResource("fxml/PhysicianCalendarView.fxml"));
      changeCurrentView(calendarPane);
      getSubPane().getChildren().add(calendarPane);
      
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @FXML
  private void handleRecordButtonPress()
  {
    try
    {
      SplitPane recordPane = FXMLLoader.load(getClass().getResource("fxml/NursePatientRecordView.fxml"));
      changeCurrentView(recordPane);
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
    try
    {
      SplitPane pharmPane = FXMLLoader.load(getClass().getResource("fxml/PatientPharmacyView.fxml"));
      changeCurrentView(pharmPane);
      getSubPane().getChildren().add(pharmPane);
      
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @FXML
  private void handleBillingButtonPress()
  {
    
  }
  
  @FXML
  private void handleLabButtonPress()
  {
    try
    {
      SplitPane labPane = FXMLLoader.load(getClass().getResource("fxml/LabView.fxml"));
      changeCurrentView(labPane);
      getSubPane().getChildren().add(labPane);
      
    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  private void changeCurrentView (Node newNode)
  {
    if (currentNode != null)
    {
      getSubPane().getChildren().remove(currentNode);
    }
    currentNode = newNode;
  }
  
  private Pane getSubPane()
  {
    return this.subPane;
  }

}
