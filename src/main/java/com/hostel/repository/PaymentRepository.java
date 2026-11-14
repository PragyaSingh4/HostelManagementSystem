package com.hostel.repository;

import java.util.List;
import com.hostel.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByPaymentStatus(String paymentStatus);
}
