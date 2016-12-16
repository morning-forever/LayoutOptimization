package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.bean.DiameterEdge;

public class DiameterEdgeDAO extends BasicDAO<DiameterEdge>{

	public List<DiameterEdge> findEdgeByProjectId(Integer projectId) {
		Session session=getSession();
		@SuppressWarnings("unchecked")
		List<DiameterEdge> des= session
				.createQuery(
						"from DiameterEdge de where de.projectId = :projectId")
				.setInteger("projectId", projectId).list();
		session.close();
		return des;
	}
	
	@SuppressWarnings("unchecked")
	public List<DiameterEdge> findBySnodeOrEnode(Integer noOfProj,
			Integer projectId) {
		
		return getSession().createQuery(
				"from DiameterEdge de where " +
				"de.projectId = :projectId and (de.snode = :noOfProj or de.enode = :noOfProj) ")
				.setInteger("projectId", projectId).setInteger("noOfProj", noOfProj).list();
		
	}

}
