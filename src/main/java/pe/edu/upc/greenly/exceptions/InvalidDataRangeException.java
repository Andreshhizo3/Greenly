package pe.edu.upc.greenly.exceptions;

public class InvalidDataRangeException extends RuntimeException {
    public InvalidDataRangeException(String message) { super(message); }
    public InvalidDataRangeException() { super(); }
}
