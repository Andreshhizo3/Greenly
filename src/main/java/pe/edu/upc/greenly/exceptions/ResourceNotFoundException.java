package pe.edu.upc.greenly.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() { super(); }
    public ResourceNotFoundException(String message) { super(message); }

}
