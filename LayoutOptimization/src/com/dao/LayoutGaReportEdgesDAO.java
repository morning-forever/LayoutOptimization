package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.bean.LayoutGaReportEdges;

public class LayoutGaReportEdgesDAO extends BasicDAO<LayoutGaReportEdges>{

	public List<Integer> findEdgeNoByReportId(Integer reportId) {
		Session session=getSession();
		@SuppressWarnings("unchecked")
		List<Integer> lgres=session.createQuery("select lgres.edgeNo from LayoutGaReportEdges lgres where lgres.reportId = :reportId ")
		.setInteger("reportId", reportId).list();
		session.close();
		return lgres;
	}

}
