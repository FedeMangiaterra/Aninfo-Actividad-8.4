package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

import static java.lang.Math.min;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Collection<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long cbu) {
        return accountRepository.findById(cbu);
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public void deleteById(Long cbu) {
        accountRepository.deleteById(cbu);
    }

    @Transactional
    public Account withdraw(Long cbu, Double sum) {
        Account account = accountRepository.findAccountByCbu(cbu);

        if (account.getBalance() < sum) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        account.setBalance(account.getBalance() - sum);
        accountRepository.save(account);
        transactionService.createTransaction(new Transaction(cbu, -sum));

        return account;
    }

    @Transactional
    public Account deposit(Long cbu, Double sum) {

        if (sum <= 0) {
            throw new DepositNegativeSumException("Cannot deposit negative sums");
        }

        Double final_sum = sum;
        if (sum >= 2000) {
            final_sum += min(sum * 0.1, 500);
        }

        Account account = accountRepository.findAccountByCbu(cbu);
        account.setBalance(account.getBalance() + final_sum);
        accountRepository.save(account);
        transactionService.createTransaction(new Transaction(cbu, final_sum));

        return account;
    }

}
