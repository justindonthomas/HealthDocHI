package healthdocHI.clinicalinterface;

import healthdocHI.clinicalinterface.humanInterfaceMessages.DataRequest;
import healthdocHI.clinicalinterface.humanInterfaceMessages.PatientList;
import healthdocHI.clinicalinterface.humanInterfaceMessages.PatientRecord;
import healthdocHI.clinicalinterface.humanInterfaceMessages.RequestedData;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is an implementation of the ClinicalInterfaceAccess interface to be a
 * stand-in for the real HealthDoc clinical interface for demo purposes.
 * Created by jdt on 4/21/17.
 */
public class ProxyServer implements ClinicalInterfaceAccess{

  /*
   * This represents the patient database. It is a map of patient ids to patient
    * records.
   */
  private HashMap<String, PatientRecord> patientRecordDatabase;

  /*
  * This is a map of doctor ids to lists of patient ids
   */
  private HashMap<String, PatientList> doctorPatientList;


  //Demo data structures.
  private String demoDoctor = "0001";
  private ArrayList<String> patientIDs;

  public ProxyServer(){
    patientRecordDatabase = new HashMap<>();
    doctorPatientList = new HashMap<>();
    patientIDs = new ArrayList<>();
    populateDemoServer();
  }

  public void populateDemoServer(){
    populateDoctorPatientList();
    populatePatientRecords();
  }

  /**
   * Get the requested data from the server.
   * @param request A data request object to be packaged and sent to the server.
   * @return The requested data if this is a valid request.
   */
  public RequestedData sendDataRequest(DataRequest request){
    DataRequest.RequestType rType = request.getType();
    simulatedDataRequest(rType);
    switch(rType){
      case PATIENT_LIST:
        return getListForDoctor(request.getKey());
      case PATIENT_RECORD:
        return getPatientRecord(request.getKey());
      default:
        return null;
    }
  }

  /**
   * Super realistic simulation of a data request to HealthDoc.
   * @param rType Type of request.
   */
  private void simulatedDataRequest(DataRequest.RequestType rType){
    System.out.println("Sending request for " + rType);
    System.out.println("Packaging with session info.");
    System.out.println("Encrypting.");
    System.out.println("Sending to server.");
    System.out.println("Awaiting response.");
    System.out.println("Decrypting and building RequestedData structure.");
  }

  /**
   * Get a patient list from the doctor patient list map
   * @param key String representing the doctor's id.
   * @return PatientList corresponding to the doctor identified with key.
   */
  private PatientList getListForDoctor(String key){
    if(doctorPatientList.containsKey(key)){
      return doctorPatientList.get(key);
    }
    else{
      return null;
    }
  }

  /**
   * Get a patient record.
   * @param key String representing the patient record we want.
   * @return PatientRecord corresponding to the patient id in key
   */
  private PatientRecord getPatientRecord(String key){
    if(patientRecordDatabase.containsKey(key)){
      return patientRecordDatabase.get(key);
    }
    else {
      return null;
    }
  }

  /**
   * Demo server population stuff.
   */
  private void populateDoctorPatientList(){
    patientIDs.add("0001");
    patientIDs.add("0002");
    patientIDs.add("0003");
    patientIDs.add("0004");

    doctorPatientList.put(demoDoctor, new PatientList(patientIDs));
  }

  /**
   * Make PatientRecords and populate "Database"
   */
  private void populatePatientRecords(){
    PatientRecord p1 = new PatientRecord(patientIDs.get(0),
      "A. One", "04/15/1981");
    patientRecordDatabase.put(patientIDs.get(0), p1);

    PatientRecord p2 = new PatientRecord(patientIDs.get(1),
      "B. Two", "02/29/1977");
    patientRecordDatabase.put(patientIDs.get(1), p2);

    PatientRecord p3 = new PatientRecord(patientIDs.get(2),
      "C. Three", "04/22/2017");
    patientRecordDatabase.put(patientIDs.get(2), p3);

    PatientRecord p4 = new PatientRecord(patientIDs.get(3),
      "D. Four", "12/31/1999");
    patientRecordDatabase.put(patientIDs.get(3), p4);
  }
}
