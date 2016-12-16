package com.dao;


import java.util.List;

import org.hibernate.Session;

import com.bean.LayoutEdge;
import com.bean.LayoutNode;

public class LayoutNodeDAO extends BasicDAO<LayoutNode>{
	
	private LayoutEdgeDAO leDAO=new LayoutEdgeDAO();

	@SuppressWarnings("unchecked")
	public List<LayoutNode> findNodeByProjectId(Integer projectId) {
		Session session=getSession();
		 
		List<LayoutNode> lns=session.createQuery(
						"from LayoutNode ln where ln.projectId = :projectId")
				.setInteger("projectId", projectId).list();
		session.close();
		return lns;
	}

	public void casDeleteById(Integer id) {
		LayoutNode node=this.getById(id);
		List<LayoutEdge> edges=leDAO.findBySnodeOrEnode(node.getNoOfProj(),node.getProjectId());
		this.deleteById(id);
		for(LayoutEdge edge:edges){
			leDAO.deleteById(edge.getId());
		}
		
	}

	public LayoutNode findNodeByNoOfProjAndProjectId(Integer projectId,
			Integer noOfProj) {
		System.out.println(projectId);
		System.out.println(noOfProj);
		Session session=getSession();
		LayoutNode node=(LayoutNode) session
				.createQuery("from LayoutNode ln where ln.projectId = :projectId and ln.noOfProj = :noOfProj")
				.setInteger("projectId", projectId).setInteger("noOfProj", noOfProj).uniqueResult();
		return node;
	}

	/*public List<LayoutNode> findBySnodeOrEnode(Integer snode, Integer enode) {
		
		List<LayoutNode> nodes=new ArrayList<LayoutNode>();
		nodes.addAll(this.findByNoOfProj(snode));
		nodes.addAll(this.findByNoOfProj(enode));
		return nodes;
		
	}
	
	public List<LayoutNode> findByNoOfProj(Integer noOfProj){
		
		return getSession().createQuery("from LayoutNode ln where ln.noOfProj = :noOfProj")
				.setInteger("noOfProj", noOfProj).list();
	}*/

	
}
