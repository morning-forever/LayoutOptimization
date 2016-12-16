package com.bean;

/**
 * LayoutGaParam entity. @author MyEclipse Persistence Tools
 */

public class LayoutGaParam   implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer projectId;
	private Integer popsize;
	private Integer maxgen;
	private Double ps;
	private Double pt;

	// Constructors

	/** default constructor */
	public LayoutGaParam() {
	}

	/** full constructor */
	public LayoutGaParam(Integer projectId, Integer popsize, Integer maxgen,
			Double ps, Double pt) {
		this.projectId = projectId;
		this.popsize = popsize;
		this.maxgen = maxgen;
		this.ps = ps;
		this.pt = pt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getPopsize() {
		return this.popsize;
	}

	public void setPopsize(Integer popsize) {
		this.popsize = popsize;
	}

	public Integer getMaxgen() {
		return this.maxgen;
	}

	public void setMaxgen(Integer maxgen) {
		this.maxgen = maxgen;
	}

	public Double getPs() {
		return this.ps;
	}

	public void setPs(Double ps) {
		this.ps = ps;
	}

	public Double getPt() {
		return this.pt;
	}

	public void setPt(Double pt) {
		this.pt = pt;
	}

}