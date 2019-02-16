package com.kh.eg.myPage.model.vo;

import java.sql.Date;

public class Maccount implements java.io.Serializable{
	private int mid;
	private String accountNo;
	private String memberName;
	private String bankName;
	private Date createDay;
	
	public Maccount() {
	
	}

	public Maccount(int mid, String accountNo, String memberName, String bankName, Date createDay) {
		super();
		this.mid = mid;
		this.accountNo = accountNo;
		this.memberName = memberName;
		this.bankName = bankName;
		this.createDay = createDay;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getCreateDay() {
		return createDay;
	}

	public void setCreateDay(Date createDay) {
		this.createDay = createDay;
	}

	@Override
	public String toString() {
		return "Maccount [mid=" + mid + ", accountNo=" + accountNo + ", memberName=" + memberName + ", bankName="
				+ bankName + ", createDay=" + createDay + "]";
	}
	
}
