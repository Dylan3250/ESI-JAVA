package esi.atl.g54027.repository.exception;

public class RepositoryException extends Exception {

    public RepositoryException() {
        super();
    }

    public RepositoryException(String errorMessage) {
        super(errorMessage);
    }

    public RepositoryException(Exception exception) {
        super(exception);
    }
}
