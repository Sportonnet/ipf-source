/**
 * 
 */
package com.iplfreaks.dao.impl;



import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iplfreaks.user.User;

/**
 * @author jayeshm3
 *
 */



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test//(expected=Exception.class)
	public void testCreateUser()
	{
		final User user = createUser();
		
		exception.expect(DuplicateKeyException.class);
		final boolean isSuccess = this.userDao.createUser(user);
		Assert.assertTrue(isSuccess);
	}
	
	@Test
	public void testAuthenticateUser()
	{
		final boolean isSuccess = this.userDao.authenticateUser(createUser());
		Assert.assertTrue(isSuccess);
	}
	
	private User createUser()
	{
		final User user = new User();
		user.setEmail("testuser@gmail.com");
		user.setPassword("testpassword");
		user.setCreatedDate(new DateTime());
		return user;
	}

}
