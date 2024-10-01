package com.payment_service.paymente_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessPayment_success() {
        boolean result = paymentService.processPayment("1234567812345678", "123", "12/25", 100.0);
        assertTrue(result, "El pago debería procesarse correctamente.");
    }

    @Test
    public void testProcessPayment_invalidCardNumber() {
        boolean result = paymentService.processPayment("123", "123", "12/25", 100.0);
        assertFalse(result, "El pago debería fallar debido a un número de tarjeta inválido.");
    }

    @Test
    public void testProcessPayment_invalidExpiryDate() {
        boolean result = paymentService.processPayment("1234567812345678", "123", "13/25", 100.0);
        assertFalse(result, "El pago debería fallar debido a una fecha de expiración inválida.");
    }
}
