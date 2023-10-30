package com.david.spring_angular.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface TransactionsSumDetails {

    LocalDate getTransactionDate();

    BigDecimal getAmount();
}
