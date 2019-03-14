package com.social.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.model.Friend;


@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO
{
		@Autowired
		SessionFactory sessionFactory;
		
		//@Override
		public boolean addFriend(Friend friend)
		{
			try
			{
				sessionFactory.getCurrentSession().save(friend);
				return true;
			}
			catch(Exception e)
			{
				//System.out.println(e);
				return false;
			}
		}
		//@Override
				public boolean deleteFriend(Friend friend)
				{
					try
					{
						sessionFactory.getCurrentSession().delete(friend);
						return true;
					}
					catch(Exception e)
					{
						
						return false;
					}
				}
				
				//@Override
				public boolean updateFriend(Friend friend)
				{
					try
					{
						sessionFactory.getCurrentSession().update(friend);
						return true;
					}
					catch(Exception e)
					{
						
						return false;
					}
				}
				//@Override
				public boolean approveFriend(Friend friend) 
				{
					try
					{
						friend.setStatus("A");
						sessionFactory.getCurrentSession().update(friend);
						return true;
					}
					catch(Exception e)
					{
					System.out.println("Exception Arised:Approve Friend:"+e);
						
					return false;
				    }
				}

				
				//@Override
				public boolean rejectFriend(Friend friend)
				{
					try
					{
						friend.setStatus("NA");
						sessionFactory.getCurrentSession().update(friend);
						return true;
					}
					catch(Exception e)
					{
					System.out.println("Exception Arised:Reject Friend:"+e);
						
					
					return false;
				    }
				}
				
				//@Override
				public List<Friend> getAllFriends() 
				{
					 Session session= sessionFactory.openSession();
					 Query query=session.createQuery("from Friend");
					 @SuppressWarnings("unchecked")
					 List<Friend> listfriend=(List<Friend>)query.list();
					 session.close();
				     return listfriend;
				}

				public Friend getFriend(int friendId) {
					// TODO Auto-generated method stub
					return null;
				}
}
