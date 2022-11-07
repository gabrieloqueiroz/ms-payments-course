package br.com.goqueiroz.hruser.repositories;

import br.com.goqueiroz.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}