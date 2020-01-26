package br.com.todospodemprogramar.app.exception;

public class EntityNotFoundException extends ServiceException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
