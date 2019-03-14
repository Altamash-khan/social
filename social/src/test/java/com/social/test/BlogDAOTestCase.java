package com.social.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.social.dao.BlogDAO;
import com.social.model.Blog;



public class BlogDAOTestCase
 {
	
static BlogDAO blogDAO;


private Blog blog;


@BeforeClass
public static void initialize() {
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.social");
	context.refresh();
	blogDAO = (BlogDAO) context.getBean("blogDAO");
}

	
//@Ignore
	@Test
	public void addBlogTest() 
	{ 
		 blog=new Blog();
	    blog.setBlogName("Advance java");
	    blog.setBlogContent("Servlet and Jsp");
	    blog.setCreateDate(new java.util.Date());
	    blog.setLikes(0);
	    blog.setDislikes(0);
	    blog.setStatus("NA");
	    blog.setUsername("Altamash");
		
		assertTrue("Problem in Adding into Blog",blogDAO.addBlog(blog));
	}
	
	@Ignore
	//@Test
	public void updateCartItemTest()
	{
	Blog blog=blogDAO.getBlog(953);
	blog.setBlogContent("This Blog is for learning web component");
	assertTrue("problem in Upading the Blog",blogDAO.updateBlog(blog));
	}
	

	//@Test
	public void deleteCartItemTest()
	{
		Blog blog=blogDAO.getBlog(955);
		assertTrue("Problem in deleting the Blog",blogDAO.deleteBlog(blog));
	}
	
	 
	//@Test
	/*public void displayBlogs()
	{
		List<Blog>listBlog=blogDAO.listBlogs("vishal");
		
		assertTrue("Problem in Displaying the Blogs" ,Blogs.size()>0);
		
		for (Blog blog:listBlogs)
		{
			System.out.print(blog.getBlogId()+"\t");
			System.out.print(blog.getBlogName()+"\t");
			System.out.print(blog.getBlogContent()+"\t");
			System.out.print(blog.getStatus());
			
			
		} 
	}*/
	 //@Test
	 public void approveBlogTest()
	 {
		 Blog blog=blogDAO.getBlog(952);
		 assertTrue("Problem in Approving the Blog", blogDAO.approveBlog(blog));
	 }
 
	//@Test
	 public void rejectBlogTest()
	 
	 {
		 Blog blog=blogDAO.getBlog(952);
		 assertTrue("Problem in Rejecting the Blog", blogDAO.rejectBlog(blog));
	 }
    //@Test
	 
	public void incrementLikesTest()
	{
		Blog blog=blogDAO.getBlog(954);
		assertTrue("Problem in Increment likes", blogDAO.incrementLikes(blog));
	}
	//@Test
	public void incrementDisLikesTest()
	{
		Blog blog=blogDAO.getBlog(954);
		assertTrue("Problem in Increment Dislikes", blogDAO.incrementDisLikes(blog));
	}
}