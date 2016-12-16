package com.bean;

/**
 * LayoutNode entity. @author MyEclipse Persistence Tools
 */

public class LayoutNode implements java.io.Serializable,Comparable<LayoutNode> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer noOfProj;
	private Integer projectId;
	private Integer nodeX;
	private Integer nodeY;
	private Double nodeL;
	private Double nodeR;
	private Double nodePp;
	private Double nodeQl;
	private Double nodeQr;

	// Constructors

	/** default constructor */
	public LayoutNode() {
	}

	/** full constructor */
	public LayoutNode(Integer noOfProj, Integer projectId, Integer nodeX,
			Integer nodeY, Double nodeL, Double nodeR, Double nodePp,
			Double nodeQl, Double nodeQr) {
		this.noOfProj = noOfProj;
		this.projectId = projectId;
		this.nodeX = nodeX;
		this.nodeY = nodeY;
		this.nodeL = nodeL;
		this.nodeR = nodeR;
		this.nodePp = nodePp;
		this.nodeQl = nodeQl;
		this.nodeQr = nodeQr;
	}
	
	public LayoutNode(Integer id,Integer noOfProj, Integer projectId, Integer nodeX,
			Integer nodeY, Double nodeL, Double nodeR, Double nodePp,
			Double nodeQl, Double nodeQr) {
		this.id=id;
		this.noOfProj = noOfProj;
		this.projectId = projectId;
		this.nodeX = nodeX;
		this.nodeY = nodeY;
		this.nodeL = nodeL;
		this.nodeR = nodeR;
		this.nodePp = nodePp;
		this.nodeQl = nodeQl;
		this.nodeQr = nodeQr;
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

	public Integer getNodeX() {
		return this.nodeX;
	}

	public void setNodeX(Integer nodeX) {
		this.nodeX = nodeX;
	}

	public Integer getNodeY() {
		return this.nodeY;
	}

	public void setNodeY(Integer nodeY) {
		this.nodeY = nodeY;
	}

	public Double getNodeL() {
		return this.nodeL;
	}

	public void setNodeL(Double nodeL) {
		this.nodeL = nodeL;
	}

	public Double getNodeR() {
		return this.nodeR;
	}

	public void setNodeR(Double nodeR) {
		this.nodeR = nodeR;
	}

	public Double getNodePp() {
		return this.nodePp;
	}

	public void setNodePp(Double nodePp) {
		this.nodePp = nodePp;
	}

	public Double getNodeQl() {
		return this.nodeQl;
	}

	public void setNodeQl(Double nodeQl) {
		this.nodeQl = nodeQl;
	}

	public Double getNodeQr() {
		return this.nodeQr;
	}

	public void setNodeQr(Double nodeQr) {
		this.nodeQr = nodeQr;
	}

	@Override
	public String toString() {
		
		return "{no:\""+this.noOfProj+"\",x:"+this.nodeX+",y:"+this.nodeY+"}";
	}

	@Override
	public int compareTo(LayoutNode o) {
		if(this.noOfProj<o.getNoOfProj()){
			return -1;
		}else if(this.noOfProj>o.getNoOfProj()){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	
}