package com.rlink.payments.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonToPersonTransferDTO extends PaymentDTO {

    @NotBlank(message = "Field senderId cannot be empty or null.")
    private String senderId;
    @NotBlank(message = "Field recipientId cannot be empty or null.")
    private String recipientId;
    private String note;

    @Override
    public String getPaymentType() {
        return "PersonToPersonTransfer";
    }
}
