package com.rlink.payments.controller;

import com.rlink.payments.dto.PaymentDTO;
import com.rlink.payments.mapper.PaymentMapper;
import com.rlink.payments.model.Payment;
import com.rlink.payments.service.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;


    @PostMapping("/create")
    public  ResponseEntity<PaymentDTO> createPayment(@Valid @RequestBody PaymentDTO payment) {
        Payment p = PaymentMapper.toEntity(payment);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PaymentMapper.toDTO(paymentService.createPayment(Objects.requireNonNull(p))));
    }

    @GetMapping("/{id}/status")
    public Optional<Payment> getPaymentStatus(@PathVariable String id) {
        return paymentService.getPaymentStatus(id);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getUserPayments(
            @PathVariable String userId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String sortBy) {
        return paymentService.getUserPayments(userId);
    }


}

