package com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class BasicDAO<T> {

	private Class<T> clazz;
	

	@SuppressWarnings("unchecked")
	public BasicDAO() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}

	public void save(T t) {

		Session session = getSession();
		Transaction ts = session.beginTransaction();
		session.save(t);
		ts.commit();
		session.close();
	}
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = getSession();
		List<T> ts=session.createQuery("from " + clazz.getSimpleName()).list();
		session.close();
		return ts;
	}

	@SuppressWarnings("unchecked")
	public T getById(Integer id) {
		return (T) getSession().get(clazz, id);   
	}
	
	@SuppressWarnings("unchecked")
	public void deleteById(Integer id) {
		Session session = getSession();
		Transaction ts = session.beginTransaction();
		T t=(T)session.get(clazz, id);
		session.delete(t);
		ts.commit();
		session.close();
	}

	public void update(T t) {
		Session session = getSession();
		Transaction ts = session.beginTransaction();
		session.update(t);
		ts.commit();
		session.close();
	}
	
	public void saveOrUpdate(T t){
		Session session = getSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(t);
		ts.commit();
		session.close();
	}
	/*@SuppressWarnings("unchecked")
	public List<T> findByProjectId(Integer projectId) {
		
		System.out.println(clazz.getSimpleName());

		return getSession()
				.createQuery(
						"from"+clazz.getSimpleName()+"l where l.projectId = :projectId")
				.setInteger("projectId", projectId).list();
	}*/
}
