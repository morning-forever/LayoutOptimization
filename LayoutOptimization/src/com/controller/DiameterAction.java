package com.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.bean.DiameterEdge;
import com.bean.DiameterGaParam;
import com.bean.DiameterNode;
import com.bean.DiameterProjectParams;
import com.bean.LayoutGaReport;
import com.bean.Project;
import com.dao.DiameterEdgeDAO;
import com.dao.DiameterGaParamDAO;
import com.dao.DiameterNodeDAO;
import com.dao.DiameterProjectParamsDAO;
import com.dao.LayoutGaReportDAO;
import com.dao.LayoutGaReportEdgesDAO;
import com.dao.ProjectDAO;
import com.model.LContinueAlgorithmModel;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Utils;

public class DiameterAction extends ActionSupport implements RequestAware,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DiameterNodeDAO dnDAO = new DiameterNodeDAO();
	private DiameterEdgeDAO deDAO = new DiameterEdgeDAO();
	private LayoutGaReportDAO lgDAO = new LayoutGaReportDAO();
	private ProjectDAO pDAO = new ProjectDAO();
	private LayoutGaReportEdgesDAO lgresDAO = new LayoutGaReportEdgesDAO();

	private Integer id;

	private InputStream inputStream;
	public InputStream getInputStream() {
		return this.inputStream;
	}
	private Integer reportId;
	// 节点信息
	private Integer noOfProj;
	private Integer projectId;
	private Integer nodeXnd;
	private Integer nodeYnd;
	private Double nodeL;
	private Double nodeR;
	private Double nodePp;
	private Double nodeQl;
	private Double nodeQr;

	// 管道信息
	private Integer snode;
	private Integer enode;
	private Double edgeLnd;
	private Double edgeQnd;

	private Map<String, Object> request;
	private Map<String, Object> session;

	// 工程参数信息
	private Integer zst;
	private Double ce;
	private Double density;
	private Double lumda;
	private Double cop;
	private Double alpha;
	private Double pumpN;
	private Integer pumpT;
	private Double pumpK;
	private Double pumpTao;
	private Double pipeTs;
	private Double pipeTcs;
	private Double pipeTcr;
	private Double pipeT;

	// 遗传算法参数信息
	private Integer popsize;
	private Integer maxgen;
	private String pws;
	private String pss;
	private String pbws;
	private String pbdx;

	public String nodeParam() {
		Project project = (Project) session.get("project");
		if (project == null) {
			return "error";
		} else if (project.getProjectKind() == 1) {
			return "error";
		}
		List<DiameterNode> nodes = dnDAO.findNodeByProjectId(project
				.getProjectId());
		Collections.sort(nodes);
		request.put("nodes", nodes);
		return "nodeParam";
	}

	public String nodeParamAddUI() {
		return "nodeParamAddUI";
	}

	public String saveNodeParam() {

		DiameterNode dn = new DiameterNode(noOfProj, projectId, nodeXnd,
				nodeYnd, nodeL, nodeR, nodePp, nodeQl, nodeQr);
		dnDAO.save(dn);
		return "saveNodeParam";
	}

	public String deleteNodeParam() {
		dnDAO.casDeleteById(id);
		return "deleteNodeParam";
	}

	public String nodeParamEditUI() {
		DiameterNode dn = dnDAO.getById(id);
		request.put("dn", dn);
		return "nodeParamEditUI";
	}

	public String editNodeParam() {
		DiameterNode dn = new DiameterNode(id, noOfProj, projectId, nodeXnd,
				nodeYnd, nodeL, nodeR, nodePp, nodeQl, nodeQr);
		dnDAO.update(dn);
		return "editNodeParam";
	}

	public String edgeParam() {
		Project project = (Project) session.get("project");
		if (project == null) {
			return "error";
		} else if (project.getProjectKind() == 1) {
			return "error";
		}
		List<DiameterEdge> edges = deDAO.findEdgeByProjectId(project
				.getProjectId());
		request.put("edges", edges);
		return "edgeParam";
	}

	public String edgeParamAddUI() {
		return "edgeParamAddUI";
	}

	public String saveEdgeParam() {

		DiameterEdge de = new DiameterEdge(projectId, snode, enode, edgeLnd,
				edgeQnd);
		deDAO.save(de);
		return "edgeParamAddUI";
	}

	public String deleteEdgeParam() {
		deDAO.deleteById(id);
		return "deleteEdgeParam";
	}

	public String edgeParamEditUI() {
		DiameterEdge de = deDAO.getById(id);
		request.put("de", de);
		return "edgeParamEditUI";
	}

	public String editEdgeParam() {
		DiameterEdge de = new DiameterEdge(id, noOfProj, projectId, snode,
				enode, edgeLnd, edgeQnd);
		deDAO.update(de);
		return "editEdgeParam";
	}

	public String algorithmParam() {
		Project project = (Project) session.get("project");
		if (project == null) {
			return "error";
		} else if (project.getProjectKind() == 1) {
			return "error";
		}
		return "algorithmParam";
	}

	public String continueAlgorithmUI() {
		Project project = (Project) session.get("project");
		if (project == null) {
			return "error";
		} else if (project.getProjectKind() == 2) {
			return "error";
		}

		List<LContinueAlgorithmModel> cams = new ArrayList<LContinueAlgorithmModel>();
		List<LayoutGaReport> lgrs = lgDAO
				.findByProjecId(project.getProjectId());
		for (LayoutGaReport lgr : lgrs) {
			List<Integer> edgesNo = lgresDAO.findEdgeNoByReportId(lgr
					.getReportId());
			String fa = edgesNo.toString();
			LContinueAlgorithmModel cam = new LContinueAlgorithmModel(
					lgr.getReportId(), lgr.getProjectId(), fa,
					lgr.getInvestment(), lgr.getDprojectId());
			cams.add(cam);
		}

		request.put("cams", cams);
		return "nextToDiameter";
	}

	public String continueAlgorithm() {
		if (reportId == null) {
			return "error";
		}
		Project sessionProject=(Project) session.get("project");

		LayoutGaReport lgr = lgDAO.findByReportId(reportId);
		Integer newProjectId = pDAO.selectMaxOfProjectId() + 1;
		Project project = new Project(
				newProjectId,
				sessionProject.getProjectName() + "布局优化方案:" + lgr.getReportId(),
				2);
		pDAO.save(project);
		lgr.setDprojectId(newProjectId);
		lgDAO.update(lgr);
		session.put("project", project);

		return "continueAlgorithm";
	}

	public String algorithm() {
		Project project = (Project) session.get("project");
		if (project == null) {
			return "error";
		} else if (project.getProjectKind() == 1) {
			return "error";
		}
		return "algorithm";
	}

	public String report() {
		Project project = (Project) session.get("project");
		if (project == null) {
			return "error";
		} else if (project.getProjectKind() == 1) {
			return "error";
		}

		return "report";
	}

	public String projectParam() {
		Project project = (Project) session.get("project");
		if (project == null) {
			return "error";
		} else if (project.getProjectKind() == 1) {
			return "error";
		}
		return "projectParam";
	}

	public String saveProjectParams() {
		DiameterProjectParamsDAO dppDAO = new DiameterProjectParamsDAO();
		DiameterProjectParams dpp = new DiameterProjectParams(projectId, zst,
				ce, density, lumda, cop, alpha, pumpN, pumpT, pumpK, pumpTao,
				pipeTs, pipeTcs, pipeTcr, pipeT);
		dppDAO.save(dpp);

		return "projectParam";
	}

	public String saveGaParams() {
		DiameterGaParam dgp = new DiameterGaParam(projectId, popsize, maxgen,
				pws, pss, pbws, pbdx);
		DiameterGaParamDAO dgpDAO = new DiameterGaParamDAO();
		dgpDAO.save(dgp);
		return "algorithmParam";
	}

	public String nodeNotExist() throws UnsupportedEncodingException {
		List<DiameterNode> nodes = dnDAO.findNodeByProjectId(projectId);
		List<DiameterEdge> edges = deDAO.findEdgeByProjectId(projectId);
		if (!Utils.diameterIsExist(nodes, snode)
				&& Utils.diameterIsExist(nodes, enode)) {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} else if (Utils.diameterIsExist(nodes, snode)
				&& !Utils.diameterIsExist(nodes, enode)) {
			inputStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
		} else if (!Utils.diameterIsExist(nodes, snode)
				&& !Utils.diameterIsExist(nodes, enode)) {
			inputStream = new ByteArrayInputStream("3".getBytes("UTF-8"));
		} else if (Utils.diameterIsExist(snode, enode, edges)) {
			inputStream = new ByteArrayInputStream("4".getBytes("UTF-8"));
		} else if (Utils.diameterIsExist(nodes, snode)
				&& Utils.diameterIsExist(nodes, enode)
				&& !Utils.diameterIsExist(snode, enode, edges)
				&& !snode.equals(enode)) {
			inputStream = new ByteArrayInputStream("5".getBytes("UTF-8"));
		} else if (snode.equals(enode)) {
			inputStream = new ByteArrayInputStream("6".getBytes("UTF-8"));
		}
		return SUCCESS;
	}

	public String nodeIsExist() throws UnsupportedEncodingException {
		List<DiameterNode> nodes = dnDAO.findNodeByProjectId(projectId);
		if (Utils.diameterIsExist(nodes, noOfProj)) {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}
		return SUCCESS;
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

	public Integer getNodeXnd() {
		return nodeXnd;
	}

	public void setNodeXnd(Integer nodeXnd) {
		this.nodeXnd = nodeXnd;
	}

	public Integer getNodeYnd() {
		return nodeYnd;
	}

	public void setNodeYnd(Integer nodeYnd) {
		this.nodeYnd = nodeYnd;
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

	public Double getEdgeLnd() {
		return edgeLnd;
	}

	public void setEdgeLnd(Double edgeLnd) {
		this.edgeLnd = edgeLnd;
	}

	public Double getEdgeQnd() {
		return edgeQnd;
	}

	public void setEdgeQnd(Double edgeQnd) {
		this.edgeQnd = edgeQnd;
	}

	public Integer getZst() {
		return zst;
	}

	public void setZst(Integer zst) {
		this.zst = zst;
	}

	public Double getCe() {
		return ce;
	}

	public void setCe(Double ce) {
		this.ce = ce;
	}

	public Double getDensity() {
		return density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public Double getLumda() {
		return lumda;
	}

	public void setLumda(Double lumda) {
		this.lumda = lumda;
	}

	public Double getCop() {
		return cop;
	}

	public void setCop(Double cop) {
		this.cop = cop;
	}

	public Double getAlpha() {
		return alpha;
	}

	public void setAlpha(Double alpha) {
		this.alpha = alpha;
	}

	public Double getPumpN() {
		return pumpN;
	}

	public void setPumpN(Double pumpN) {
		this.pumpN = pumpN;
	}

	public Integer getPumpT() {
		return pumpT;
	}

	public void setPumpT(Integer pumpT) {
		this.pumpT = pumpT;
	}

	public Double getPumpK() {
		return pumpK;
	}

	public void setPumpK(Double pumpK) {
		this.pumpK = pumpK;
	}

	public Double getPumpTao() {
		return pumpTao;
	}

	public void setPumpTao(Double pumpTao) {
		this.pumpTao = pumpTao;
	}

	public Double getPipeTs() {
		return pipeTs;
	}

	public void setPipeTs(Double pipeTs) {
		this.pipeTs = pipeTs;
	}

	public Double getPipeTcs() {
		return pipeTcs;
	}

	public void setPipeTcs(Double pipeTcs) {
		this.pipeTcs = pipeTcs;
	}

	public Double getPipeTcr() {
		return pipeTcr;
	}

	public void setPipeTcr(Double pipeTcr) {
		this.pipeTcr = pipeTcr;
	}

	public Double getPipeT() {
		return pipeT;
	}

	public void setPipeT(Double pipeT) {
		this.pipeT = pipeT;
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

	public String getPws() {
		return pws;
	}

	public void setPws(String pws) {
		this.pws = pws;
	}

	public String getPss() {
		return pss;
	}

	public void setPss(String pss) {
		this.pss = pss;
	}

	public String getPbws() {
		return pbws;
	}

	public void setPbws(String pbws) {
		this.pbws = pbws;
	}

	public String getPbdx() {
		return pbdx;
	}

	public void setPbdx(String pbdx) {
		this.pbdx = pbdx;
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

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
