package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.bean.LayoutEdge;

public class LayoutEdgeDAO extends BasicDAO<LayoutEdge>{
	@SuppressWarnings("unchecked")
	public List<LayoutEdge> findEdgeByProjectId(Integer projectId) {
		Session session=getSession();
		List<LayoutEdge> les= session
				.createQuery(
						"from LayoutEdge le where le.projectId = :projectId")
				.setInteger("projectId", projectId).list();
		session.close();
		return les;
	}

	@SuppressWarnings("unchecked")
	public List<LayoutEdge> findBySnodeOrEnode(Integer noOfProj,
			Integer projectId) {
		
		return getSession().createQuery(
				"from LayoutEdge le where " +
				"le.projectId = :projectId and (le.snode = :noOfProj or le.enode = :noOfProj) ")
				.setInteger("projectId", projectId).setInteger("noOfProj", noOfProj).list();
		
	}

	public LayoutEdge findEdgeByProjectIdAndNoOfProj(Integer projectId,
			Integer edgeNo) {
		return (LayoutEdge)getSession()
		.createQuery("from LayoutEdge le where le.projectId = :projectId and le.noOfProj = :noOfProj ")
		.setInteger("projectId", projectId).setInteger("noOfProj", edgeNo).uniqueResult();
		
	}
	
	/*public void casDeleteById(Integer id){
		LayoutEdge edge=this.getById(id);
		List<LayoutNode> nodes=lnDAO.findBySnodeOrEnode(edge.getSnode(),edge.getEnode());
		
	}*/
}
