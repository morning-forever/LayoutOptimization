package com.bean;

/**
 * LayoutGaReport entity. @author MyEclipse Persistence Tools
 */

public class LayoutGaReport implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer reportId;
	private Integer projectId;
	private Double investment;
	private Integer dprojectId;

	// Constructors

	/** default constructor */
	public LayoutGaReport() {
	}

	/** full constructor */
	public LayoutGaReport(Integer reportId, Integer projectId, Double investment) {
		this.reportId = reportId;
		this.projectId = projectId;
		this.investment = investment;
	}
	public LayoutGaReport(Integer reportId, Integer projectId, Double investment,Integer dProjectId) {
		this.reportId = reportId;
		this.projectId = projectId;
		this.investment = investment;
		this.dprojectId=dProjectId;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReportId() {
		return this.reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Double getInvestment() {
		return this.investment;
	}

	public void setInvestment(Double investment) {
		this.investment = investment;
	}

	public Integer getDprojectId() {
		return dprojectId;
	}

	public void setDprojectId(Integer dprojectId) {
		this.dprojectId = dprojectId;
	}
	
}