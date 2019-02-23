package com.kh.eg.secondAdmin.model.vo;

import java.math.BigDecimal;

public class SecondAdmin implements java.io.Serializable{	
	private String memberName;
	private String memberId;
	private String memberPwd;
	private String accountn;
	private String phone;
	private String rating;
	private String address;
	private String eMail;
	private java.math.BigDecimal eMoney;
	private String wdStatus;
	
	public void SecondAdmin() {}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getAccountn() {
		return accountn;
	}

	public void setAccountn(String accountn) {
		this.accountn = accountn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public java.math.BigDecimal geteMoney() {
		return eMoney;
	}

	public void seteMoney(java.math.BigDecimal eMoney) {
		this.eMoney = eMoney;
	}

	public String getWdStatus() {
		return wdStatus;
	}

	public void setWdStatus(String wdStatus) {
		this.wdStatus = wdStatus;
	}

	@Override
	public String toString() {
		return "SecondAdmin [memberName=" + memberName + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", accountn=" + accountn + ", phone=" + phone + ", rating=" + rating + ", address=" + address
				+ ", eMail=" + eMail + ", eMoney=" + eMoney + ", wdStatus=" + wdStatus + "]";
	}

	
	
	
	
}