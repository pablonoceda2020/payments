package com.rlink.payments.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardPaymentDTO extends PaymentDTO {

    private String cardId;
    private int mccCode;
    private MerchantDTO merchant;

    @Override
    public String getPaymentType() {
        return "CardPayment";
    }
}
