package com.bean;

/**
 * Project entity. @author MyEclipse Persistence Tools
 */

public class Project implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4732721344654064156L;
	private Integer id;
	private Integer projectId;
	private String projectName;
	private Integer projectKind;

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** full constructor */
	public Project(Integer projectId,String projectName, Integer projectKind) {
		this.projectId=projectId;
		this.projectName = projectName;
		this.projectKind = projectKind;
	}

	// Property accessors

	
	public Integer getProjectId() {
		return this.projectId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectKind() {
		return this.projectKind;
	}

	public void setProjectKind(Integer projectKind) {
		this.projectKind = projectKind;
	}

	
}