package br.com.well.testeActiveMq.controller;

import br.com.well.testeActiveMq.dto.AutenticationDTO;
import br.com.well.testeActiveMq.dto.RegisterDTO;
import br.com.well.testeActiveMq.model.User;
import br.com.well.testeActiveMq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody AutenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = authenticationManager.authenticate(userNamePassword);
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody RegisterDTO registerDTO) {
        if(repository.findByLogin(registerDTO.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(registerDTO.login(), encryptedPassword, registerDTO.status());
        repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
