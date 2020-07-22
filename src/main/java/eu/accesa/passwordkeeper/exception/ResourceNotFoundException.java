package eu.accesa.passwordkeeper.exception;

public class ResourceNotFoundException extends RuntimeException{

    private final String errorCode;

    public ResourceNotFoundException(String errorCode, String applicationName) {
        super("Application not found for name: " + applicationName);
        this.errorCode = errorCode;
    }
}
