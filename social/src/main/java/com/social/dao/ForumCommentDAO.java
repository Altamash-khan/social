package com.social.dao;

import java.util.List;

import com.social.model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addForumComment(ForumComment comment);
	public boolean deleteForumComment(ForumComment comment);
	public List<ForumComment> listForumComment(int forumId);
	
}
