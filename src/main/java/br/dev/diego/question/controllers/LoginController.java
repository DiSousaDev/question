package br.dev.diego.question.controllers;

import br.dev.diego.question.entities.User;
import br.dev.diego.question.records.login.Login;
import br.dev.diego.question.records.login.TokenResponse;
import br.dev.diego.question.services.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public LoginController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenResponse> login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(login.login(), login.password());
        Authentication authenticate = authenticationManager.authenticate(auth);
        User user = (User) authenticate.getPrincipal();
        return ResponseEntity.ok(tokenService.gerarToken(user));
    }

}
