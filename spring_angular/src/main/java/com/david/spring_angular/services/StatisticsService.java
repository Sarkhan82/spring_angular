package com.david.spring_angular.services;

import com.david.spring_angular.dto.TransactionsSumDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface StatisticsService {
    List<TransactionsSumDetails> findSumTransactionByDate(LocalDate startDate, LocalDate endDate, Integer userId);
    BigDecimal getAccountBalance(Integer userId);
    BigDecimal highestTransfert(Integer userId);
    BigDecimal highestDeposit(Integer userId);
}
