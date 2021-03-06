package com.kh.eg.secondAdmin.model.vo;

import java.math.BigDecimal;

public class SecondAdmin implements java.io.Serializable{	
	private String MemberId;
	private String MemberPwd;
	private String categoryName;
	private int categoryCount;
	private String categoryNo;
	private String upperCNO;
	private int priceCount;
	
	public SecondAdmin() {}

	public SecondAdmin(String memberId, String memberPwd, String categoryName, int categoryCount, String categoryNo,
			String upperCNO, int priceCount) {
		super();
		MemberId = memberId;
		MemberPwd = memberPwd;
		this.categoryName = categoryName;
		this.categoryCount = categoryCount;
		this.categoryNo = categoryNo;
		this.upperCNO = upperCNO;
		this.priceCount = priceCount;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getMemberPwd() {
		return MemberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		MemberPwd = memberPwd;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryCount() {
		return categoryCount;
	}

	public void setCategoryCount(int categoryCount) {
		this.categoryCount = categoryCount;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getUpperCNO() {
		return upperCNO;
	}

	public void setUpperCNO(String upperCNO) {
		this.upperCNO = upperCNO;
	}

	public int getPriceCount() {
		return priceCount;
	}

	public void setPriceCount(int priceCount) {
		this.priceCount = priceCount;
	}

	@Override
	public String toString() {
		return "SecondAdmin [MemberId=" + MemberId + ", MemberPwd=" + MemberPwd + ", categoryName=" + categoryName
				+ ", categoryCount=" + categoryCount + ", categoryNo=" + categoryNo + ", upperCNO=" + upperCNO
				+ ", priceCount=" + priceCount + "]";
	}

	

	
	
	

	

	

	
}