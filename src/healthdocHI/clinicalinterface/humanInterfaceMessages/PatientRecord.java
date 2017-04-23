package healthdocHI.clinicalinterface.humanInterfaceMessages;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by jdt on 4/21/17.
 * Accessing patient record:
 *
 * Getting the fields:
 * This gets the patient's name for this record:
 * RecordField nameField = patientRecord.get(PatientRecord.Field.NAME);
 *
 * Name label nameField.label() should return something like "Name: ".
 * Patients name would be nameField.text(); To return the patients name.
 *
 * Getting the patient's name could be in one line:
 * patientRecord.get(PatientRecord.Field.NAME).text(); Would return the name of
 * the patient.
 *
 * Visits, should remain in the order that they were added. Most recent last
 * accessed by index (maybe the order they appear in the dropdown.
 * VisitRecord visit = patientRecord.getVisitRecord(patientRecord.size() - 1);
 * gets the most recent Visit record.
 *
 * Visit records have fields the same way the patient records have them.
 * visit.get(VisitRecord.Field.BLOOD_PRESSURE).text() returns the blood pressure
 * entered for that visit.
 *
 * visit.getDate() returns a Date object for the date of the visit.
 *
 * Writing to a visit will use the RecordField's updateData() method. to update
 * the newest visit's Blood Pressure (String newBloodPressure):
 *
 * VisitRecord latestVisit = patientRecord.getVisitRecord(patientRecord.size() - 1);
 * latestVisit.get(VisitRecord.Field.BLOOD_PRESSURE).updateData(newBloodPressure);
 *
 *
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
  private ArrayList<VisitRecord> visits;

  
  public PatientRecord(String id, String name, String dateOfBirth){
    patientData = new HashMap<>();
    visits = new ArrayList<>();
    
    patientData.put(Field.NAME, new RecordField("Name", name, true));
    patientData.put(Field.ID, new RecordField("ID", id, false));
    patientData.put(Field.DOB, new RecordField("DOB", dateOfBirth, false));
    patientData.put(Field.MEDICATIONS, new RecordField("Medications", "", true));
  }

  /**
   * Get one of the main fields for this record.
   * @param field What field to get.
   * @return RecordField object.
   */
  public RecordField getField(Field field){
    return patientData.get(field);
  }

  public int size(){
    return visits.size();
  }

  /**
   * Add a new visit to the visit list.
   * @param newVisit New visit record object.
   */
  public void addVisit(VisitRecord newVisit){
    visits.add(newVisit);
  }
  
  public int getVisitNumber()
  {
    return visits.size();
  }
  
  /**
   * Get a visit record from the visit record list.
   * @param visit
   * @return
   * @throws IndexOutOfBoundsException
   */
  public VisitRecord getVisitRecord(int visit) throws IndexOutOfBoundsException{
    if(visit < visits.size()){
      return visits.get(visit);
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }
}
