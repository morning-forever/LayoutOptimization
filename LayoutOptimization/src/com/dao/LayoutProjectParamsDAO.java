package com.dao;


import org.hibernate.Session;

import com.bean.LayoutProjectParams;

public class LayoutProjectParamsDAO extends BasicDAO<LayoutProjectParams>{

	public LayoutProjectParams findppByProjectId(Integer projectId) {
		Session session=getSession();
		LayoutProjectParams	lpp=(LayoutProjectParams)session.createQuery("from LayoutProjectParams lpp where lpp.projectId = :projectId")
		.setInteger("projectId", projectId).uniqueResult();
		session.close();
		return lpp;
	}
	
}
