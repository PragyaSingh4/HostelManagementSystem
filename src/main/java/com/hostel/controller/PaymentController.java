
package com.hostel.controller;

import com.hostel.entity.Payment;
import com.hostel.service.PaymentService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id).orElseThrow();
    }

    // Add payment
    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    // Update payment
    @PutMapping("/{id}")
    public Payment updatePayment(
            @PathVariable Integer id,
            @RequestBody Payment payment) {

        return paymentService.updatePayment(id, payment);
    }

    // Delete payment
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Integer id) {

        paymentService.deletePayment(id);

        return "Payment deleted successfully!";
    }
}
