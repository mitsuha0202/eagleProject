package com.kh.eg.myPage.model.vo;

import java.sql.Date;

public class Query {
	private int pMemberNo;
	private int itemNo;
	private String title;
	private String answer;
	private String sMemberName;
	private Date createDay;
	
	public Query() {
	
	}

	public Query(int pMemberNo, int itemNo, String title, String answer, String sMemberName, Date createDay) {
		super();
		this.pMemberNo = pMemberNo;
		this.itemNo = itemNo;
		this.title = title;
		this.answer = answer;
		this.sMemberName = sMemberName;
		this.createDay = createDay;
	}

	public int getpMemberNo() {
		return pMemberNo;
	}

	public void setpMemberNo(int pMemberNo) {
		this.pMemberNo = pMemberNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getsMemberName() {
		return sMemberName;
	}

	public void setsMemberName(String sMemberName) {
		this.sMemberName = sMemberName;
	}

	public Date getCreateDay() {
		return createDay;
	}

	public void setCreateDay(Date createDay) {
		this.createDay = createDay;
	}

	@Override
	public String toString() {
		return "Query [pMemberNo=" + pMemberNo + ", itemNo=" + itemNo + ", title=" + title + ", answer=" + answer
				+ ", sMemberName=" + sMemberName + ", createDay=" + createDay + "]";
	}
	
}
