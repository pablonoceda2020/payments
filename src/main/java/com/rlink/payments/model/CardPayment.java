package com.rlink.payments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CardPayment extends Payment {

    @Column(name = "payment_id")
    private String paymentId;
    private String cardId;
    @Column(name = "mcc_code")
    private int mccCode;
    @Embedded
    private Merchant merchant;

    @Override
    public String getPaymentType() {
        return "CardPayment";
    }

}
