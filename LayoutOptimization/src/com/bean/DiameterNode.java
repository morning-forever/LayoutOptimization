package com.bean;

/**
 * DiameterNode entity. @author MyEclipse Persistence Tools
 */

public class DiameterNode implements java.io.Serializable,Comparable<DiameterNode> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer noOfProj;
	private Integer projectId;
	private Integer nodeXnd;
	private Integer nodeYnd;
	private Double nodeL;
	private Double nodeR;
	private Double nodePp;
	private Double nodeQl;
	private Double nodeQr;

	// Constructors

	/** default constructor */
	public DiameterNode() {
	}

	/** full constructor */
	public DiameterNode(Integer noOfProj, Integer projectId, Integer nodeXnd,
			Integer nodeYnd, Double nodeL, Double nodeR, Double nodePp,
			Double nodeQl, Double nodeQr) {
		this.noOfProj = noOfProj;
		this.projectId = projectId;
		this.nodeXnd = nodeXnd;
		this.nodeYnd = nodeYnd;
		this.nodeL = nodeL;
		this.nodeR = nodeR;
		this.nodePp = nodePp;
		this.nodeQl = nodeQl;
		this.nodeQr = nodeQr;
	}
	public DiameterNode(Integer id,Integer noOfProj, Integer projectId, Integer nodeXnd,
			Integer nodeYnd, Double nodeL, Double nodeR, Double nodePp,
			Double nodeQl, Double nodeQr) {
		this.id=id;
		this.noOfProj = noOfProj;
		this.projectId = projectId;
		this.nodeXnd = nodeXnd;
		this.nodeYnd = nodeYnd;
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

	public Integer getNodeXnd() {
		return this.nodeXnd;
	}

	public void setNodeXnd(Integer nodeXnd) {
		this.nodeXnd = nodeXnd;
	}

	public Integer getNodeYnd() {
		return this.nodeYnd;
	}

	public void setNodeYnd(Integer nodeYnd) {
		this.nodeYnd = nodeYnd;
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
	public int compareTo(DiameterNode o) {
		if(this.noOfProj<o.getNoOfProj()){
			return -1;
		}else if(this.noOfProj>o.getNoOfProj()){
			return 1;
		}else{
			return 0;
		}
		
	}

}