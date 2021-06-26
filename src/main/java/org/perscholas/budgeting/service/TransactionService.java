package org.perscholas.budgeting.service;

import java.util.List;

import org.perscholas.budgeting.entity.Transaction;
import org.perscholas.budgeting.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*TransactionService class provides necessary business logic for Transaction table*/
@Service
public class TransactionService {

	/* autowired bean to use TransactionRepository */
@Autowired TransactionRepository repo;
	
/**
 * Method to save particular transaction entity in the database
 * @param transaction     transaction to save
 * @return void
 */
	public void save(Transaction Transaction)
	{
		repo.save(Transaction);
	}
	/**
	 * Method to list all exisiting transactions in the database
	 * @return List<transaction>  list of all transactions
	 */
	public List<Transaction> listAll()
	{
		return (List<Transaction>)repo.findAll();
	}
	/**
	 * Method to get particular transaction entity in the database by its transactionId
	 * @param transactionId  id of the transaction to find
	 * @return transaction   transaction
	 */
	public Transaction get(Integer transactionId)
	{
		return repo.findById(transactionId).get();
	}
	/**
	 * Method to delete particular transaction entity in the database by transactionId
	 * @param transactionId   id of the transaction to delete
	 * @return void
	 */
	@Transactional
	public void delete(Integer transactionId)
	{
		repo.deleteById(transactionId);
	}
	



}
