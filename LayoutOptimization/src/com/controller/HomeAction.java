package com.controller;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**Index*/
	public String index(){
		return "index";
	}
	

	/**Top*/
	public String top(){
		
		return "top";
	}
	
	/**Left*/
	public String left() {
		return "left";
	}
	
	/**Right*/
	public String right() {
		return "right";
	}

	/**Bottom*/
	public String bottom() {
		return "bottom";
	}
}
