package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.User;

public class TestHibernate {
	public static void main(String args[]){
		Configuration config=new Configuration().configure();
		
		SessionFactory sessionFactory=config.buildSessionFactory();
		
		/*User user=new User();
		user.setUserName(userName)*/
		
		Session session=sessionFactory.openSession();
//		Transaction tran=session.beginTransaction();
		User user=(User)session.get(User.class, 2);
		System.out.println(user);
	}
}
