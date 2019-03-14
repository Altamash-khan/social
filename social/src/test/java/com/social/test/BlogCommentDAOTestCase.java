package com.social.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.social.dao.BlogCommentDAO;
import com.social.model.BlogComment;


public class BlogCommentDAOTestCase
{
	static BlogCommentDAO blogCommentDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.social");
		context.refresh();	
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
	}
	
	@Test
	public void addBlogCommentTestCase()
	{
		BlogComment comment=new BlogComment();
		comment.setBlogId(952);
		comment.setCommentText("good blog");
		comment.setCommentdate(new java.util.Date());
		comment.setUsername("Altamash");
		
		assertTrue("Problem in Adding into BlogComment",blogCommentDAO.addBlogComment(comment));
	}
	

}