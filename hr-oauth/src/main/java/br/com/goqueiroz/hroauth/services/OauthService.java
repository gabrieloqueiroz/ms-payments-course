package br.com.goqueiroz.hroauth.services;

import br.com.goqueiroz.hroauth.clients.UserClient;
import br.com.goqueiroz.hroauth.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static br.com.goqueiroz.hroauth.utils.LoggerUtil.error;
import static br.com.goqueiroz.hroauth.utils.LoggerUtil.info;

@Service
public class OauthService {

    private UserClient userClient;

    @Autowired
    public OauthService(UserClient userClient) {
        this.userClient = userClient;
    }

    public User findByEmail(String email){
        User user = userClient.findByEmail(email).getBody();

        if (Objects.isNull(user)){
            error(this.getClass(), "Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        info(this.getClass(), "Email found: " + email);
        return user;
    }
}
