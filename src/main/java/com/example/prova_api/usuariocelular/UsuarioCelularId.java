package com.example.prova_api.usuariocelular;

import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCelularId implements Serializable {

    private Long userId;
    private Long celularId;

}
