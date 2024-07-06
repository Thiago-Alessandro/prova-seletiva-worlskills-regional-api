package com.example.prova_api.comentario;

import com.example.prova_api.celular.Celular;
import com.example.prova_api.celular.CelularRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final CelularRepository celularRepository;

    public Celular postComment(Comentario comentario){
        comentarioRepository.save(comentario);
        return celularRepository.findById(comentario.getCelular().getId()).get();
    }

}
