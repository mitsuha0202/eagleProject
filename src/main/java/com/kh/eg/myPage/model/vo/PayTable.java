package com.kh.eg.myPage.model.vo;

import java.sql.Date;

public class PayTable {
	private int itemNo;
	private String itemName;
	private String currentPrice;
	private int bidCount;
	private int saleMemberNo;
	private String saleMemberName;
	private int rowBid;
	private Date endDay;
	private String endYn;
	
	public PayTable() {
	
	}

	public PayTable(int itemNo, String itemName, String currentPrice, int bidCount, int saleMemberNo,
			String saleMemberName, int rowBid, Date endDay, String endYn) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.currentPrice = currentPrice;
		this.bidCount = bidCount;
		this.saleMemberNo = saleMemberNo;
		this.saleMemberName = saleMemberName;
		this.rowBid = rowBid;
		this.endDay = endDay;
		this.endYn = endYn;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getBidCount() {
		return bidCount;
	}

	public void setBidCount(int bidCount) {
		this.bidCount = bidCount;
	}

	public int getSaleMemberNo() {
		return saleMemberNo;
	}

	public void setSaleMemberNo(int saleMemberNo) {
		this.saleMemberNo = saleMemberNo;
	}

	public String getSaleMemberName() {
		return saleMemberName;
	}

	public void setSaleMemberName(String saleMemberName) {
		this.saleMemberName = saleMemberName;
	}

	public int getRowBid() {
		return rowBid;
	}

	public void setRowBid(int rowBid) {
		this.rowBid = rowBid;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getEndYn() {
		return endYn;
	}

	public void setEndYn(String endYn) {
		this.endYn = endYn;
	}

	@Override
	public String toString() {
		return "PayTable [itemNo=" + itemNo + ", itemName=" + itemName + ", currentPrice=" + currentPrice
				+ ", bidCount=" + bidCount + ", saleMemberNo=" + saleMemberNo + ", saleMemberName=" + saleMemberName
				+ ", rowBid=" + rowBid + ", endDay=" + endDay + ", endYn=" + endYn + "]";
	}
}
