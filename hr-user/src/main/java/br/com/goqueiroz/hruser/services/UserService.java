package br.com.goqueiroz.hruser.services;

import br.com.goqueiroz.hruser.entities.User;
import br.com.goqueiroz.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id not found")
        );

        return user;
    }

    public User findByEmail(String email){
        User user = this.userRepository.findByEmail(email);

        return user;
    }
}
