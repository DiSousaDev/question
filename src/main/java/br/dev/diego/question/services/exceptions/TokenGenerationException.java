package br.dev.diego.question.services.exceptions;

public class TokenGenerationException extends RuntimeException {

    public TokenGenerationException(String message) {
        super(message);
    }
}
