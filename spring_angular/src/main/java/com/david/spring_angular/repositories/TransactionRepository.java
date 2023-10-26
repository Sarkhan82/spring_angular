package com.david.spring_angular.repositories;

import com.david.spring_angular.dto.TransactionDto;
import com.david.spring_angular.models.Transaction;
import com.david.spring_angular.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByUserId(Integer userId);

    @Query("select sum(t.amount) from Transaction t where t.user.id = :userId")
    BigDecimal findAccountBalance(@Param("userId") Integer userId);

    @Query("select max(abs(t.amount)) as amount from Transaction t where t.user.id = :userId and t.type = :transactionType")
    BigDecimal findHighestAmountByTransactionType(Integer userId, TransactionType transactionType);

    @Query("select t.createdDate, sum(t.amount) from Transaction t where t.user.id = :userId and t.createdDate between :start and :end group by t.createdDate")
    Map<LocalDate, BigDecimal> findSumTransactionByDate(LocalDate startDate, LocalDate endDate, Integer userId);
}
