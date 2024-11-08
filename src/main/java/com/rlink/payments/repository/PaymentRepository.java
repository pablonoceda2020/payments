package com.rlink.payments.repository;

import com.rlink.payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findByUserId(String userId);

    @Query("SELECT e FROM Payment  e WHERE e.createdAt >= :createdAt AND e.amount = :amount AND e.currency = :currency AND e.userId = :userId AND e.status != 'FAILED'")
    Optional<Payment> findPaymentDuplicate(
            @Param("createdAt") LocalDateTime createdAt, @Param("amount") String amount, @Param("currency") String currency, @Param("userId") String userId);
}
