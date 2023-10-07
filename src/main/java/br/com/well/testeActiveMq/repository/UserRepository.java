package br.com.well.testeActiveMq.repository;

import br.com.well.testeActiveMq.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
