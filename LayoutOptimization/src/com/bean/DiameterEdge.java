package com.bean;

/**
 * DiameterEdge entity. @author MyEclipse Persistence Tools
 */

public class DiameterEdge implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer noOfProj;
	private Integer projectId;
	private Integer snode;
	private Integer enode;
	private Double edgeLnd;
	private Double edgeQnd;

	// Constructors

	/** default constructor */
	public DiameterEdge() {
	}

	/** full constructor */
	public DiameterEdge( Integer projectId, Integer snode,
			Integer enode, Double edgeLnd, Double edgeQnd) {
		this.projectId = projectId;
		this.snode = snode;
		this.enode = enode;
		this.edgeLnd = edgeLnd;
		this.edgeQnd = edgeQnd;
	}
	public DiameterEdge(Integer id,Integer noOfProj, Integer projectId, Integer snode,
			Integer enode, Double edgeLnd, Double edgeQnd) {
		this.id=id;
		this.noOfProj = noOfProj;
		this.projectId = projectId;
		this.snode = snode;
		this.enode = enode;
		this.edgeLnd = edgeLnd;
		this.edgeQnd = edgeQnd;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNoOfProj() {
		return this.noOfProj;
	}

	public void setNoOfProj(Integer noOfProj) {
		this.noOfProj = noOfProj;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getSnode() {
		return this.snode;
	}

	public void setSnode(Integer snode) {
		this.snode = snode;
	}

	public Integer getEnode() {
		return this.enode;
	}

	public void setEnode(Integer enode) {
		this.enode = enode;
	}

	public Double getEdgeLnd() {
		return this.edgeLnd;
	}

	public void setEdgeLnd(Double edgeLnd) {
		this.edgeLnd = edgeLnd;
	}

	public Double getEdgeQnd() {
		return this.edgeQnd;
	}

	public void setEdgeQnd(Double edgeQnd) {
		this.edgeQnd = edgeQnd;
	}

}