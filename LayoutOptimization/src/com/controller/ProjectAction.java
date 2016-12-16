package com.controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bean.LayoutEdge;
import com.bean.LayoutNode;
import com.bean.Project;
import com.dao.LayoutEdgeDAO;
import com.dao.LayoutNodeDAO;
import com.dao.ProjectDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Utils;

public class ProjectAction extends ActionSupport implements RequestAware,SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProjectDAO pDAO=new ProjectDAO();
	
	private Integer id;
	
	private Integer projectId;
	
	private String projectName;
	private Integer projectKind;

	private Map<String,Object> request;
	private Map<String,Object> session;
	
	private LayoutNodeDAO  lnDAO=new LayoutNodeDAO();
	private LayoutEdgeDAO leDAO=new LayoutEdgeDAO();
	
	public String list(){
		List<Project> projects=pDAO.findAll();
		request.put("projects",projects);
		return "list";
	}
	
	public String openProject(){
		Project project=pDAO.getById(id);
		List<LayoutNode> nodes=lnDAO.findNodeByProjectId(project.getProjectId());
		List<LayoutEdge> edges=leDAO.findEdgeByProjectId(project.getProjectId());
		String nodesJSON=Utils.getNodesJSON(nodes);
		String edgesJSON=Utils.getEdgesJSON(edges);
		
		session.put("project", project);
		request.put("nodesJSON", nodesJSON);
		request.put("edgesJSON", edgesJSON);
		return "openProject";
	}
	
	public String newProject(){
		List<Project> projects=pDAO.findAll();
		request.put("projects",projects);
		return "newProject";
	}
	
	public String addUI(){
		return "addUI";
	}

	

	public String save(){
		Project proj=new Project(projectId,projectName, projectKind);
		pDAO.save(proj);
		return "save";
	}
	
	public String delete(){
		pDAO.deleteById(id);
		return "delete";
	}
	
	public String editUI(){
		System.out.println(id);
		Project proj=pDAO.getById(id);
		request.put("proj", proj);
		return "editUI";
	}
	
	public String edit(){
		Project proj=new Project(projectId, projectName, projectKind);
		pDAO.update(proj);
		return "edit";
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectKind() {
		return projectKind;
	}

	public void setProjectKind(Integer projectKind) {
		this.projectKind = projectKind;
	}
	
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session=session;
	}
	
	

}
