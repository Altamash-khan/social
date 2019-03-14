package com.social.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.social.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO

{
	@Autowired
    SessionFactory sessionFactory;    

	public boolean addJobDetail(Job job) 
	{
		
			 try
			 {
			  sessionFactory.getCurrentSession().save(job);
			  return true; 
			 }
			 catch(Exception e)
			 {	 
				System.out.println("Exception Arised:AddJob detail:"+e);
				return false;
			 }
			}

	public boolean updateJobDetail(Job job)
	{
		
			 try
			 {
			  sessionFactory.getCurrentSession().update(job);
			  return true; 
			 }
			 catch(Exception e)
			 {	
				 
				return false;
			 }
			}

	public boolean deleteJobDetail(Job job) 
		 {
			 try
			 {
			  sessionFactory.getCurrentSession().delete(job);
			  return true; 
			 }
			 catch(Exception e)
			 {	 
				
				return false;
			 }
			}


	public Job getJob(int jobId) 
		{
			Session session= sessionFactory.openSession();
			Job job=session.get(Job.class,jobId);
			session.close();
			return job;
		}

	public List<Job> getJobdetails() 
		{
			 Session session= sessionFactory.openSession();
			 Query query=session.createQuery("from Job");
			 //@SuppressWarnings("unchecked")
			 List<Job> listjob=query.list();
			 session.close();
		     return listjob;
		}

	public boolean updatejobDetail(Job jobO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletejobDetails(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

	/*@Override
	public boolean updatejobDetail(Job jobO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletejobDetails(Job job) {
		// TODO Auto-generated method stub
		return false;
	}
*/
}