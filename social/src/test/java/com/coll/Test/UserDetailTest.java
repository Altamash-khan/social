package com.coll.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.coll.DAO.UserDetailDAO;
import com.coll.Model.UserDetail;

public class UserDetailTest {

	static UserDetailDAO userdetailDAO;
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
		
	}
	//@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		user.setLoginname("altamash");
		user.setPassword("12345");
		user.setUsername(" altamash");
		user.setEmailid("altamash@gmail.com");
		user.setMobileno("9167059453");
		user.setAddress("mumbai");
		user.setRole("ROLE_ADMIN");
		assertTrue("Problem in adding User",userdetailDAO.registerUser(user));
		
}
 @Ignore
 @Test
 public void updateUserTest()
   {
	UserDetail user=userdetailDAO.getUser("fahad");
	user.setEmailid("fahad@outlook.com");
	assertTrue("problem in updating the user",userdetailDAO.updateProfile(user));
  }
	@Ignore
	@Test
	public void checkUser()
	{
		UserDetail user=userdetailDAO.checkUserValidation("altamash","12345");
		assertNotNull("problem in checking User",user);
	}
}