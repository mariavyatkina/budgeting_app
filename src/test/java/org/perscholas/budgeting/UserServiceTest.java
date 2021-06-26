package org.perscholas.budgeting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.perscholas.budgeting.entity.User;
import org.perscholas.budgeting.exception.PasswordDoesNotMatchEmailException;
import org.perscholas.budgeting.exception.UserAlreadyExistException;
import org.perscholas.budgeting.exception.UserDoesNotExistException;
import org.perscholas.budgeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

/*UserServiceTest class provides a set of methods to test out 
 * the UserService class*/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {
	/*
	 * testId is the variable contains the id of the dummy instance of the
	 * User class
	 */
	static int testId;
	
	/* creates and autowired bean for UserService class */
	@Autowired
	UserService userService;

    /**
    * Tests save method for UserService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(1)
	void testSave() {
		User user = new User();
		user.setFirstName("Test User");
		user.setLastName("Test User LN");
		user.setEmail("testuser@perscholas.org");
		user.setPassword("Testuser1");
		userService.save(user);
		testId = user.getUserId();

		assertNotNull(user.getUserId());
	}
	
    /**
    * Tests get method for UserService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(2)
	void testGet() {
		User expected = new User();

		expected.setFirstName("Test User");
		expected.setLastName("Test User LN");
		expected.setEmail("testuser@perscholas.org");
		expected.setPassword("Testuser1");

		expected.setUserId(testId);

		User actual = userService.get(testId);

		assertEquals(expected, actual);
	}
	
    /**
    * Tests existsByEmailAndPassword method for UserService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(3)
	void testExistsByEmailAndPassword()
	{
		User user = userService.get(testId);
		assertTrue(userService.existsByEmailAndPassword(user.getEmail(), user.getPassword()));
	}
	
    /**
    * Tests if register method throws the UserAlreadyExistException for UserService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(4)
	void testRegisterThrowsException()
	{
		User existing = userService.get(testId);
		Assertions.assertThrows(UserAlreadyExistException.class, ()->userService.register(existing));
		
	}
	
    /**
    * Tests login method for UserService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(5)
	void testLogin()
	{
		Assertions.assertThrows(UserDoesNotExistException.class, ()->userService.login(new User()));
		
		User user = userService.get(testId);
		user.setPassword("TestWrongPassword1");
		Assertions.assertThrows(PasswordDoesNotMatchEmailException.class, ()->userService.login(user));
		
	}
	
    /**
    * Tests delete method for UserService class
    *
    * @param  none
    * @return void
    */
	@Test
	@Order(6)
	void testDelete()
	{
		User user = userService.get(testId);
		userService.delete(testId);
		assertFalse(userService.listAll().contains(user));
		
	}
	
	
	

}
