package org.perscholas.budgeting.utility;

/*QueryDAO class provides constants that contain native queries necessary for DAO layer*/
public class QueryDAO {
	
	public static final String getAmountByCategoryType = "SELECT amount FROM user_transaction "
			+ "JOIN transaction ON transaction_transaction_id = transaction_id "
			+ "JOIN transaction_category ON category_category_id = category_id "
			+ "WHERE user_user_id = :userId AND category_type= :categoryType AND MONTH(date_of_transaction) = :month "
			+ "GROUP BY transaction_id";
	
	public static final String getCategoryAndSumAmount = "SELECT category_name, SUM(amount) FROM user_transaction \r\n"
			+ "JOIN transaction ON transaction_transaction_id = transaction_id \r\n"
			+ "JOIN transaction_category ON category_category_id = category_id\r\n"
			+ "WHERE user_user_id = :userId AND category_type= :categoryType  AND MONTH(date_of_transaction) =:month \r\n"
			+ "GROUP BY category_name";
	public static final String getTransactionForCategoryName = "SELECT CAST(date_of_transaction as date), description, amount, transaction_id FROM user_transaction \r\n"
			+ "JOIN transaction ON transaction_transaction_id = transaction_id \r\n"
			+ "JOIN transaction_category ON category_category_id = category_id\r\n"
			+ "WHERE user_user_id = :userId AND category_name= :categoryName  \r\n"
			+ "AND MONTH(date_of_transaction) = :month ORDER BY date_of_transaction";
	public static final String getAllTransactionsForCategoryName = "SELECT  CAST(date_of_transaction as date), description, amount, category_name FROM user_transaction \r\n"
			+ "JOIN transaction ON transaction_transaction_id = transaction_id \r\n"
			+ "JOIN transaction_category ON category_category_id = category_id\r\n"
			+ "WHERE user_user_id = :userId AND category_type= :categoryType  \r\n"
			+ "ORDER BY date_of_transaction DESC, category_name, amount desc";

}
