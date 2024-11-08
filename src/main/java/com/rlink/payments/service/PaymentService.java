package com.rlink.payments.service;

import com.fasterxml.uuid.Generators;
import com.rlink.payments.model.Payment;
import com.rlink.payments.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    private static final ZoneId ZONE_ID = ZoneId.of("America/Argentina/Buenos_Aires");

    @Transactional
    public Payment createPayment(@NotNull Payment payment) {
        ZonedDateTime zonedBuenosAires = ZonedDateTime.now(ZONE_ID);
        // Idempotency check
        Optional<Payment> existingPayment = paymentRepository.findPaymentDuplicate(zonedBuenosAires.minusMinutes(2).toLocalDateTime(), payment.getAmount().toString(), payment.getCurrency(), payment.getUserId());
        if (existingPayment.isPresent()) {
            return existingPayment.get();
        }
        payment.setId(String.valueOf(Generators.timeBasedGenerator().generate()));
        payment.setStatus("PENDING");
        payment.setCreatedAt(zonedBuenosAires.toLocalDateTime());
        paymentRepository.save(payment);

        // Simulate transaction processing
        processTransaction(payment);

        return paymentRepository.save(payment);
    }

    private void processTransaction(Payment payment) {
        try {
            payment.setStatus("COMPLETED");
        } catch (Exception e) {
            payment.setStatus("FAILED");
            compensatePayment(payment);
        }
    }

    private void compensatePayment(Payment payment) {
        payment.setStatus("COMPENSATED");
        paymentRepository.save(payment);
    }

    @Transactional
    public Optional<Payment> getPaymentStatus(String id) {
        return paymentRepository.findById(id);
    }

    @Transactional
    public List<Payment> getUserPayments(String userId) {
        return paymentRepository.findByUserId(userId);
    }
}

