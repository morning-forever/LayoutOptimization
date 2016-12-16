package com.layout.model;
/**
 * ����ģ���еĽڵ�Ľṹ
 * @author Administrator
 *
 */
public class PipeTreeNode {
	
	private int id; 	//id��
	private Point nw;	//�ڵ�λ�ã��ֶ�����
	private double l;	//�ڵ��为�������ֶ�����
	private double r;	//�ڵ��ȸ��������ֶ�����
	private double pp;	//�ڵ�ѹ�������ֶ�����
	private double ql;	//�ڵ��为�����������ֶ�����
	private double qr;	//�ڵ��ȸ�������ȥ���ֶ�����
	
	public PipeTreeNode() {
		super();
	}
	public PipeTreeNode(Point nw){
		this.nw=nw;
	}
	public PipeTreeNode(int id, Point nw, double l, double r, double pp, double ql,
			double qr) {
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
