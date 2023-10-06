package br.com.uepg.sistemapacientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class cRoupa extends cRecurso {

    @Column(nullable = false)
    private int kit;
}
