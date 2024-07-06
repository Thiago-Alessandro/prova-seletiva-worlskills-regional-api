package com.example.prova_api.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody LoginDTO loginDTO){
        return userService.login(loginDTO);
    }

    @GetMapping("/email/{email}")
    public User findByemail(@PathVariable String email){
        return userService.findByEmail(email);
    }

}
