package com.layout.model;
/**
 * 屏幕坐标点的结构
 * @author Administrator
 *
 */
public class Point {
	private long x;
	private long y;
	
	public Point() {
		super();
	}
	
	public Point(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}

	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
	
}
