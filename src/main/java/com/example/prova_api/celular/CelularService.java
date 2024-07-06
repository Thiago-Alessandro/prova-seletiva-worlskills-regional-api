package com.example.prova_api.celular;

import com.example.prova_api.comentario.Comentario;
import com.example.prova_api.usuariocelular.UsuarioCelular;
import com.example.prova_api.usuariocelular.UsuarioCelularRepository;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
@CrossOrigin
public class CelularService {

    private final CelularRepository repository;
    private final UsuarioCelularRepository usuarioCelularRepository;

    public Celular findByDescricao(String desricao){
        return repository.findByDescricao(desricao);
    }

    public Collection<Celular> getAll(){
        return repository.findAll();
    }

    public Celular patchLiked(Long id, Long userId){
        Celular celular = repository.findById(id).get();
        Optional<UsuarioCelular> optional  =celular.getUsuarioCelularList().stream()
                .filter(cell -> cell.getUser().getId().equals(userId)).findFirst();
        UsuarioCelular usuarioCelular;
        if(optional.isPresent()){
            usuarioCelular = optional.get();
        } else {
            usuarioCelular = new UsuarioCelular(id, userId);
        }
        if(usuarioCelular.isLiked()){
            celular.setLikes(celular.getLikes()-1);
            usuarioCelular.setLiked(false);
        }
        celular.setLikes(celular.getLikes()+1);
        usuarioCelular.setLiked(true);

        usuarioCelularRepository.save(usuarioCelular);
        celular = repository.save(celular);
        return celular;
    }

    public Celular patchDisliked(Long id, Long userId){
        Celular celular = repository.findById(id).get();

        UsuarioCelular usuarioCelular;

        Optional<UsuarioCelular> optional  = celular.getUsuarioCelularList().stream()
                .filter(cell -> cell.getUser().getId().equals(userId)).findFirst();

        if(optional.isPresent()){
            usuarioCelular = optional.get();
        } else {
            usuarioCelular = new UsuarioCelular(id, userId);
        }

        if(usuarioCelular.isDisliked()){
            celular.setLikes(celular.getDislikes()-1);
            usuarioCelular.setDisliked(false);
        }
        celular.setLikes(celular.getDislikes()+1);
        usuarioCelular.setDisliked(true);

        usuarioCelularRepository.save(usuarioCelular);
        celular = repository.save(celular);
        return celular;
    }


}
