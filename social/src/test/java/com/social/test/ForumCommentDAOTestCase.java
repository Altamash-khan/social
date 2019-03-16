package com.social.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.social.dao.ForumCommentDAO;
import com.social.model.BlogComment;
import com.social.model.ForumComment;

public class ForumCommentDAOTestCase
{
	static ForumCommentDAO forumCommentDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collob");
		context.refresh();	
		forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
	}
	@Ignore
	@Test
public void addForumCommentTestCase()
{
	ForumComment comment=new ForumComment();
	comment.setForumId(100);
	comment.setCommentText("niceForum");
	comment.setCommentDate(new java.util.Date());
	comment.setUsername("Khan");
	
	assertTrue("Problem in Adding ForumComment",forumCommentDAO.addForumComment(comment));
	
	
}
}
