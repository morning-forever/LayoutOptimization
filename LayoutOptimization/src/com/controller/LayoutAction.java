package com.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;


import com.bean.LayoutEdge;
import com.bean.LayoutGaParam;
import com.bean.LayoutGaReport;
import com.bean.LayoutGaReportEdges;
import com.bean.LayoutNode;
import com.bean.LayoutProjectParams;
import com.bean.Project;
import com.dao.LayoutEdgeDAO;
import com.dao.LayoutGaParamDAO;
import com.dao.LayoutGaReportDAO;
import com.dao.LayoutGaReportEdgesDAO;
import com.dao.LayoutNodeDAO;
import com.dao.LayoutProjectParamsDAO;
import com.layout.algorithm.LayoutGA;
import com.layout.algorithm.LayoutIndividual;
import com.layout.model.PipeEdge;
import com.layout.model.PipeNet;
import com.layout.model.PipeTreeNode;
import com.layout.model.Point;
import com.model.LReportModel;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Utils;

public class LayoutAction extends ActionSupport implements RequestAware ,SessionAware{
	
	private Integer id;
	
	private InputStream inputStream;
	
	private Integer reportId;
	
	
	/*private PrintWriter pw;
	
	
	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}*/

	public InputStream getInputStream() {
		return inputStream;
	}

	

	private LayoutNodeDAO lnDAO = new LayoutNodeDAO();
	private LayoutEdgeDAO leDAO = new LayoutEdgeDAO();
	private LayoutGaReportDAO lgDAO=new LayoutGaReportDAO();
	private LayoutProjectParamsDAO lppDAO = new LayoutProjectParamsDAO();
	private LayoutGaParamDAO lgpDAO = new LayoutGaParamDAO();
	private LayoutGaReportEdgesDAO lgresDAO=new LayoutGaReportEdgesDAO();
	//工程参数
	private Double a;
	private Double b;
	private Double vmin;
	//遗传算法参数
	private Integer popsize;
	private Integer maxgen;
	private Double ps;
	private Double pt;
	// 节点参数信息
	private Integer noOfProj;
	private Integer projectId;
	private Integer nodeX;
	private Integer nodeY;
	private Double nodeL;
	private Double nodeR;
	private Double nodePp;
	private Double nodeQl;
	private Double nodeQr;

	// 管道信息
	private Integer snode;
	private Integer enode;

	

	private Map<String, Object> request;
	private Map<String,Object> session;
	
	// private Map<String,Object> application;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String nodeParam() {
		Project project=(Project)session.get("project");
		if(project==null){
			return "error";
		}else if(project.getProjectKind()==2){
			return "error";
		}
		List<LayoutNode> nodes = lnDAO.findNodeByProjectId(project.getProjectId());
		Collections.sort(nodes);
		request.put("nodes", nodes);
		return "nodeParam";
	}
	
	public String nodeParamAddUI() {
		return "nodeParamAddUI";
	}
	
	public String saveNodeParam() {
		LayoutNode ln = new LayoutNode(noOfProj, projectId, nodeX, nodeY,
				nodeL, nodeR, nodePp, nodeQl, nodeQr);
		lnDAO.save(ln);
		return "saveNodeParam";
	}
	
	public String deleteNodeParam(){
		lnDAO.casDeleteById(id);
		return "deleteNodeParam";
	}
	
	public String nodeParamEditUI(){
		LayoutNode ln=lnDAO.getById(id);
		request.put("ln", ln);
		return "nodeParamEditUI";
	}

	public String editNodeParam(){
		LayoutNode ln=new LayoutNode(id, noOfProj, projectId, nodeX, nodeY, nodeL, nodeR, nodePp, nodeQl, nodeQr);
		lnDAO.update(ln);
		return "editNodeParam";
	}
	public String edgeParam() {
		Project project=(Project)session.get("project");
		if(project==null){
			return "error";
		}else if(project.getProjectKind()==2){
			return "error";
		}
		LayoutEdgeDAO leDAO = new LayoutEdgeDAO();
		
		List<LayoutEdge> edges = leDAO.findEdgeByProjectId(project.getProjectId());
		Collections.sort(edges);
		request.put("edges", edges);
		
		return "edgeParam";
	}

	public String edgeParamAddUI() {
		return "edgeParamAddUI";
	}
	public String saveEdgeParam() {
		LayoutEdge le=new LayoutEdge(projectId, snode, enode);
		List<LayoutEdge> edges=leDAO.findEdgeByProjectId(projectId);
		edges.add(le);
		List<LayoutNode> nodes=lnDAO.findNodeByProjectId(projectId);
		Utils.generateNB(edges, nodes);
		for(LayoutEdge edge:edges){
			leDAO.saveOrUpdate(edge);
		}
		return "saveEdgeParam";
	}
	
	public String deleteEdgeParam(){
		Project project=(Project) session.get("project");
		leDAO.deleteById(id);
		List<LayoutEdge> edges=leDAO.findEdgeByProjectId(project.getProjectId());
		List<LayoutNode> nodes=lnDAO.findNodeByProjectId(project.getProjectId());
		Utils.generateNB(edges, nodes);
		for(LayoutEdge edge:edges){
			leDAO.saveOrUpdate(edge);
		}
		return "deleteEdgeParam";
	}
	public String edgeParamEditUI(){
		LayoutEdge layoutEdge=leDAO.getById(id);
		request.put("layoutEdge", layoutEdge);
		return "edgeParamEditUI";
	}
	
	public String editEdgeParam(){
		LayoutEdge le=new LayoutEdge(id,projectId, snode, enode);
		List<LayoutEdge> edges=leDAO.findEdgeByProjectId(projectId);
		edges.add(le);
		List<LayoutNode> nodes=lnDAO.findNodeByProjectId(projectId);
		Utils.generateNB(edges, nodes);
		for(LayoutEdge edge:edges){
			leDAO.saveOrUpdate(edge);
		}
		return "editEdgeParam";
	}
	public String algorithmParam() {
		Project project=(Project)session.get("project");
		if(project==null){
			return "error";
		}else if(project.getProjectKind()==2){
			return "error";
		}
		LayoutGaParam lgp=lgpDAO.findByProjectId(project.getProjectId());
		
		if(lgp!=null){
			request.put("lgp", lgp);
		}else{
			LayoutGaParam lpps=new LayoutGaParam(project.getProjectId(), 10, 50, 0.5, 0.45);
			request.put("lgp", lpps);
			
		}
		return "algorithmParam";
	}
	public String saveAlgorithmParam() {
		LayoutGaParam lg=lgpDAO.findByProjectId(projectId);
		if(lg!=null){
			lg.setMaxgen(maxgen);
			lg.setPopsize(popsize);
			lg.setPs(ps);
			lg.setPt(pt);
		}else{
			lg = new LayoutGaParam(projectId, popsize, maxgen, ps, pt);
		}
		lgpDAO.saveOrUpdate(lg);
		request.put("lgp", lg);
		return "saveAlgorithmParam";
	}
	public String algorithm() {
		Project project=(Project)session.get("project");
		if(project==null){
			return "error";
		}else if(project.getProjectKind()==2){
			return "error";
		}
		
		return "algorithm";
	}

	public String report() {
		Project project=(Project)session.get("project");
		if(project==null){
			return "error";
		}else if(project.getProjectKind()==2){
			return "error";
		}
		List<LReportModel> rms=new ArrayList<LReportModel>();
		List<LayoutGaReport> lgrs=lgDAO.findByProjecId(project.getProjectId());
		
		for(LayoutGaReport lgr:lgrs){
			int reportId= lgr.getReportId();
			List<Integer> edgesNo=lgresDAO.findEdgeNoByReportId(reportId);
			String fa=edgesNo.toString();
			LReportModel rm=new LReportModel(lgr.getReportId(), lgr.getProjectId(), lgr.getInvestment(), fa);
			rms.add(rm);
		}
		
		request.put("rms", rms);
		return "report";
	}

	public String projectParam() {
		Project project=(Project)session.get("project");
		if(project==null){
			return "error";
		}else if(project.getProjectKind()==2){
			return "error";
		}
		LayoutProjectParams lpp =lppDAO.findppByProjectId(project.getProjectId());
		
		if(lpp!=null){
			request.put("pp", lpp);
		}else{
			LayoutProjectParams lpps=new LayoutProjectParams(project.getProjectId(), 1.0, 1.0, 0.5);
			request.put("pp", lpps);
			
		}
		
		return "projectParam";
	}
	public String saveProjectParam() {
		LayoutProjectParams lpp=lppDAO.findppByProjectId(projectId);
		if(lpp!=null){
			lpp.setA(this.a);
			lpp.setB(this.b);
			lpp.setVmin(this.vmin);
		}else{
			lpp=new LayoutProjectParams(projectId, a, b, vmin);
		}
		lppDAO.saveOrUpdate(lpp);
		request.put("pp", lpp);
		return "projectParam";
	}
	public  String calculate() throws IOException  {
		List<LayoutEdge> dbEdges=leDAO.findEdgeByProjectId(projectId);
		Collections.sort(dbEdges);
		List<LayoutNode> dbNodes=lnDAO.findNodeByProjectId(projectId);
		
		List<PipeEdge> edges=new ArrayList<PipeEdge>();
		List<PipeTreeNode> nodes=new ArrayList<PipeTreeNode>();
		
		for(LayoutEdge edge: dbEdges) {
			edges.add(new PipeEdge(edge.getNoOfProj(),8, edge.getSnode(),edge.getEnode()));	
		}
		
		for(LayoutNode node: dbNodes) {
			
			nodes.add(new PipeTreeNode(new Point(node.getNodeX(),node.getNodeY())));
		}
		
		PipeNet pipeNet=new PipeNet(nodes,edges);
		LayoutGA layoutGA=new LayoutGA(pipeNet,10,50,0.5f,0.5f);
		try {
			layoutGA.go();
			List<LayoutIndividual> parents = layoutGA.getParents();
			List<LayoutGaReport> lgrs=lgDAO.findByProjecId(projectId);
			int max;
			if(lgrs==null){
				max=0;
			}else if(lgrs.size()==0){
				max=0;
			}else{
				max=lgDAO.selectMaxOfReportId();
			}
			int[][] edgesNo = new int[10][9];
			for (int j = 0; j < parents.size(); j++) {
				int[] chrom = parents.get(j).getChrom();
				int n = 0;
				for (int i = 0; i < chrom.length; i++) {
					if (chrom[i] == 1) {
						edgesNo[j][n] = i + 1;
						n++;
					}
				}
				LayoutGaReport lgr=new LayoutGaReport();
				lgr.setReportId(max+1);
				/*System.out.println(max);*/
				lgr.setProjectId(projectId);
				lgr.setInvestment(parents.get(j).getFitness());
				lgDAO.save(lgr);
				for(int i=0;i<chrom.length;i++){
					if(chrom[i]==1){
						LayoutGaReportEdges lre=new LayoutGaReportEdges();
						lre.setEdgeNo(i+1);
						lre.setProjectId(projectId);
						lre.setReportId(max+1);
						lgresDAO.save(lre);
					}
				}
				max++;
				
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
		//System.out.println(1);
		/*HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/xml");
		 response.setCharacterEncoding("UTF-8");

		 response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
		 response.setHeader("Pragma","no-cache"); //HTTP 1.0
		 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
		PrintWriter pw= response.getWriter();
		pw.write("true");*/
		//inputStream=new StringBufferInputStream("true");
		
		//		return SUCCESS;
		//return SUCCESS;
		
		/*System.out.println("zzzz");
		HttpServletResponse response=ServletActionContext.getResponse();
		
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		
		String jsonString="{\"id\":1, \"success\":true}";
		out.println(jsonString);
		out.flush();
		out.close();
		System.out.println(jsonString);*/
		
	}
	
	public String showModel(){
		List<Integer> edgesNo=lgresDAO.findEdgeNoByReportId(reportId);
		Project project=(Project) session.get("project");
		List<LayoutEdge> edges=new ArrayList<LayoutEdge>();
		for(Integer edgeNo :edgesNo){
			LayoutEdge edge=leDAO.findEdgeByProjectIdAndNoOfProj(project.getProjectId(),edgeNo );
			edges.add(edge);
		}
		List<LayoutNode> nodes=new ArrayList<LayoutNode>();
		for(LayoutEdge edge:edges){
			LayoutNode node1=lnDAO.findNodeByNoOfProjAndProjectId(project.getProjectId(),edge.getSnode());
			LayoutNode node2=lnDAO.findNodeByNoOfProjAndProjectId(project.getProjectId(),edge.getEnode());
			nodes.add(node1);
			nodes.add(node2);
		}
		String nodesJSON=Utils.getNodesJSON(nodes);
		String edgesJSON=Utils.getEdgesJSON(edges);
		
		request.put("nodesJSON", nodesJSON);
		request.put("edgesJSON", edgesJSON);
		return "showModel";
	}

	public String nodeIsExist() throws UnsupportedEncodingException{
		List<LayoutNode> nodes=lnDAO.findNodeByProjectId(projectId);
		if(Utils.layoutIsExist(nodes, noOfProj)){
			inputStream=new ByteArrayInputStream("1".getBytes("UTF-8"));
		}
		return SUCCESS;
	}
	
	public String nodeNotExist() throws UnsupportedEncodingException{
		List<LayoutNode> nodes=lnDAO.findNodeByProjectId(projectId);
		List<LayoutEdge> edges=leDAO.findEdgeByProjectId(projectId);
		if(!Utils.layoutIsExist(nodes, snode)&&Utils.layoutIsExist(nodes, enode)){
			inputStream=new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else if(Utils.layoutIsExist(nodes, snode)&&!Utils.layoutIsExist(nodes, enode)){
			inputStream=new ByteArrayInputStream("2".getBytes("UTF-8"));
		}else if(!Utils.layoutIsExist(nodes, snode)&&!Utils.layoutIsExist(nodes, enode)){
			inputStream=new ByteArrayInputStream("3".getBytes("UTF-8"));
		}else if(Utils.layoutEdgeIsExist(snode, enode, edges)){
			inputStream=new ByteArrayInputStream("4".getBytes("UTF-8"));
		}else if(Utils.layoutIsExist(nodes, snode)&&Utils.layoutIsExist(nodes, enode)&&!Utils.layoutEdgeIsExist(snode, enode, edges)&&!snode.equals(enode)){
			inputStream=new ByteArrayInputStream("5".getBytes("UTF-8"));
		}else if(snode.equals(enode)){
			inputStream=new ByteArrayInputStream("6".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

	

	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	/*
	 * @Override public void setApplication(Map<String, Object> application) {
	 * this.application=application; }
	 */
	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public Double getVmin() {
		return vmin;
	}
	public void setVmin(Double vmin) {
		this.vmin = vmin;
	}
	public Integer getNoOfProj() {
		return noOfProj;
	}

	public void setNoOfProj(Integer noOfProj) {
		this.noOfProj = noOfProj;
	}

	public Integer getProjectId() {
		return projectId;

	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getNodeX() {
		return nodeX;
	}

	public void setNodeX(Integer nodeX) {
		this.nodeX = nodeX;
	}

	public Integer getNodeY() {
		return nodeY;
	}

	public void setNodeY(Integer nodeY) {
		this.nodeY = nodeY;
	}

	public Double getNodeL() {
		return nodeL;
	}

	public void setNodeL(Double nodeL) {
		this.nodeL = nodeL;
	}

	public Double getNodeR() {
		return nodeR;
	}

	public void setNodeR(Double nodeR) {
		this.nodeR = nodeR;
	}

	public Double getNodePp() {
		return nodePp;
	}

	public void setNodePp(Double nodePp) {
		this.nodePp = nodePp;
	}

	public Double getNodeQl() {
		return nodeQl;
	}

	public void setNodeQl(Double nodeQl) {
		this.nodeQl = nodeQl;
	}

	public Double getNodeQr() {
		return nodeQr;
	}

	public void setNodeQr(Double nodeQr) {
		this.nodeQr = nodeQr;
	}

	public Integer getSnode() {
		return snode;
	}

	public void setSnode(Integer snode) {
		this.snode = snode;
	}

	public Integer getEnode() {
		return enode;
	}

	public void setEnode(Integer enode) {
		this.enode = enode;
	}

	public Integer getPopsize() {
		return popsize;
	}

	public void setPopsize(Integer popsize) {
		this.popsize = popsize;
	}

	public Integer getMaxgen() {
		return maxgen;
	}

	public void setMaxgen(Integer maxgen) {
		this.maxgen = maxgen;
	}

	public Double getPs() {
		return ps;
	}

	public void setPs(Double ps) {
		this.ps = ps;
	}

	public Double getPt() {
		return pt;
	}

	public void setPt(Double pt) {
		this.pt = pt;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	
	
}
