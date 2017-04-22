package healthdocHI.clinicalinterface.humanInterfaceMessages;

/**
 * A data request from the server.
 * Created by jdt on 4/21/17.
 */
public class DataRequest {
  public enum RequestType{
    PATIENT_LIST,
    PATIENT_RECORD;
  }

  private String key;
  private RequestType type;

  public DataRequest(RequestType type, String key){
    this.key = key;
    this.type = type;
  }

  public RequestType getType(){
    return type;
  }

  public String getKey(){
    return key;
  }
}
