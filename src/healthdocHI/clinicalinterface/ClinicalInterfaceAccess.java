package healthdocHI.clinicalinterface;

import healthdocHI.clinicalinterface.humanInterfaceMessages.DataAlterations;
import healthdocHI.clinicalinterface.humanInterfaceMessages.DataRequest;
import healthdocHI.clinicalinterface.humanInterfaceMessages.RequestedData;
import healthdocHI.clinicalinterface.humanInterfaceMessages.UserAuthentication;

/**
 * Interface that the human interface will use to access the client side of the
 * clinical interface.
 * Created by jdt on 4/20/17.
 */
public interface ClinicalInterfaceAccess {
  //public void sendLoginRequest(UserAuthentication login);
  public RequestedData sendDataRequest(DataRequest request);
  //public void sendDataAlteration(DataAlterations changes);
}
