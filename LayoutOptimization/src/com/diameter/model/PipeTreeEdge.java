package com.diameter.model;

public class PipeTreeEdge {
	private int iID;	//序号
	private int sNode;	//边的起始节点号
	private int eNode;	//边的结束节点号
	private double dLND;
	private double dQND;
	public PipeTreeEdge(int iID, int sNode, int eNode, double dLND, double dQND) {
		super();
		this.iID = iID;
		this.sNode = sNode;
		this.eNode = eNode;
		this.dLND = dLND;
		this.dQND = dQND;
	}
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	public int getsNode() {
		return sNode;
	}
	public void setsNode(int sNode) {
		this.sNode = sNode;
	}
	public int geteNode() {
		return eNode;
	}
	public void seteNode(int eNode) {
		this.eNode = eNode;
	}
	public double getdLND() {
		return dLND;
	}
	public void setdLND(double dLND) {
		this.dLND = dLND;
	}
	public double getdQND() {
		return dQND;
	}
	public void setdQND(double dQND) {
		this.dQND = dQND;
	}
	
	
}
