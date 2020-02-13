package service;

import models.Transaction;

import java.util.List;

public interface TransactionRepository {

    void saveTransactions(List<Transaction> transactions);

    List<String> getTablesDifferences(String transactionsToCompare);
}
