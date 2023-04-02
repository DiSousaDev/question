package br.dev.diego.question.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/professors")
public class ProfessorController {

    @GetMapping
    public ResponseEntity<?> teste() {
        return ResponseEntity.ok().body("Teste");
    }

}
