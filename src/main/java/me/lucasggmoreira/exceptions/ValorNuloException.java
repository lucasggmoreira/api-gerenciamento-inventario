package me.lucasggmoreira.exceptions;

public class ValorNuloException extends RuntimeException{
    private final String message;

    public ValorNuloException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
