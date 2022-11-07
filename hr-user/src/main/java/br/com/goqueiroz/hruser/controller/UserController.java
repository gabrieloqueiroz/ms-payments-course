package br.com.goqueiroz.hruser.controller;

import br.com.goqueiroz.hruser.entities.User;
import br.com.goqueiroz.hruser.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

        @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){

        User user = userService.findByEmail(email);

        return ResponseEntity.ok(user);
    }
}

