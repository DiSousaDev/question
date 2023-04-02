package br.dev.diego.question.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ApplicationUser extends AbstractEntity {

    @NotEmpty(message = "The field username cannot be empty")
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "The field username cannot be empty")
    private String password;
    @OneToOne
    private Professor professor;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
