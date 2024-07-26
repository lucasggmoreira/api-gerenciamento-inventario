package me.lucasggmoreira.exceptions;

public class ProdutoExistenteException extends RuntimeException{
    private final String message;

    public ProdutoExistenteException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
