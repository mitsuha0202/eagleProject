package com.kh.eg.admin.model.vo;

import java.math.BigDecimal;

public class Report implements java.io.Serializable{
	
	private String itemNo;
	private java.math.BigDecimal reportCount;
	private String title;
	private String memberId;
	private String status;
	
	public void Report() {}

	public Report(String itemNo, BigDecimal reportCount, String title, String memberId, String status) {
		super();
		this.itemNo = itemNo;
		this.reportCount = reportCount;
		this.title = title;
		this.memberId = memberId;
		this.status = status;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public java.math.BigDecimal getReportCount() {
		return reportCount;
	}

	public void setReportCount(java.math.BigDecimal reportCount) {
		this.reportCount = reportCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Report [itemNo=" + itemNo + ", reportCount=" + reportCount + ", title=" + title + ", memberId="
				+ memberId + ", status=" + status + "]";
	}

	
	
}
