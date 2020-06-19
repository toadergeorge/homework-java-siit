package homework.tema12.exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException(Exception e) {
        super(e);
    }

    public DatabaseException(String message) {
        super(message);
    }
}
