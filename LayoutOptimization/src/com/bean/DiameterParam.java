package com.bean;
/**
 * Êý¾Ý¿â±í£¨diameter_proj_param£©
 * @author Administrator
 *
 */
public class DiameterParam {
	private int iZST;
	private double dCE;
	private double density;
	private double dLumda;
	private double dCOP;
	private double dAlpha;
	
	private double dPumpG;
	private double dPumpN;
	private int dPumpT;
	private double dPumpK;
	private double dPumpA;
	
	private double dPipeTS;
	private double dPipeTCS;
	private double dPipeTCR;
	private double dPipeT;
	
	
	
	public DiameterParam() {
		super();
	}
	public DiameterParam(int iZST, double dCE, double dP, double dLumda,
			double dCOP, double dAlpha, double dPumpG, double dPumpN,
			int dPumpT, double dPipeTS, double dPipeTCS, double dPipeTCR,double dPumpK,double dPumpA,double dPipeT) {
		super();
		this.iZST = iZST;
		this.dCE = dCE;
		this.density = dP;
		this.dLumda = dLumda;
		this.dCOP = dCOP;
		this.dAlpha = dAlpha;
		this.dPumpG = dPumpG;
		this.dPumpN = dPumpN;
		this.dPumpT = dPumpT;
		this.dPipeTS = dPipeTS;
		this.dPipeTCS = dPipeTCS;
		this.dPipeTCR = dPipeTCR;
		this.dPumpK=dPumpK;
		this.dPumpA=dPumpA;
		this.dPipeT=dPipeT;
	}
	public int getiZST() {
		return iZST;
	}
	public void setiZST(int iZST) {
		this.iZST = iZST;
	}
	public double getdCE() {
		return dCE;
	}
	public void setdCE(double dCE) {
		this.dCE = dCE;
	}
	public double getDensity() {
		return density;
	}
	public void setDensity(double dP) {
		this.density = dP;
	}
	public double getdLumda() {
		return dLumda;
	}
	public void setdLumda(double dLumda) {
		this.dLumda = dLumda;
	}
	public double getdCOP() {
		return dCOP;
	}
	public void setdCOP(double dCOP) {
		this.dCOP = dCOP;
	}
	public double getdAlpha() {
		return dAlpha;
	}
	public void setdAlpha(double dAlpha) {
		this.dAlpha = dAlpha;
	}
	public double getdPumpG() {
		return dPumpG;
	}
	public void setdPumpG(double dPumpG) {
		this.dPumpG = dPumpG;
	}
	public double getdPumpN() {
		return dPumpN;
	}
	public void setdPumpN(double dPumpN) {
		this.dPumpN = dPumpN;
	}
	public int getdPumpT() {
		return dPumpT;
	}
	public void setdPumpT(int dPumpT) {
		this.dPumpT = dPumpT;
	}
	public double getdPipeTS() {
		return dPipeTS;
	}
	public void setdPipeTS(double dPipeTS) {
		this.dPipeTS = dPipeTS;
	}
	public double getdPipeTCS() {
		return dPipeTCS;
	}
	public void setdPipeTCS(double dPipeTCS) {
		this.dPipeTCS = dPipeTCS;
	}
	public double getdPipeTCR() {
		return dPipeTCR;
	}
	public void setdPipeTCR(double dPipeTCR) {
		this.dPipeTCR = dPipeTCR;
	}
	public double getdPumpK() {
		return dPumpK;
	}
	public void setdPumpK(double dPumpK) {
		this.dPumpK = dPumpK;
	}
	public double getdPumpA() {
		return dPumpA;
	}
	public void setdPumpA(double dPumpA) {
		this.dPumpA = dPumpA;
	}
	public double getdPipeT() {
		return dPipeT;
	}
	public void setdPipeT(double dPipeT) {
		this.dPipeT = dPipeT;
	}
	
	
	
}
