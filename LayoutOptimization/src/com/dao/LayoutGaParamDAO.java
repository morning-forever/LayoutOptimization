package com.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.LayoutGaParam;

public class LayoutGaParamDAO extends BasicDAO<LayoutGaParam>{
	
	
	public void save(LayoutGaParam layoutGaParam){
		
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.save(layoutGaParam);
		ts.commit();
		session.close();
	}
	
	public LayoutGaParam findById(Integer id){
		Session session=getSession();
		LayoutGaParam lgp=(LayoutGaParam)session.get(LayoutGaParam.class, id);
		session.close();
		return lgp;
	}

	public LayoutGaParam findByProjectId(Integer projectId) {
		Session session=getSession();
		LayoutGaParam lgp=(LayoutGaParam)session.createQuery("from LayoutGaParam lgp where lgp.projectId = :projectId")
				.setInteger("projectId", projectId).uniqueResult();
		session.close();
		return lgp;
	}
}
