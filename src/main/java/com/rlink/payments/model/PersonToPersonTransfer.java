package com.rlink.payments.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonToPersonTransfer extends Payment {

    @Column(name = "transfer_id")
    private String transferId;
    @Column(name = "sender_id")
    private String senderId;
    @Column(name = "recipient_id")
    private String recipientId;
    private String note;

    @Override
    public String getPaymentType() {
        return "PersonToPersonTransfer";
    }

}
