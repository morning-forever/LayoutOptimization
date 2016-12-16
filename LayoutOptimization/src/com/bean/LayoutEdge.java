package com.bean;

/**
 * LayoutEdge entity. @author MyEclipse Persistence Tools
 */

public class LayoutEdge implements Comparable<LayoutEdge>,java.io.Serializable{

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

	// Constructors

	/** default constructor */
	public LayoutEdge() {
	}

	/** full constructor */
	public LayoutEdge(Integer projectId, Integer snode,
			Integer enode) {
		this.projectId = projectId;
		this.snode = snode;
		this.enode = enode;
	}
	
	public LayoutEdge(Integer id, Integer projectId, Integer snode,
			Integer enode) {
		this.id = id;
		this.projectId = projectId;
		this.snode = snode;
		this.enode = enode;
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

	@Override
	public String toString() {
		return "{no:\""+this.noOfProj+"\",sNode:\""+this.snode+"\",eNode:\""+this.enode+"\"}";
	}

	@Override
	public int compareTo(LayoutEdge edge) {
		if(this.noOfProj<edge.getNoOfProj()){
			return -1;
		}else if(this.noOfProj<edge.getNoOfProj()){
			return 1;
		}else{
			return 0;
		}
	}
	
	
}