package com.tfg.tfg.service.payment.impl;

import com.tfg.tfg.model.Payment;
import com.tfg.tfg.repository.PaymentRepository;
import com.tfg.tfg.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;


    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findByPaymentMethod(String paymentMethod) {
        Optional<Payment> payment = paymentRepository.findByPaymentMethod(paymentMethod);
        if (payment.isPresent()) {
            return payment;
        }else {
            throw new UsernameNotFoundException("Payment not found");
        }
    }

    @Override
    public Payment findByDate(String date) {
        Optional<Payment> payment = paymentRepository.findByDate(date);
        if (payment.isPresent()) {
            return payment.get();
        }else {
            throw new UsernameNotFoundException("Payment not found");
        }
    }

    @Override
    public Payment findByUser(Long userId) {
        Optional<Payment> payment = paymentRepository.findByUser(userId);
        if (payment.isPresent()) {
            return payment.get();
        }else {
            throw new UsernameNotFoundException("Payment not found");
        }
    }

    @Override
    public Payment findById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
            return payment.get();
        }else {
            throw new UsernameNotFoundException("Payment not found");
        }
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Payment payment) {
        Optional<Payment> paymentOptional = paymentRepository.findById(payment.getId());
        if (paymentOptional.isPresent()) {
            Payment paymentToUpdate = paymentOptional.get();
            paymentToUpdate.setUser(payment.getUser());
            paymentToUpdate.setPaymentDate(payment.getPaymentDate());
            paymentToUpdate.setPaymentPlan(payment.getPaymentPlan());
            paymentToUpdate.setAmount(payment.getAmount());
            return paymentRepository.save(paymentToUpdate);
        }else {
            throw new UsernameNotFoundException("Payment not found");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
            paymentRepository.delete(payment.get());
        }else {
            throw new UsernameNotFoundException("Payment not found");
        }
    }
}
