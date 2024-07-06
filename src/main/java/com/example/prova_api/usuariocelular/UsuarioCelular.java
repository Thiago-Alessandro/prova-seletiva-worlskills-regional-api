package com.example.prova_api.usuariocelular;

import com.example.prova_api.celular.Celular;
import com.example.prova_api.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@IdClass(UsuarioCelularId.class)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCelular {

    @Id
    private Long userId;
    @Id
    private Long celularId;

    @ManyToOne()
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "celularId", insertable = false, updatable = false)
    @JsonIgnore
    private Celular celular;

    private boolean liked = false;
    private boolean disliked = false;

    public UsuarioCelular (Long cellId, Long userId){
        this.celularId = cellId;
        this.userId = userId;
    }

}
