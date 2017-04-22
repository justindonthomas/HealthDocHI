package healthdocHI.clinicalinterface.humanInterfaceMessages;

import java.util.Date;
import java.util.HashMap;

/**
 * This is a record of a visit
 * Created by jdt on 4/21/17.
 */
public class VisitRecord {
  public enum Field{
    BLOOD_PRESSURE,
    TEMPERATURE,
    WEIGHT,
    OTHER,
    STAFF;
  }

  private Date date;

  private HashMap<Field, RecordField> visitData;

  /**
   * Get the date of the visit.
   * @return Date object, the date of the visit.
   */
  public Date getDate(){
    return date;
  }

  /**
   * Get a field from the Visit.
   * @param field Enum corresponding to the field we want to get.
   * @return Return size 3 array containing ["Label", "Text", "R/W"]
   */
  public RecordField get(Field field){
    if(visitData.containsKey(field)){
      return visitData.get(field);
    }
    else {
      return null;
    }
  }

  /**
   * Alter a string in the visit if it is writable.
   * @param field The field to edit the text of.
   * @param newString The new text.
   */
  public void put(Field field, String newString){
    if(visitData.containsKey(field)){
      RecordField fieldData = visitData.get(field);
      fieldData.updateData(newString);
    }
  }
}
