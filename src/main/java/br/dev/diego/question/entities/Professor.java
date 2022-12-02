package br.dev.diego.question.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Professor extends AbstractEntity {

    @NotEmpty(message = "The field name cannot be empty")
    private String name;
    @NotEmpty(message = "The field email cannot be empty")
    @Email(message = "This email is not valid")
    @Column(unique = true)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
