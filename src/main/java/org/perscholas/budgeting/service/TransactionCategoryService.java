package org.perscholas.budgeting.service;

import java.util.List;

import org.perscholas.budgeting.entity.TransactionCategory;
import org.perscholas.budgeting.repository.TransactionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*TransactionCategoryService class provides necessary business logic for TransactionCategory table*/
@Service
public class TransactionCategoryService {

	/* autowired bean to use TransactionCategoryRepository */
	@Autowired TransactionCategoryRepository repo;
	
	/**
	 * Method to save particular transactionCategory entity in the database
	 * @param transactionCategory     TransactionCategory to save
	 * @return void
	 */
	public void save(TransactionCategory transactionCategory)
	{
		repo.save(transactionCategory);
	}
	
	/**
	 * Method to list all exisiting transactionCategorys in the database
	 * @return List<TransactionCategory>  list of all transactionCategorys
	 */
	public List<TransactionCategory> listAll()
	{
		return (List<TransactionCategory>)repo.findAll();
	}
	
	/**
	 * Method to get particular transactionCategory entity in the database by its transactionCategoryId
	 * @param transactionCategoryId  id of the transactionCategory to find
	 * @return TransactionCategory   transactionCategory
	 */
	public TransactionCategory get(Integer transactionCategoryId)
	{
		return repo.findById(transactionCategoryId).get();
	}
	
	/**
	 * Method to delete particular transactionCategory entity in the database by transactionCategoryId
	 * @param transactionCategoryId   id of the transactionCategory to delete
	 * @return void
	 */
	@Transactional
	public void delete(Integer transactionCategoryId)
	{
		repo.deleteById(transactionCategoryId);
	}
	
	/**
	 * Method  to find all of the entities with a give categoryType
	 *
	 * @param categoryType given categoryType
	 * @return List<TransactionCategory> list of all entities with the same given categoryType
	 */
	public List<TransactionCategory> findAllByCategoryType(String categoryType)
	{
		return repo.findAllByCategoryType(categoryType);
	}
	
	/**
	 * Method to find an entity based on categoryName
	 *
	 * @param categoryName    TransactionCategory's categoryName
	 * @return TransactionCategory  that has the same categoryName
	 */
	public TransactionCategory findByCategoryName(String categoryName)
	{
		return repo.findByCategoryName(categoryName);
	}

}
