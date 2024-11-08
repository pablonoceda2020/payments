package com.rlink.payments.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "paymentType")
@JsonSubTypes({@JsonSubTypes.Type(value = CardPaymentDTO.class, name = "CardPayment"), @JsonSubTypes.Type(value = BankTransferDTO.class, name = "BankTransfer"), @JsonSubTypes.Type(value = PersonToPersonTransferDTO.class, name = "PersonToPersonTransfer")})
public abstract class PaymentDTO implements Serializable {

    private String id;
    @NotBlank(message = "Field userId cannot be empty or null.")
    private String userId;
    private BigDecimal amount;
    @NotBlank(message = "Field currency cannot be empty or null.")
    private String currency;
    private String status;
    private LocalDateTime createdAt;

    public PaymentDTO() {
    }

    public PaymentDTO(String id, String userId, BigDecimal amount, String currency, String status, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.createdAt = createdAt;
    }

    public abstract String getPaymentType();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
