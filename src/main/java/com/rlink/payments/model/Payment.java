package com.rlink.payments.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

    @Id
    private String id;
    @Column(name = "user_id")
    private String userId;
    private BigDecimal amount;
    private String currency;
    private String status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public abstract String getPaymentType();
}