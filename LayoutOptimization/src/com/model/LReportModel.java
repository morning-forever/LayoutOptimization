package com.model;

public class LReportModel {
	private Integer reportId;
	private Integer projectId;
	private Double investment;
	private String fa;
	
	public LReportModel(){
		super();
	}
	public LReportModel(Integer reportId, Integer projectId, Double investment,
			String fa) {
		super();
		this.reportId = reportId;
		this.projectId = projectId;
		this.investment = investment;
		this.fa = fa;
	}
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Double getInvestment() {
		return investment;
	}
	public void setInvestment(Double investment) {
		this.investment = investment;
	}
	public String getFa() {
		return fa;
	}
	public void setFa(String fa) {
		this.fa = fa;
	}
	
}
