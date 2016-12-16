package com.model;

public class LContinueAlgorithmModel {
	
	private Integer reportId;
	private Integer projectId;
	private String fa;
	private Double investment;
	private Integer dprojectId;
	
	public LContinueAlgorithmModel() {
		super();
	}

	public LContinueAlgorithmModel(Integer reportId, Integer projectId,
			String fa, Double investment, Integer dprojectId) {
		super();
		this.reportId = reportId;
		this.projectId = projectId;
		this.fa = fa;
		this.investment = investment;
		this.dprojectId = dprojectId;
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

	public String getFa() {
		return fa;
	}

	public void setFa(String fa) {
		this.fa = fa;
	}

	public Double getInvestment() {
		return investment;
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
