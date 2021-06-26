package org.perscholas.budgeting.repository;

import java.util.List;

import org.perscholas.budgeting.entity.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*TransactionCategoryRepository provides DAO layer for transactionCategory table of the database*/
@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Integer>{
	
	/**
	 * Method signature to find all of the entities with a give categoryType
	 *
	 * @param categoryType given categoryType
	 * @return List<TransactionCategory> list of all entities with the same given categoryType
	 */
	List<TransactionCategory> findAllByCategoryType(String categoryType);
	
	/**
	 * Method signature to find an entity based on categoryName
	 *
	 * @param categoryName    TransactionCategory's categoryName
	 * @return TransactionCategory  that has the same categoryName
	 */
	TransactionCategory findByCategoryName(String categoryName);

}
