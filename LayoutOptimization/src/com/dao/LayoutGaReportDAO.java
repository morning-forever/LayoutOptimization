package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.bean.LayoutGaReport;

public class LayoutGaReportDAO extends BasicDAO<LayoutGaReport>{

	public List<LayoutGaReport> findByProjecId(Integer projectId) {
		Session session=getSession();
		@SuppressWarnings("unchecked")
		List<LayoutGaReport> lgrs=  session.createQuery("from LayoutGaReport lgr where lgr.projectId = :projectId")
				.setInteger("projectId", projectId).list();
		session.close();
		return lgrs;
	}

	public int selectMaxOfReportId() {
		
		return (Integer)getSession().createSQLQuery("select max(report_id) from layout_ga_report").uniqueResult();
	}

	public LayoutGaReport findByReportId(Integer reportId) {
		
		return (LayoutGaReport) getSession().createQuery("from LayoutGaReport lgr where lgr.reportId = :reportId")
				.setInteger("reportId", reportId).uniqueResult();
	}

}
