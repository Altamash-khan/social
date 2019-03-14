package com.social.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.social.dao.ForumDAO;
import com.social.model.Forum;

public class ForumDAOTestCase 
{
	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.social");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	//@Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		forum.setForumId(1);
		forum.setForumName("IIT Forum");
		forum.setForumContent("This is IIT Forum Content");
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		forum.setUserName("Khan");
		
		assertTrue("Problem in adding into Forum",forumDAO.addForum(forum));
		
		
	}
    @Ignore
    @Test
	public void updateForumTest()
	{
	Forum forum=forumDAO.getForum(100);
	forum.setForumContent("This is updated IIT Forum");
	assertTrue("problem in Upading the Forum",forumDAO.updateForum(forum));
	}
    @Ignore
    @Test
	public void deleteForumTest()
	{
		Forum forum=forumDAO.getForum(100);
		assertTrue("Problem in deleting the Forum",forumDAO.deleteForum(forum));
	}
     @Ignore
     @Test
	 public void approveForumTest()
	 {
		 Forum forum=forumDAO.getForum(100);
		 assertTrue("Problem in Approving the Forum", forumDAO.approveForum(forum));
	 }
     @Ignore
	 @Test
	 public void rejectForumTest()
	 {
		Forum forum=forumDAO.getForum(100);
		 assertTrue("Problem in Rejecting the Forum", forumDAO.rejectforum(forum));
	 }
}
