package org.perscholas.budgeting.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.perscholas.budgeting.entity.Transaction;
import org.perscholas.budgeting.entity.User;
import org.perscholas.budgeting.exception.PasswordDoesNotMatchEmailException;
import org.perscholas.budgeting.exception.UserAlreadyExistException;
import org.perscholas.budgeting.exception.UserDoesNotExistException;
import org.perscholas.budgeting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*UserService class provides necessary business logic for User table*/
@Service
public class UserService {
	
	/* autowired bean to use UserRepository */
	@Autowired UserRepository repo;
	
	/**
	 * Method to save particular user entity in the database
	 * @param user     User to save
	 * @return void
	 */
	public void save(User user)
	{
		repo.save(user);
	}
	
	/**
	 * Method to list all exisiting users in the database
	 * @return List<User>  list of all users
	 */
	public List<User> listAll()
	{
		return (List<User>)repo.findAll();
	}
	
	
	/**
	 * Method to get particular user entity in the database by its userId
	 * @param userId  id of the user to find
	 * @return User   user
	 */
	public User get(Integer userId)
	{
		return repo.findById(userId).get();
	}
	
	/**
	 * Method to delete particular user entity in the database by userId
	 * @param userId   id of the user to delete
	 * @return void
	 */
	@Transactional
	public void delete(Integer userId)
	{
		repo.deleteById(userId);
	}
	
	
	/**
	 * Method to see if  particular user entity exists in the database based on their email and password
	 * @param email     User's email
	 * @param password  User's password
	 * @return boolean  whether the user exists or not
	 */
	public boolean existsByEmailAndPassword(String email, String password)
	{
		return repo.existsByEmailAndPassword(email, password);
	}
	
	
	/**
	 * Method to save particular user entity in the database if it doesn't already exist
	 * @param user     User to register
	 * @return void
	 */
	public void register(User user) throws UserAlreadyExistException
	{
		if(repo.existsByEmail(user.getEmail()))
		{
			throw new UserAlreadyExistException("User with this email already exists");
		}
		else
		{
			repo.save(user);
		}
	}
	
	/**
	 * Method to check particular user's ability to login
	 * @param user     User to login
	 * @return void
	 */
	public void login(User user) throws UserDoesNotExistException, PasswordDoesNotMatchEmailException
	{
		if(!repo.existsByEmail(user.getEmail()))
		{
			throw new UserDoesNotExistException("User with this email does not exist");	
		}
		else if(!repo.existsByEmailAndPassword(user.getEmail(),user.getPassword()))
		{
			throw new PasswordDoesNotMatchEmailException("The password is incorrect for this email");
		}
	}
	
	/**
	 * Method to get particular user entity in the database by its email
	 * @param email  user's email
	 * @return user
	 */
	public User getByEmail(String email)
	{
		return repo.getByEmail(email);
	}
	
	/**
	 * Method  to get all of the amounts based on the userId, categoryType and current month
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @return List<Double> list of doubles that correspond to the amounts in the database
	 */
	public List<Double> getAmountByCategoryType(int userId, String categoryType)
	{
		int month = Calendar.getInstance().get(Calendar.MONTH)+1;
		return repo.getAmountByCategoryType(userId, categoryType, month);
	}
	
	/**
	 * Method to get all of the category names 
	 * and the corresponding sums of amounts of that category name
	 *  based on the userId, categoryType and current month
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @return List<Object[]> list of object array that contain category name and sums of amounts
	 */
	public List<Object[]> getCategoryAndSumAmount(int userId, String categoryType)
	{
		int month = Calendar.getInstance().get(Calendar.MONTH)+1;
		return repo.getCategoryAndSumAmount(userId, categoryType, month);
	}
	
	/**
	 * Method to get all of the dates, descrptions, amounts, transaction id 
	 * for a particular user and under a particular category_name
	 *  based on the userId, categoryType and current month
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @return List<Object[]> list of object array that contains date, description, amount, and transaction_id
	 */
	public List<Object[]> getTransactionsForCategoryName(int userId, String categoryName)
	{
		int month = Calendar.getInstance().get(Calendar.MONTH)+1;
		return repo.getTransactionsForCategoryName(userId, categoryName, month);
	}
	
	/**
	 * Method  to get all of the dates, descrptions, amounts,  category_name
	 * for a particular user and under a particular category_name
	 *  based on the userId, categoryType 
	 *
	 * @param userId        user's id
	 * @param categoryType  type of category for transaction
	 * @return List<Object[]> list of object array that contains date, description, amount, and category_name
	 */
	public List<Object[]> getAllTransactionsForCategoryName(int userId, String categoryType)
	{
		return repo.getAllTransactionsForCategoryName(userId, categoryType);
	}
}
