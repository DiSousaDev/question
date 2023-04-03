package br.dev.diego.question.services;

import br.dev.diego.question.entities.User;
import br.dev.diego.question.records.login.TokenInfo;
import br.dev.diego.question.records.login.TokenResponse;

public interface TokenService {

    TokenResponse gerarToken(User user);

    String getSubject(String token);
}
