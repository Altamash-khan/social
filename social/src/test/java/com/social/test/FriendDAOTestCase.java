package com.social.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.social.dao.FriendDAO;

import com.social.model.Friend;

public class FriendDAOTestCase 
{
	static FriendDAO friendDAO;
	
	
	    @BeforeClass
	    public static void initialize()
	    {
	    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    	context.scan("com.social");
	    	context.refresh();	
	    	friendDAO=(FriendDAO)context.getBean("friendDAO");
	    } 
	//@Ignore 
	@Test
	public void addFriendTestCase()
	{
		Friend friend=new Friend();
		friend.setUserID(1);
		friend.setFriendID(100);
		friend.setStatus("A");
		
		assertTrue("Problem in Adding into Friend",friendDAO.addFriend(friend));
	}
	     @Ignore
	     @Test
		 public void approveFriendTest()
		 {
			 Friend friend=friendDAO.getFriend(5);
			 assertTrue("Problem in Approving the Friend", friendDAO.approveFriend(friend));
		 }
	
	     @Ignore
	     @Test
		 public void rejectFriendTest()
		 {
			 Friend friend=friendDAO.getFriend(101);
			 assertTrue("Problem in rejecting the Friend", friendDAO.rejectFriend(friend));
		 }

}
