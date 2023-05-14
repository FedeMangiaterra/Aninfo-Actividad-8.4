package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionDepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionDepository transactionDepository;

    public Transaction createTransaction(Transaction transaction) { return transactionDepository.save(transaction); }

    public Collection<Transaction> getTransactions() { return transactionDepository.findAll(); }

    public Optional<Transaction> findById(Long id) {
        return transactionDepository.findById(id);
    }

    public List<Transaction> getTransactionsByCbu(Long cbu) { return transactionDepository.findByCbu(cbu); }

    public void deleteById(Long id) { transactionDepository.deleteById(id); }

}
