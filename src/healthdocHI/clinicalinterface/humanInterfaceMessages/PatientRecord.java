package healthdocHI.clinicalinterface.humanInterfaceMessages;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jdt on 4/21/17.
 */
public class PatientRecord extends RequestedData {
  public enum Field{
    ID,
    NAME,
    DOB,
    MEDICATIONS;
  }

  /*
   * patient data is a hashmap of fields mapped to string 3-ples. Each 3-ple
   * contains a label, text, and read/write designation. If the
   *
   */
  private HashMap<Field, RecordField> patientData;
  private String patientID;
  private String name;
  private String dateOfBirth;
  private ArrayList<VisitRecord> visits;

  public int size(){
    return visits.size();
  }

  public VisitRecord getVisitRecord(int visit) throws IndexOutOfBoundsException{
    if(visit < visits.size()){
      return visits.get(visit);
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }
}
