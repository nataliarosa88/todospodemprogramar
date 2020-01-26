package br.com.todospodemprogramar.app.exception;

public class InvalidFieldException extends ServiceException {
    public InvalidFieldException(String message) {
        super(message);
    }
}
