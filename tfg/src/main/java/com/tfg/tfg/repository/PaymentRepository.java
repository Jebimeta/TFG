package com.tfg.tfg.repository;

import com.tfg.tfg.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByPaymentMethod(String paymentMethod);

    Optional<Payment> findByDate(String date);

    Optional<Payment> findByUser(Long userId);
}
