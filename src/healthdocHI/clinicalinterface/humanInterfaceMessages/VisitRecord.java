package healthdocHI.clinicalinterface.humanInterfaceMessages;

import java.util.GregorianCalendar;
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

  private GregorianCalendar date;

  private HashMap<Field, RecordField> visitData;

  public VisitRecord()
  {
    visitData = new HashMap<>();
    for (Field f: Field.values())
    {
      visitData.put(f, new RecordField(f.toString(), true));
    }
    date = new GregorianCalendar();
  }

  /**
   * Visit with specified date
   * @param year Year of visit
   * @param month Month of visit
   * @param day Day of visit.
   */
  public VisitRecord(int year, int month, int day){
    visitData = new HashMap<>();
    for (Field f: Field.values())
    {
      visitData.put(f, new RecordField(f.toString(), true));
    }
    date = new GregorianCalendar(year, month, day);
  }
  
  /**
   * Get the date of the visit.
   * @return Date object, the date of the visit.
   */
  public GregorianCalendar getDate(){
    return date;
  }

  /**
   * Get a field from the Visit.
   * @param field Enum corresponding to the field we want to get.
   * @return Return VisitRecord object
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
