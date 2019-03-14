package com.social.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTestDBConfig 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.social");
		
		context.refresh();
	}
}

