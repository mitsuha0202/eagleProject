package com.kh.eg.bidding.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Bid implements java.io.Serializable {
	private String bidNo;
	private int itemNo;
	private String memberNo;
	private int currentPrice;
	private Date bidDate;
	
	
	public Bid() {}


	public Bid(String bidNo, int itemNo, String memberNo, int currentPrice, Date bidDate) {
		super();
		this.bidNo = bidNo;
		this.itemNo = itemNo;
		this.memberNo = memberNo;
		this.currentPrice = currentPrice;
		this.bidDate = bidDate;
	}


	@Override
	public String toString() {
		return "Bid [bidNo=" + bidNo + ", itemNo=" + itemNo + ", memberNo=" + memberNo + ", currentPrice="
				+ currentPrice + ", bidDate=" + bidDate + "]";
	}


	public String getBidNo() {
		return bidNo;
	}


	public void setBidNo(String bidNo) {
		this.bidNo = bidNo;
	}


	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
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



}
