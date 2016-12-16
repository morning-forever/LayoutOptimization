package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.bean.DiameterNode;
import com.bean.DiameterEdge;

public class DiameterNodeDAO extends BasicDAO<DiameterNode>{

	private DiameterEdgeDAO deDAO=new DiameterEdgeDAO();

	@SuppressWarnings("unchecked")
	public List<DiameterNode> findNodeByProjectId(Integer projectId) {
		Session session=getSession();
		 
		List<DiameterNode> lns=session.createQuery(
						"from DiameterNode ln where ln.projectId = :projectId")
				.setInteger("projectId", projectId).list();
		session.close();
		return lns;
	}

	public void casDeleteById(Integer id) {
		DiameterNode node=this.getById(id);
		List<DiameterEdge> edges=deDAO.findBySnodeOrEnode(node.getNoOfProj(),node.getProjectId());
		this.deleteById(id);
		for(DiameterEdge edge:edges){
			deDAO.deleteById(edge.getId());
		}
		
	}

}
