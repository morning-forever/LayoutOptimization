package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory factory = null;

	private HibernateSessionFactory(){}
	
	private static void buildSessionFactory(){
		Configuration config = new Configuration().configure();
		factory = config.buildSessionFactory();
	}
	
	public static Session getSession(){
		if(factory==null){
			buildSessionFactory();
		}
		return factory.openSession();
	}
}
