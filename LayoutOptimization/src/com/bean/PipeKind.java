package com.bean;
/**
 * Êý¾Ý¿â±í£¨pipe_kind£©
 * @author Administrator
 *
 */
public class PipeKind {
	private int iID;
	private double dDN;
	private double dWKHD;
	private double dBWHD;
	public PipeKind(int iID, double dDN, double dBWHD, double dWKHD) {
		super();
		this.iID = iID;
		this.dDN = dDN;
		this.dWKHD = dWKHD;
		this.dBWHD = dBWHD;
	}
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	public double getdDN() {
		return dDN;
	}
	public void setdDN(double dDN) {
		this.dDN = dDN;
	}
	public double getdWKHD() {
		return dWKHD;
	}
	public void setdWKHD(double dWKHD) {
		this.dWKHD = dWKHD;
	}
	public double getdBWHD() {
		return dBWHD;
	}
	public void setdBWHD(double dBWHD) {
		this.dBWHD = dBWHD;
	}
	
	
}
