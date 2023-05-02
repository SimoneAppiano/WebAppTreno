package com.test.java;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import treno.Treno;
import builder.TN.*;

public class Test {

	public static void main(String[] args) throws Exception {
		testTreno();

	}

	public static void testTreno(){
		TNBuilder builder=new TNBuilder();
		Treno treno1 = builder.costruisci("HCCCC");
		System.out.println(treno1.toString());
		
		
	}
	
	public SessionFactory factory() {
		SessionFactory factory;

	    try {
	        factory = new Configuration().configure().buildSessionFactory();
	        return factory;
	     } catch (Throwable ex) { 
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	     }
	}
	
	
}
