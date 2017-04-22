package healthdocHI.clinicalinterface;

import healthdocHI.clinicalinterface.humanInterfaceMessages.DataRequest;
import healthdocHI.clinicalinterface.humanInterfaceMessages.RequestedData;

/**
 * This is an implementation of the ClinicalInterfaceAccess interface to be a
 * stand-in for the real HealthDoc clinical interface for demo purposes.
 * Created by jdt on 4/21/17.
 */
public class ProxyServer implements ClinicalInterfaceAccess{

  /**
   * Get the requested data from the server.
   * @param request A data request object to be packaged and sent to the server.
   * @return The requested data if this is a valid request.
   */
  public RequestedData sendDataRequest(DataRequest request){
    return null;
  }
}
