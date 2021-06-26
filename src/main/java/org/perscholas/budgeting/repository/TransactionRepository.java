package org.perscholas.budgeting.repository;

import org.perscholas.budgeting.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/*TransactionRepository provides DAO layer for transaction table of the database*/
public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{

}


