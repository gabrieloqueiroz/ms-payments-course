package br.com.goqueiroz.hrpayroll.services;

import br.com.goqueiroz.hrpayroll.clients.WorkerClients;
import br.com.goqueiroz.hrpayroll.config.AppConfig;
import br.com.goqueiroz.hrpayroll.entities.Payment;
import br.com.goqueiroz.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
  private WorkerClients workerClients;

  @Autowired
  public PaymentService(WorkerClients workerClients) {
    this.workerClients = workerClients;
  }

  public Payment getPayment(Long workerId, int days){
    Worker worker = workerClients.findById(workerId).getBody();

    return new Payment(worker.getName(), worker.getDailyIncome(), days);
  }
}
