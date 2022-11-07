package br.com.goqueiroz.hroauth.clients;

import br.com.goqueiroz.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
//Name - nome do micro serviço ao qual este vai querer se comunicar
@FeignClient(name = "hr-user", path = "/users")
public interface UserClient {

    @GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam("email") String email);
}
