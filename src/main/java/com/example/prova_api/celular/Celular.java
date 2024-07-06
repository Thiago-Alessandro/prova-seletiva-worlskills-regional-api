package com.example.prova_api.celular;

import com.example.prova_api.comentario.Comentario;
import com.example.prova_api.usuariocelular.UsuarioCelular;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Celular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String imagem;
    private Long likes;
    private Long dislikes;

    @OneToMany(mappedBy = "celular")
    private Collection<UsuarioCelular> usuarioCelularList;

    @OneToMany(mappedBy = "celular")
    private Collection<Comentario> comentarios;

}
