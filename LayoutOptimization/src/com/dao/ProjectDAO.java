package com.dao;

import org.hibernate.Session;

import com.bean.Project;

public class ProjectDAO extends BasicDAO<Project>{
	Session session =getSession();
	public int selectMaxOfProjectId(){
		Integer max= (Integer)session.createSQLQuery("select max(project_id) from project ").uniqueResult();
		session.close();
		return max;
	}
}
