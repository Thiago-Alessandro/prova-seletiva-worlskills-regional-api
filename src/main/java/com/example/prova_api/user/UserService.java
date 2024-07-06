package com.example.prova_api.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User login(LoginDTO loginDTO){
        return repository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
    }

    public User findByEmail(String email){
        return repository.findByEmail(email);
    }

}
