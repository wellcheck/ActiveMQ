package br.com.well.testeActiveMq.repository;

import br.com.well.testeActiveMq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
