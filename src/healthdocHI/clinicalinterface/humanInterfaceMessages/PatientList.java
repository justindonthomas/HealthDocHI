package healthdocHI.clinicalinterface.humanInterfaceMessages;

import java.util.ArrayList;

/**
 * A list of patient ids
 * Created by jdt on 4/22/17.
 */
public class PatientList extends RequestedData{
  private ArrayList<String> patientList;

  public PatientList(ArrayList<String> patients){
    patientList = patients;
  }

  /**
   * Return an array copy of the doctor's patient list.
   * @return Array containing copies of the doctor's patient ids.
   */
  public String[] getPatientArray(){
    int size = patientList.size();
    String[] patients = new String[size];
    for(int i = 0; i < size; ++i){
      patients[i] = new String(patientList.get(i));
    }
    return patients;
  }
}
