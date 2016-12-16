package com.diameter.model;

import java.util.List;

import com.bean.DiameterParam;
import com.bean.PipeKind;

public class PipeTree {
	private int iND;
	private List<PipeTreeNode> nodes;
	private List<PipeTreeEdge> edges;
	private List<PipeKind> pipeKinds;
	
	
	private DiameterParam dP;

	public PipeTree() {
		super();
	}


	public PipeTree(List<PipeTreeNode> nodes, List<PipeTreeEdge> edges,
			List<PipeKind> pipeKinds, DiameterParam dP) {
		super();
		this.nodes = nodes;
		this.edges = edges;
		this.pipeKinds = pipeKinds;
		this.dP = dP;
	}


	public int getiND() {
		return iND;
	}

	public void setiND(int iND) {
		this.iND = iND;
	}

	public List<PipeTreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<PipeTreeNode> nodes) {
		this.nodes = nodes;
	}

	public List<PipeTreeEdge> getEdges() {
		return edges;
	}

	public void setEdges(List<PipeTreeEdge> edges) {
		this.edges = edges;
	}

	public List<PipeKind> getPipeKinds() {
		return pipeKinds;
	}

	public void setPipeKinds(List<PipeKind> pipeKinds) {
		this.pipeKinds = pipeKinds;
	}



	public DiameterParam getdP() {
		return dP;
	}

	public void setdP(DiameterParam dP) {
		this.dP = dP;
	}

	
	
	
	
}
