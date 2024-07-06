package com.example.prova_api.celular;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/celular")
@AllArgsConstructor
@CrossOrigin
public class CelularController {

    private final CelularService service;

    @GetMapping
    public Collection<Celular> getAll(){
        return service.getAll();
    }

    @PatchMapping("/like/cellId/{id}/user/{userId}")
    public Celular patchLiked(@PathVariable Long id, @PathVariable Long userId){
        return service.patchLiked(id, userId);
    }

    @PatchMapping("/dislike/cellId/{id}/user/{userId}")
    public Celular patchDisliked(@PathVariable Long id, @PathVariable Long userId){
        return service.patchDisliked(id, userId);
    }

}
