package org.perscholas.budgeting.repository;

import java.util.List;
import java.util.Map;

import org.perscholas.budgeting.entity.Transaction;
import org.perscholas.budgeting.entity.User;
import org.perscholas.budgeting.utility.QueryDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*UserRepository provides DAO layer for user table of the database*/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * Method signature to see if the entity exists in the database based on its
	 * email and password
	 *
	 * @param email    user's email
	 * @param password user's password
	 * @return boolean based on the result of the query
	 */
	boolean existsByEmailAndPassword(String email, String password);

	/**
	 * Method signature to see if the entity exists in the database based on its
	 * email
	 *
	 * @param email user's email
	 * @return boolean based on the result of the query
	 */
	boolean existsByEmail(String email);

	/**
	 * Method signature to get the User entity based on its email
	 *
	 * @param email    user's email
	 * @param password user's password
	 * @return boolean based on the result of the query
	 */
	User getByEmail(String email);


	/**
	 * Method signature based on the native query to get all of the amounts based on the userId, categoryType and month
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @param month         month for return values
	 * @return List<Double> list of doubles that correspond to the amounts in the database
	 */
	@Query(value = QueryDAO.getAmountByCategoryType, nativeQuery = true)
	List<Double> getAmountByCategoryType(int userId, String categoryType, int month);
	
	/**
	 * Method signature based on the native query to get all of the category names 
	 * and the corresponding sums of amounts of that category name
	 *  based on the userId, categoryType and month
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @param month         month for return values
	 * @return List<Object[]> list of object array that contain category name and sums of amounts
	 */
	@Query(value = QueryDAO.getCategoryAndSumAmount, nativeQuery = true)
	List<Object[]> getCategoryAndSumAmount(int userId, String categoryType, int month);

	/**
	 * Method signature based on the native query to get all of the dates, descrptions, amounts, transaction id 
	 * for a particular user and under a particular category_name
	 *  based on the userId, categoryType and month
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @param month         month for return values
	 * @return List<Object[]> list of object array that contains date, description, amount, and transaction_id
	 */
	@Query(value = QueryDAO.getTransactionForCategoryName, nativeQuery = true)
	List<Object[]> getTransactionsForCategoryName(int userId, String categoryName, int month);
	
	/**
	 * Method signature based on the native query to get all of the dates, descrptions, amounts,  category_name
	 * for a particular user and under a particular category_name
	 *  based on the userId, categoryType 
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @return List<Object[]> list of object array that contains date, description, amount, and category_name
	 */
	@Query(value = QueryDAO.getAllTransactionsForCategoryName, nativeQuery = true)
	List<Object[]> getAllTransactionsForCategoryName(int userId, String categoryType);
}
