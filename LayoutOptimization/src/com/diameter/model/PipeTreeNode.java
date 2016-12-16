package com.diameter.model;

import com.layout.model.Point;

public class PipeTreeNode {
	private int id; 	//id号
	private Point nw;	//节点位置，手动输入
	private double l;	//节点冷负荷需求，手动输入
	private double r;	//节点热负荷需求，手动输入
	private double pp;	//节点压力需求，手动输入
	private double ql;	//节点冷负荷流量需求，手动输入
	private double qr;	//节点热负荷流量去求，手动输入
	
	public PipeTreeNode() {
		super();
	}
	
	public PipeTreeNode(Point nw) {
		super();
		this.nw = nw;
	}

	public PipeTreeNode(int id, Point nw, double l, double r, double pp,
			double ql, double qr) {
		super();
		this.id = id;
		this.nw = nw;
		this.l = l;
		this.r = r;
		this.pp = pp;
		this.ql = ql;
		this.qr = qr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Point getNw() {
		return nw;
	}
	public void setNw(Point nw) {
		this.nw = nw;
	}
	public double getL() {
		return l;
	}
	public void setL(double l) {
		this.l = l;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getPp() {
		return pp;
	}
	public void setPp(double pp) {
		this.pp = pp;
	}
	public double getQl() {
		return ql;
	}
	public void setQl(double ql) {
		this.ql = ql;
	}
	public double getQr() {
		return qr;
	}
	public void setQr(double qr) {
		this.qr = qr;
	}
	
}
