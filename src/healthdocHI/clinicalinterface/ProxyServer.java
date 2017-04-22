package healthdocHI.clinicalinterface;

import healthdocHI.clinicalinterface.humanInterfaceMessages.DataRequest;
import healthdocHI.clinicalinterface.humanInterfaceMessages.PatientList;
import healthdocHI.clinicalinterface.humanInterfaceMessages.PatientRecord;
import healthdocHI.clinicalinterface.humanInterfaceMessages.RequestedData;

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

  public ProxyServer(){
    patientRecordDatabase = new HashMap<>();
    doctorPatientList = new HashMap<>();
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
}
