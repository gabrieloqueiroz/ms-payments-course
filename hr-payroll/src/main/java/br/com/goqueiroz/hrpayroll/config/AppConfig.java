package br.com.goqueiroz.hrpayroll.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class AppConfig {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
