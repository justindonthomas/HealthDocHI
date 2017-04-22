package healthdocHI.clinicalinterface.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class PatientRecordController implements Initializable
{

  @FXML
  private TextField name;
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1)
  {
    name.setText("TEST");

  }

}
