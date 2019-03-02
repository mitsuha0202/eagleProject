package com.kh.eg.bidding.model.vo;

import java.sql.Date;

public class Bidding implements java.io.Serializable{
	private String bidNo;
	private String itemNo;
	private String memberNo;
	private int currentPrice;
	private Date bidDate;
	private String memberId;
	
	public Bidding() {}

	@Override
	public String toString() {
		return "Bidding [bidNo=" + bidNo + ", itemNo=" + itemNo + ", memberNo=" + memberNo + ", currentPrice="
				+ currentPrice + ", bidDate=" + bidDate + ", memberId=" + memberId + "]";
	}

	public Bidding(String bidNo, String itemNo, String memberNo, int currentPrice, Date bidDate, String memberId) {
		super();
		this.bidNo = bidNo;
		this.itemNo = itemNo;
		this.memberNo = memberNo;
		this.currentPrice = currentPrice;
		this.bidDate = bidDate;
		this.memberId = memberId;
	}

	public String getBidNo() {
		return bidNo;
	}

	public void setBidNo(String bidNo) {
		this.bidNo = bidNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	
}
