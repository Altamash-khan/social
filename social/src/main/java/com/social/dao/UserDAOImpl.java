package com.social.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.model.UserDetail;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
  @Autowired
  SessionFactory sessionFactory;
  
  //@Override
	public boolean registerUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Adding User:"+e);
			return false;
		}
	}
	
	//@Override
	public boolean updateUser(UserDetail user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:Updating User:"+e);
			return false;
		}
	
	
	}

	//@Override
	public UserDetail getUser(String username)
	{
		 Session session=sessionFactory.openSession();
		 UserDetail userDetail=(UserDetail)session.get(UserDetail.class, username);
		 session.close();
		return userDetail;
	}

	public boolean makeOffline(UserDetail user)
	{
		try
		{
			user.setIsOnline("Of");
			sessionFactory.getCurrentSession().update(user);
		    return true;
	    }
		catch(Exception e)
		{
	     System.out.println("Exception Arised:Make OffLine:"+e);
         return false;
		}
	}
	public boolean makeOnline(UserDetail user)
	{
		try
		{
			user.setIsOnline("On");
			sessionFactory.getCurrentSession().update(user);
		    return true;
	    }
		catch(Exception e)
		{
	     System.out.println("Exception Arised:Make OnLine:"+e);
         return false;
		}
	}
	public boolean approveUser(UserDetail user)
	{
		try
		{
			user.setStatus("A");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:Approve User:"+e);
			
		
		return false;
	    }
	}

	public boolean rejectUser(UserDetail user) 
	{
		try
		{
			user.setStatus("NA");
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:Reject User:"+e);
			
		
		return false;
	    }
	}

	@Override
	public boolean deleteUser(UserDetail user) {
		// TODO Auto-generated method stub
		return false;
	}

}