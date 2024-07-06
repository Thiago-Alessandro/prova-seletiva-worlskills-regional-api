package com.example.prova_api.comentario;

import com.example.prova_api.celular.Celular;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/celular/comentario")
@RestController
@AllArgsConstructor
@CrossOrigin
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping()
    public Celular postComment(@RequestBody Comentario comentario){
        return comentarioService.postComment(comentario);
    }

}
