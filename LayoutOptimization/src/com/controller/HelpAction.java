package com.controller;

import com.opensymphony.xwork2.ActionSupport;

public class HelpAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String about() {
		
		return "about";
		
	}
	
	public String help() {
		return "help";
	}

}
