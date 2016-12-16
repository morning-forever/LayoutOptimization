package com.bean;

/**
 * LayoutProjectParams entity. @author MyEclipse Persistence Tools
 */

public class LayoutProjectParams  implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer projectId;
	private Double a;
	private Double b;
	private Double vmin;

	// Constructors

	/** default constructor */
	public LayoutProjectParams() {
	}

	/** full constructor */
	public LayoutProjectParams(Integer projectId, Double a, Double b,
			Double vmin) {
		this.projectId = projectId;
		this.a = a;
		this.b = b;
		this.vmin = vmin;
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

	public Double getA() {
		return this.a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return this.b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double getVmin() {
		return this.vmin;
	}

	public void setVmin(Double vmin) {
		this.vmin = vmin;
	}

}