package br.dev.diego.question.services.exceptions;

public class TokenVerifyException extends RuntimeException {

    public TokenVerifyException(String message) {
        super(message);
    }
}
