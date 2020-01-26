package br.com.todospodemprogramar.app.exception;

import org.hibernate.service.spi.ServiceException;

public class DuplicatedKeyException extends ServiceException {
    public DuplicatedKeyException(String message) {
        super(message);
    }
}
