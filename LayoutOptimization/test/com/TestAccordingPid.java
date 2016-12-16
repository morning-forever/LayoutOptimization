package com;

import java.util.List;

import com.bean.LayoutEdge;
import com.bean.LayoutNode;
import com.dao.LayoutEdgeDAO;
import com.dao.LayoutNodeDAO;
import com.util.Utils;

public class TestAccordingPid {
	public static void main(String args[]){
		List<LayoutNode> nodes=new LayoutNodeDAO().findNodeByProjectId(1);
		
		System.out.println("nodesJSON=="+Utils.getNodesJSON(nodes));
		List<LayoutEdge> edges=new LayoutEdgeDAO().findEdgeByProjectId(1);
		
		System.out.println("edgesJSON=="+Utils.getEdgesJSON(edges));
		
	}
}	
