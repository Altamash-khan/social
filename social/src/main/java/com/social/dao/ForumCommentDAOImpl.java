package com.social.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addForumComment(ForumComment comment)
	{
		try
		{
			sessionFactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean deleteForumComment(ForumComment comment)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(comment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
		public List<ForumComment> listForumComment(int forumId)
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from ForumComment where blogId=:myBlogId");
			query.setParameter("myForumId", forumId);
			@SuppressWarnings("unchecked")
			List<ForumComment> listComment=query.list();
			session.close();
			return listComment;
		}
}
