package br.dev.diego.question.services.impl.auth;


import br.dev.diego.question.entities.User;
import br.dev.diego.question.records.login.TokenInfo;
import br.dev.diego.question.records.login.TokenResponse;
import br.dev.diego.question.services.TokenService;
import br.dev.diego.question.services.exceptions.TokenGenerationException;
import br.dev.diego.question.services.exceptions.TokenVerifyException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${security.token.secret}")
    private String secret;
    @Value("${security.token.issuer}")
    private String issuer;
    @Value("${security.token.expiration-minutes}")
    private long expirationMinutes;

    public TokenServiceImpl() {
        // Springboot need this
    }

    @Override
    public TokenResponse gerarToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return new TokenResponse(JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId())
                    .withExpiresAt(getExpirationTime())
                    .sign(algorithm), getExpirationTime());
        } catch (JWTCreationException e) {
            throw new TokenGenerationException("Erro ao gerar token JWT, " + e.getMessage());
        }
    }

    @Override
    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new TokenVerifyException("Token JTW inválido ou expirado, " + e.getMessage());
        }
    }

    private Instant getExpirationTime() {
        return LocalDateTime.now().plusMinutes(expirationMinutes).toInstant(ZoneOffset.of("-03:00"));
    }

}
