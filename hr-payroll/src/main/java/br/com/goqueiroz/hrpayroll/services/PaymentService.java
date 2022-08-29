package br.com.goqueiroz.hrpayroll.services;

import br.com.goqueiroz.hrpayroll.config.AppConfig;
import br.com.goqueiroz.hrpayroll.entities.Payment;
import br.com.goqueiroz.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

  private RestTemplate restTemplate;
  private AppConfig config;


  @Autowired
  public PaymentService(RestTemplate restTemplate, AppConfig config) {
    this.restTemplate = restTemplate;
    this.config = config;
  }

  public Payment getPayment(Long workerId, int days){
    Map<String, String> uriVariable = new HashMap<>();
    uriVariable.put("id", workerId.toString());

    Worker worker = restTemplate.getForObject(config.getWorkerHost() + "/workers/{id}", Worker.class, uriVariable);

    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}
