package com.tfg.tfg.service.paymentplan;

import com.tfg.tfg.model.PaymentPlan;

import java.util.List;
import java.util.Optional;

public interface PaymentPlanService {

    List<PaymentPlan> findAll();

    Optional<PaymentPlan> findById(Long id);

    Optional<PaymentPlan> findByName(String name);

    PaymentPlan save(PaymentPlan paymentPlan);

    PaymentPlan update(PaymentPlan paymentPlan);

    void delete(Long id);
}
