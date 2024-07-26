package me.lucasggmoreira.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException{
    private final String message;

    public ProdutoNaoEncontradoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
