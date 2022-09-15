package br.com.goqueiroz.hrpayroll.controller;

import br.com.goqueiroz.hrpayroll.entities.Payment;
import br.com.goqueiroz.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment responsePayment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(responsePayment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = new Payment("Fail", 0.00, 0);
        return ResponseEntity.ok(payment);
    }
}
