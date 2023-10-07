package br.com.well.testeActiveMq.controller;

import br.com.well.testeActiveMq.dto.AutenticationDTO;
import br.com.well.testeActiveMq.model.User;
import br.com.well.testeActiveMq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;




    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AutenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity registrar(@RequestBody RegisterDTO registerDTO) {
        if(repository.findByLogin(registerDTO.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(registerDTO.login(), registerDTO.password(), registerDTO.status());
        repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
