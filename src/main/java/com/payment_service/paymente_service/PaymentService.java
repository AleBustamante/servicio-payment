package com.payment_service.paymente_service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean processPayment(String cardNumber, String cvv, String expiryDate, double amount) {
        if (validateCardDetails(cardNumber, cvv, expiryDate)) {
            System.out.println("Procesando el pago de: " + amount + " USD.");
            return true;
        } else {
            System.out.println("Falló la validación de los detalles de la tarjeta.");
            return false;
        }
    }

    private boolean validateCardDetails(String cardNumber, String cvv, String expiryDate) {
        return cardNumber.length() == 16 && cvv.length() == 3 && isExpiryDateValid(expiryDate);
    }

    private boolean isExpiryDateValid(String expiryDate) {
        if (expiryDate.matches("(0[1-9]|1[0-2])/([0-9]{2})")) {
            return true;
        }
        return false;
    }
}
