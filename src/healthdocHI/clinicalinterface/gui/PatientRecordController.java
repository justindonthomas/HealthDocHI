package healthdocHI.clinicalinterface.gui;

import java.net.URL;
import java.util.ResourceBundle;

import healthdocHI.clinicalinterface.ProxyServer;
import healthdocHI.clinicalinterface.humanInterfaceMessages.DataRequest;
import healthdocHI.clinicalinterface.humanInterfaceMessages.PatientList;
import healthdocHI.clinicalinterface.humanInterfaceMessages.PatientRecord;
import healthdocHI.clinicalinterface.humanInterfaceMessages.VisitRecord;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientRecordController implements Initializable
{


  private ProxyServer server;
  private PatientRecord currentRecord;
  
  @FXML
  private TextField name;
  @FXML
  private TextField dob;
  @FXML
  private TextArea medications;
  @FXML
  private TextField bloodPres;
  @FXML
  private TextField temp;
  @FXML
  private TextField weight;
  @FXML
  private TextField other;
  @FXML
  private TextField staff;
  
  @FXML
  private ComboBox<String> patientIdComboBox;
  @FXML
  private ComboBox<String> patientEntryComboBox;
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1)
  {

    server = new ProxyServer();
    DataRequest request = new DataRequest(DataRequest.RequestType.PATIENT_LIST, "0001");
    PatientList pList = (PatientList)server.sendDataRequest(request);
    
    //Fill patient ID combo box
    patientIdComboBox.getItems().addAll(pList.getPatientArray());

  }

  @FXML
  private void handlePatientEntrySelection()
  {
    if (patientEntryComboBox.getItems().size() == 0)
    {
      bloodPres.clear();
      temp.clear();
      weight.clear();
      other.clear();
      staff.clear();
      return;
    }
    int visitNum = Integer.valueOf(patientEntryComboBox.getValue());
    if (currentRecord != null)
    {
      VisitRecord record = currentRecord.getVisitRecord(visitNum);
      bloodPres.setText(record.get(VisitRecord.Field.BLOOD_PRESSURE).text());
      temp.setText(record.get(VisitRecord.Field.TEMPERATURE).text());
      weight.setText(record.get(VisitRecord.Field.WEIGHT).text());
      other.setText(record.get(VisitRecord.Field.OTHER).text());
      staff.setText(record.get(VisitRecord.Field.STAFF).text());
    }
      
  }
  
  @FXML
  private void handleIdSelect()
  {

    String id = patientIdComboBox.getValue();
    DataRequest request = new DataRequest(DataRequest.RequestType.PATIENT_RECORD, id);
    PatientRecord record = (PatientRecord)server.sendDataRequest(request);
    currentRecord = record;
    
    name.setText(record.getField(PatientRecord.Field.NAME).text());
    dob.setText(record.getField(PatientRecord.Field.DOB).text());
    medications.setText(record.getField(PatientRecord.Field.MEDICATIONS).text());
    
    patientEntryComboBox.getItems().clear();
    int numVisits = record.getVisitNumber();
    for (int i = 0; i < numVisits; i++)
    {
      patientEntryComboBox.getItems().add(String.valueOf(i));
    }
    
  }
  
}
