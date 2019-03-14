package com.social.dao;

import java.util.List;

import com.social.model.Job;

public interface JobDAO 
{
	public boolean addJobDetail(Job job);
	public boolean updatejobDetail(Job jobO);
	public boolean deletejobDetails(Job job);
	public Job getJob(int jobId);
	public List<Job> getJobdetails();
}
