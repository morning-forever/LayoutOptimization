package com.bean;

/**
 * 从数据库表(layout_proj_param)读出来的实体对象
 * @author Administrator
 *
 */
public class LayoutParam {
	private double aCoef;
	private double bCoef;
	private double vMin;
	public double getaCoef() {
		return aCoef;
	}
	public void setaCoef(double aCoef) {
		this.aCoef = aCoef;
	}
	public double getbCoef() {
		return bCoef;
	}
	public void setbCoef(double bCoef) {
		this.bCoef = bCoef;
	}
	public double getvMin() {
		return vMin;
	}
	public void setvMin(double vMin) {
		this.vMin = vMin;
	}
	
}
