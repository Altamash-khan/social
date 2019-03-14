package com.social.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.social.dao.UserDAO;
import com.social.model.Blog;
import com.social.model.UserDetail;

public class UserDAOTestCase
{
static UserDAO userDAO;

@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.social");
	context.refresh();	
	userDAO=(UserDAO)context.getBean("userDAO");
} 
@Test
public void registerUserTest()
{
	UserDetail user=new UserDetail();
	
	user.setUserId(1);
	user.setCustomerName("ALTAMASH");
	user.setUsername("Khan");
	user.setPassword("12345");
	user.setEmailId("Altamash@gmail.com");
	user.setIsOnline("On");
	user.setRole("Student");
	user.setStatus("A");
	
	assertTrue("Problem in adding User:",userDAO.registerUser(user));
}
   

    //@Test
	public void updateCartItemTest()
	{
	UserDetail user=userDAO.getUser("Khan");
	user.setEmailId("ALTAMASHKHAN@GMAIL.COM");
	assertTrue("problem in Upading the User",userDAO.updateUser(user));
	}
	
	//@Test
	public void makeOfflineTest()
	{
		UserDetail user=userDAO.getUser("Khan");
		assertTrue("problem in making ofline: ",userDAO.makeoffline(user));
	}
	
	//@Test
	public void makeOnlineTest()
	{
		UserDetail user=userDAO.getUser("Khan");
		assertTrue("problem in making online: ",userDAO.makeOnline(user));
	}
	
	//@Test
	 public void rejectUserTest()
	 {
		 UserDetail user=userDAO.getUser("Khan");
		 assertTrue("Problem in Rejecting the User", userDAO.rejectUser(user));
	 }
	
	//@Test
	 public void approveUserTest()
	 {
		 UserDetail user=userDAO.getUser("");
		 assertTrue("Problem in Approving the User", userDAO.approveUser(user));
	 }
}