package com.bean;

/**
 * DiameterGaParam entity. @author MyEclipse Persistence Tools
 */

public class DiameterGaParam implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4841811450037310909L;
	private Integer id;
	private Integer projectId;
	private Integer popsize;
	private Integer maxgen;
	private String pws;
	private String pss;
	private String pbws;
	private String pbdx;

	// Constructors

	/** default constructor */
	public DiameterGaParam() {
	}

	/** full constructor */
	public DiameterGaParam(Integer projectId, Integer popsize, Integer maxgen,
			String pws, String pss, String pbws, String pbdx) {
		this.projectId = projectId;
		this.popsize = popsize;
		this.maxgen = maxgen;
		this.pws = pws;
		this.pss = pss;
		this.pbws = pbws;
		this.pbdx = pbdx;
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

	public String getPws() {
		return this.pws;
	}

	public void setPws(String pws) {
		this.pws = pws;
	}

	public String getPss() {
		return this.pss;
	}

	public void setPss(String pss) {
		this.pss = pss;
	}

	public String getPbws() {
		return this.pbws;
	}

	public void setPbws(String pbws) {
		this.pbws = pbws;
	}

	public String getPbdx() {
		return this.pbdx;
	}

	public void setPbdx(String pbdx) {
		this.pbdx = pbdx;
	}

}