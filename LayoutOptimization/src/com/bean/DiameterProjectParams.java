package com.bean;

/**
 * DiameterProjectParams entity. @author MyEclipse Persistence Tools
 */

public class DiameterProjectParams implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5780562004021763648L;
	// Fields

	private Integer id;
	private Integer projectId;
	private Integer zst;
	private Double ce;
	private Double density;
	private Double lumda;
	private Double cop;
	private Double alpha;
	private Double pumpN;
	private Integer pumpT;
	private Double pumpK;
	private Double pumpTao;
	private Double pipeTs;
	private Double pipeTcs;
	private Double pipeTcr;
	private Double pipeT;

	// Constructors

	/** default constructor */
	public DiameterProjectParams() {
	}

	/** full constructor */
	public DiameterProjectParams(Integer projectId, Integer zst, Double ce,
			Double density, Double lumda, Double cop, Double alpha,
			Double pumpN, Integer pumpT, Double pumpK, Double pumpTao,
			Double pipeTs, Double pipeTcs, Double pipeTcr, Double pipeT) {
		this.projectId = projectId;
		this.zst = zst;
		this.ce = ce;
		this.density = density;
		this.lumda = lumda;
		this.cop = cop;
		this.alpha = alpha;
		this.pumpN = pumpN;
		this.pumpT = pumpT;
		this.pumpK = pumpK;
		this.pumpTao = pumpTao;
		this.pipeTs = pipeTs;
		this.pipeTcs = pipeTcs;
		this.pipeTcr = pipeTcr;
		this.pipeT = pipeT;
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

	public Integer getZst() {
		return this.zst;
	}

	public void setZst(Integer zst) {
		this.zst = zst;
	}

	public Double getCe() {
		return this.ce;
	}

	public void setCe(Double ce) {
		this.ce = ce;
	}

	public Double getDensity() {
		return this.density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public Double getLumda() {
		return this.lumda;
	}

	public void setLumda(Double lumda) {
		this.lumda = lumda;
	}

	public Double getCop() {
		return this.cop;
	}

	public void setCop(Double cop) {
		this.cop = cop;
	}

	public Double getAlpha() {
		return this.alpha;
	}

	public void setAlpha(Double alpha) {
		this.alpha = alpha;
	}

	public Double getPumpN() {
		return this.pumpN;
	}

	public void setPumpN(Double pumpN) {
		this.pumpN = pumpN;
	}

	public Integer getPumpT() {
		return this.pumpT;
	}

	public void setPumpT(Integer pumpT) {
		this.pumpT = pumpT;
	}

	public Double getPumpK() {
		return this.pumpK;
	}

	public void setPumpK(Double pumpK) {
		this.pumpK = pumpK;
	}

	public Double getPumpTao() {
		return this.pumpTao;
	}

	public void setPumpTao(Double pumpTao) {
		this.pumpTao = pumpTao;
	}

	public Double getPipeTs() {
		return this.pipeTs;
	}

	public void setPipeTs(Double pipeTs) {
		this.pipeTs = pipeTs;
	}

	public Double getPipeTcs() {
		return this.pipeTcs;
	}

	public void setPipeTcs(Double pipeTcs) {
		this.pipeTcs = pipeTcs;
	}

	public Double getPipeTcr() {
		return this.pipeTcr;
	}

	public void setPipeTcr(Double pipeTcr) {
		this.pipeTcr = pipeTcr;
	}

	public Double getPipeT() {
		return this.pipeT;
	}

	public void setPipeT(Double pipeT) {
		this.pipeT = pipeT;
	}

}