package com.payment_service.paymente_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        boolean success = paymentService.processPayment(
                paymentRequest.getCardNumber(),
                paymentRequest.getCvv(),
                paymentRequest.getExpiryDate(),
                paymentRequest.getAmount()
        );

        if (success) {
            return ResponseEntity.ok("Pago procesado con éxito.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fallo al procesar el pago.");
        }
    }
}
