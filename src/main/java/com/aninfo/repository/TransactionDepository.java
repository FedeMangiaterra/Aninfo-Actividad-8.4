package com.aninfo.repository;

import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionDepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findByCbu(Long cbu);

    @Override
    List<Transaction> findAll();

}
