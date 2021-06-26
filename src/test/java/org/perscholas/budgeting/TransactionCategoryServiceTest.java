package org.perscholas.budgeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.perscholas.budgeting.entity.TransactionCategory;
import org.perscholas.budgeting.service.TransactionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/*TransactionCategoryServiceTest class provides a set of methods to test out 
 * the TransactionCategoryService class*/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionCategoryServiceTest {
	/*
	 * testId is the variable contains the id of the dummy instance of the
	 * TransactionCategory class
	 */
	static int testId;
	
	/* creates and autowired bean for TransactionCategoryService class */
	@Autowired
	TransactionCategoryService transactionService;

    /**
    * Tests save method for TransactionCategoryService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(1)
	void testSave() {
		TransactionCategory category = new TransactionCategory();
		category.setCategoryName("Test Category Name");
		category.setCategoryType("Test Category Type");
		transactionService.save(category);
		testId = category.getCategoryId();

		assertNotNull(category.getCategoryId());
	}

    /**
    * Tests get method for TransactionCategoryService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(2)
	void testGet() {
		TransactionCategory expected = new TransactionCategory();

		expected.setCategoryName("Test Category Name");
		expected.setCategoryType("Test Category Type");

		expected.setCategoryId(testId);
		TransactionCategory actual = transactionService.get(testId);
		assertEquals(expected, actual);
	}

    /**
    * Tests delete method for TransactionCategoryService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(3)
	void testDelete()
	{
		TransactionCategory transaction = transactionService.get(testId);
		transactionService.delete(testId);
		assertFalse(transactionService.listAll().contains(transaction));
		
	}

}
