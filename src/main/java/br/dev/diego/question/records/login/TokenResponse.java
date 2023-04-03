package br.dev.diego.question.records.login;

import java.time.Instant;

public record TokenResponse(String token, Instant expiration) {
}
