package com.bean;

/**
 * LayoutGaReportEdges entity. @author MyEclipse Persistence Tools
 */

public class LayoutGaReportEdges implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3697912639563109031L;
	private Integer id;
	private Integer reportId;
	private Integer projectId;
	private Integer edgeNo;
	private Double edgeLnd;
	private Double edgeQnd;

	// Constructors

	/** default constructor */
	public LayoutGaReportEdges() {
	}

	/** minimal constructor */
	public LayoutGaReportEdges(Integer reportId, Integer projectId,
			Integer edgeNo) {
		this.reportId = reportId;
		this.projectId = projectId;
		this.edgeNo = edgeNo;
	}

	/** full constructor */
	public LayoutGaReportEdges(Integer reportId, Integer projectId,
			Integer edgeNo, Double edgeLnd, Double edgeQnd) {
		this.reportId = reportId;
		this.projectId = projectId;
		this.edgeNo = edgeNo;
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

	public Integer getEdgeNo() {
		return this.edgeNo;
	}

	public void setEdgeNo(Integer edgeNo) {
		this.edgeNo = edgeNo;
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