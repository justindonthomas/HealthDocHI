package healthdocHI.clinicalinterface.humanInterfaceMessages;

/**
 * This class is a record field containing information about a field in the patient
 * record for display.
 * Created by jdt on 4/21/17.
 */
public class RecordField {
  private String label;
  private String text;
  private boolean writable;

  public RecordField(String label, boolean writable){
    this.label = label;
    this.writable = writable;
  }

  public RecordField(String label, String text, boolean writable){
    this.label = label;
    this.text = text;
    this.writable = writable;
  }

  /**
   * Returns a copy (not a reference) of the label string.
   * @return Copy of the label string.
   */
  public String label(){
    return new String(label);
  }

  /**
   * Returns a copy (not a reference) of the text String.
   * @return Copy of text string.
   */
  public String text(){
    return new String(text);
  }

  /**
   * Is the text field writable?
   * @return True if the text field is writable.
   */
  public boolean writable(){
    return writable;
  }

  /**
   * Replace the text field of this record. Checks to see if this is a writable
   * record.
   * @param str Text to replace the old text field.
   */
  public void updateData(String str){
    if(writable){
      text = str;
    }
  }

  public RecordField makeDuplicate(){
    return new RecordField(label, text, writable);
  }
}
