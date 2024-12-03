package com.tfg.tfg.service.paymentplan.impl;

import com.tfg.tfg.model.PaymentPlan;
import com.tfg.tfg.repository.PaymentPlanRepository;
import com.tfg.tfg.service.paymentplan.PaymentPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentPlanServiceImpl implements PaymentPlanService {

    private final PaymentPlanRepository paymentPlanRepository;


    @Override
    public List<PaymentPlan> findAll() {
        return paymentPlanRepository.findAll();
    }

    @Override
    public Optional<PaymentPlan> findById(Long id) {
        Optional<PaymentPlan> paymentPlan = paymentPlanRepository.findById(id);
        if (paymentPlan.isPresent()) {
            return paymentPlan;
        }else {
            throw new UsernameNotFoundException("PaymentPlan not found");
        }
    }

    @Override
    public Optional<PaymentPlan> findByName(String name) {
        Optional<PaymentPlan> paymentPlan = paymentPlanRepository.findByName(name);
        if (paymentPlan.isPresent()) {
            return paymentPlan;
        }else {
            throw new UsernameNotFoundException("PaymentPlan not found");
        }
    }

    @Override
    public PaymentPlan save(PaymentPlan paymentPlan) {
        return paymentPlanRepository.save(paymentPlan);
    }

    @Override
    public PaymentPlan update(PaymentPlan paymentPlan) {
        Optional<PaymentPlan> paymentPlanOptional = paymentPlanRepository.findById(paymentPlan.getId());
        if (paymentPlanOptional.isPresent()) {
            PaymentPlan paymentPlanUpdate = paymentPlanOptional.get();
            paymentPlanUpdate.setPaymentType(paymentPlan.getPaymentType());
            paymentPlanUpdate.setPrice(paymentPlan.getPrice());
            return paymentPlanRepository.save(paymentPlanUpdate);
        }else {
            throw new UsernameNotFoundException("PaymentPlan not found");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<PaymentPlan> paymentPlan = paymentPlanRepository.findById(id);
        if (paymentPlan.isPresent()) {
            paymentPlanRepository.delete(paymentPlan.get());
        }else {
            throw new UsernameNotFoundException("PaymentPlan not found");
        }
    }
}
