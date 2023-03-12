package application;

@SuppressWarnings("serial")
public class InvalidValueException extends Exception {
    String mes;
    public InvalidValueException(String mes){
        this.mes=mes;
    }
}