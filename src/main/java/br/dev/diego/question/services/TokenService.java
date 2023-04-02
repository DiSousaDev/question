package br.dev.diego.question.services;

import br.dev.diego.question.entities.User;
import br.dev.diego.question.records.login.TokenInfo;

public interface TokenService {

    TokenInfo gerarToken(User user);

    String getSubject(String token);
}
