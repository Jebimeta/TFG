package com.tfg.tfg.service.payment;

import com.tfg.tfg.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> findAll();

    Optional<Payment> findByPaymentMethod(String paymentMethod);

    Payment findByDate(String date);

    Payment findByUser(Long userId);

    Payment findById(Long id);

    Payment save(Payment payment);

    Payment update(Payment payment);

    void delete(Long id);


}
