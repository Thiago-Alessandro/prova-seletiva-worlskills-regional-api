package com.example.prova_api.comentario;

import com.example.prova_api.celular.Celular;
import com.example.prova_api.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Celular celular;
    @ManyToOne
    private User usuario;
    private String conteudo;
    private LocalDateTime dataHora;

}
