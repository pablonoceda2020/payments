package com.rlink.payments.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

  PAYMENT_NOT_FOUND("ERR_PAYMENT_001", "Payment not found."),
  INVALID_PAYMENT("ERR_PAYMENT_002", "Invalid Payment parameters."),
  PAYMENT_DUPLICATE("ERR_PAYMENT_003", "Payment duplicate."),
  GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");

  private final String code;
  private final String message;

  ErrorCatalog(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
