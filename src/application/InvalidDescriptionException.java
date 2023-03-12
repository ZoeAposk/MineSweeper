package application;

@SuppressWarnings("serial")
public class InvalidDescriptionException extends Exception {
    String mes;
    public InvalidDescriptionException(String mes){
        this.mes=mes;
        
    }
}