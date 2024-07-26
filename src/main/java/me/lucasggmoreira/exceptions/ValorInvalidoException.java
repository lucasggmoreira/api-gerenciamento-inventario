package me.lucasggmoreira.exceptions;

public class ValorInvalidoException extends RuntimeException{
    private final String message;

    public ValorInvalidoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
