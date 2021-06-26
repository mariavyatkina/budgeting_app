package org.perscholas.budgeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.perscholas.budgeting.entity.Transaction;
import org.perscholas.budgeting.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*TransactionServiceTest class provides a set of methods to test out 
 * the TransactionService class*/

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionServiceTest {
	
	/*
	 * testId is the variable contains the id of the dummy instance of the
	 * Transaction class
	 */
	static int testId;
	
	/* creates and autowired bean for TransactionService class */
	@Autowired
	TransactionService transactionService;

    /**
    * Tests save method for TransactionService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(1)
	void testSave() {
		Transaction transaction = new Transaction();
		transaction.setAmount(1);
		transaction.setDateOfTransaction(java.time.LocalDate.now());
		transactionService.save(transaction);
		testId = transaction.getTransactionId();

		assertNotNull(transaction.getTransactionId());
	}
	
	
    /**
    * Tests get method for TransactionService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(2)
	void testGet() {
		Transaction expected = new Transaction();

		expected.setAmount(1);
		expected.setDateOfTransaction(java.time.LocalDate.now());

		expected.setTransactionId(testId);

		Transaction actual = transactionService.get(testId);

		assertEquals(expected, actual);
	}

    /**
    * Tests delete method for TransactionService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(3)
	void testDelete()
	{
		Transaction transaction = transactionService.get(testId);
		transactionService.delete(testId);
		assertFalse(transactionService.listAll().contains(transaction));
		
	}

}
