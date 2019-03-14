package com.social.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.social.dao.JobDAO;
import com.social.model.Job;


public class JobDAOTestCase 
{
    static JobDAO jobDAO;
    
    @BeforeClass
    public static void initialize()
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	context.scan("com.social");
    	context.refresh();	
    	jobDAO=(JobDAO)context.getBean("jobDAO");
    } 
   @Ignore 
   @Test
    public void addJobTestCase()
    {
    	Job job=new Job();
    	
    	job.setDesignation("Devloper");
    	job.setJobdesc("Skills Required-java,spring,hibernate");
    	job.setQualification("BE");
    	job.setStatus("p");
    	job.setLastDate(new java.util.Date());
    	
    	assertTrue("Problem in adding Job:",jobDAO.addJobDetail(job));
    }
    
  // @Ignore 
   @Test
    public void listJobTestCase()
    {
    	List<Job> listJobs=jobDAO.getJobdetails();
    	assertTrue("Problem in Listing Job:", listJobs.size()>0);
    	
    	for(Job job:listJobs)
    	{
    		System.out.println(job.getJobId());
    		System.out.println(job.getJobdesc());
    		System.out.println(job.getDesignation());
    		
    	}
    	
    }
    
   @Ignore 
   @Test
    public void updateJobTestCase()
	{
	Job job=jobDAO.getJob(953);
	job.setJobdesc("Required Skills --> .net");
	assertTrue("problem in Upading the Job",jobDAO.updatejobDetail(job));
	}
	
   @Ignore 
   @Test
  	public void deleteJobTestCase()
  	{
  		Job job=jobDAO.getJob(954);
  		assertTrue("Problem in deleting the Job",jobDAO.deletejobDetails(job));
  	}
  	


}