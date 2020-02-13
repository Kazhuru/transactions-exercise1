package service.Impl;

import models.Transaction;
import service.TransactionRepository;

import java.util.List;

public class TransactionRepositoryH2Impl implements TransactionRepository {

    @Override
    public void saveTransactions(List<Transaction> transactions) {

    }

    @Override
    public List<String> getTablesDifferences(String transactionsToCompare) {
        return null;
    }
}
