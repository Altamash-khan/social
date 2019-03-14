package com.social.dao;

import java.util.List;

import com.social.model.BlogComment;

public interface BlogCommentDAO
{

	public boolean addBlogComment(BlogComment comment);
	public boolean deleteBlogComment(BlogComment comment);
	public List<BlogComment> listBlogComment(int blogId);
	
}
