package com.social.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="blogCommentIdSeq",sequenceName="blogCommentIdSeq")
public class BlogComment
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogCommentIdSeq")
	int commentId;
	int blogId;
	String commentText;
	Date commentDate;
	String username;
	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentdate() {
		return commentDate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentDate = commentdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}