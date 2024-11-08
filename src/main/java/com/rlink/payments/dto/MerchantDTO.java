package com.rlink.payments.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO {

    private String merchantId;
    private String name;

}
