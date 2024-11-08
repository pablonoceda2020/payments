package com.rlink.payments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankTransfer extends Payment {

    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "bank_code")
    private String bankCode;
    @Column(name = "recipient_account")
    private String recipientAccount;

    @Override
    public String getPaymentType() {
        return "BankTransfer";
    }
}
