package com.rlink.payments.mapper;

import com.rlink.payments.dto.*;
import com.rlink.payments.model.*;
import org.springframework.stereotype.Component;


@Component
public class PaymentMapper {

    public static PaymentDTO toDTO(Payment payment) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            CardPaymentDTO dto = new CardPaymentDTO();
            dto.setCardId(cardPayment.getCardId());
            dto.setMccCode(cardPayment.getMccCode());
            dto.setMerchant(toDTO(cardPayment.getMerchant()));
            copyCommonFields(payment, dto);
            return dto;
        } else if (payment instanceof BankTransfer) {
            BankTransfer bankTransfer = (BankTransfer) payment;
            BankTransferDTO dto = new BankTransferDTO();
            dto.setBankCode(bankTransfer.getBankCode());
            dto.setRecipientAccount(bankTransfer.getRecipientAccount());
            copyCommonFields(payment, dto);
            return dto;
        } else if (payment instanceof PersonToPersonTransfer) {
            PersonToPersonTransfer personTransfer = (PersonToPersonTransfer) payment;
            PersonToPersonTransferDTO dto = new PersonToPersonTransferDTO();
            dto.setSenderId(personTransfer.getSenderId());
            dto.setRecipientId(personTransfer.getRecipientId());
            dto.setNote(personTransfer.getNote());
            copyCommonFields(payment, dto);
            return dto;
        }
        return null;
    }

    public static Payment toEntity(PaymentDTO dto) {
        if (dto instanceof CardPaymentDTO) {
            CardPaymentDTO cardDto = (CardPaymentDTO) dto;
            CardPayment payment = new CardPayment();
            payment.setCardId(cardDto.getCardId());
            payment.setMccCode(cardDto.getMccCode());
            payment.setMerchant(toEntity(cardDto.getMerchant()));
            copyCommonFieldsPayment(payment, dto);
            return payment;
        } else if (dto instanceof BankTransferDTO) {
            BankTransferDTO bankDto = (BankTransferDTO) dto;
            BankTransfer payment = new BankTransfer();
            payment.setBankCode(bankDto.getBankCode());
            payment.setRecipientAccount(bankDto.getRecipientAccount());
            copyCommonFieldsPayment(payment, dto);
            return payment;
        } else if (dto instanceof PersonToPersonTransferDTO) {
            PersonToPersonTransferDTO transferDto = (PersonToPersonTransferDTO) dto;
            PersonToPersonTransfer payment = new PersonToPersonTransfer();
            payment.setSenderId(transferDto.getSenderId());
            payment.setRecipientId(transferDto.getRecipientId());
            payment.setNote(transferDto.getNote());
            copyCommonFieldsPayment(payment, dto);
            return payment;
        }
        return null;
    }

    private static void copyCommonFields(Payment source, PaymentDTO target) {
        target.setId(source.getId());
        target.setUserId(source.getUserId());
        target.setAmount(source.getAmount());
        target.setCurrency(source.getCurrency());
        target.setStatus(source.getStatus());
        target.setCreatedAt(source.getCreatedAt());
    }

    private static void copyCommonFieldsPayment(Payment source, PaymentDTO target) {
        source.setUserId(target.getUserId());
        source.setAmount(target.getAmount());
        source.setCurrency(target.getCurrency());
    }


    private static MerchantDTO toDTO(Merchant merchant) {
        if (merchant == null) return null;
        MerchantDTO dto = new MerchantDTO();
        dto.setName(merchant.getName());
        dto.setMerchantId(merchant.getMerchantId());
        return dto;
    }

    private static Merchant toEntity(MerchantDTO dto) {
        if (dto == null) return null;
        Merchant merchant = new Merchant();
        merchant.setName(dto.getName());
        merchant.setMerchantId(dto.getMerchantId());
        return merchant;
    }
}
