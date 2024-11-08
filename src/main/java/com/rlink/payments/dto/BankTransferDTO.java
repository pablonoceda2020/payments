package com.rlink.payments.dto;

import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankTransferDTO extends PaymentDTO {

    private String bankCode;
    private String recipientAccount;

    @Override
    public String getPaymentType() {
        return "BankTransfer";
    }
}
