package com.kh.eg.myPage.model.vo;

public class PayTable implements Comparable<PayTable>{
	private int itemNo;
	private int bidNo;
	private String itemName;
	private String memberNo;
	private String memberName;
	private String currentPrice;
	private int bidCount;
	private int saleMemberNo;
	private String saleMemberName;
	private int rowBid;
	private String startDay;
	private String endDay;
	private String endYn;
	private String auctioncode;
	private String deliveryPay;
	private String orderM;
	
	public PayTable() {
	
	}

	public PayTable(int itemNo, int bidNo, String itemName, String memberNo, String memberName, String currentPrice,
			int bidCount, int saleMemberNo, String saleMemberName, int rowBid, String startDay, String endDay,
			String endYn, String auctioncode, String deliveryPay, String orderM) {
		super();
		this.itemNo = itemNo;
		this.bidNo = bidNo;
		this.itemName = itemName;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.currentPrice = currentPrice;
		this.bidCount = bidCount;
		this.saleMemberNo = saleMemberNo;
		this.saleMemberName = saleMemberName;
		this.rowBid = rowBid;
		this.startDay = startDay;
		this.endDay = endDay;
		this.endYn = endYn;
		this.auctioncode = auctioncode;
		this.deliveryPay = deliveryPay;
		this.orderM = orderM;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getBidNo() {
		return bidNo;
	}

	public void setBidNo(int bidNo) {
		this.bidNo = bidNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getEndYn() {
		return endYn;
	}

	public void setEndYn(String endYn) {
		this.endYn = endYn;
	}

	public String getAuctioncode() {
		return auctioncode;
	}

	public void setAuctioncode(String auctioncode) {
		this.auctioncode = auctioncode;
	}

	public String getDeliveryPay() {
		return deliveryPay;
	}

	public void setDeliveryPay(String deliveryPay) {
		this.deliveryPay = deliveryPay;
	}

	public String getOrderM() {
		return orderM;
	}

	public void setOrderM(String orderM) {
		this.orderM = orderM;
	}

	@Override
	public String toString() {
		return "PayTable [itemNo=" + itemNo + ", bidNo=" + bidNo + ", itemName=" + itemName + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", currentPrice=" + currentPrice + ", bidCount=" + bidCount
				+ ", saleMemberNo=" + saleMemberNo + ", saleMemberName=" + saleMemberName + ", rowBid=" + rowBid
				+ ", startDay=" + startDay + ", endDay=" + endDay + ", endYn=" + endYn + ", auctioncode=" + auctioncode
				+ ", deliveryPay=" + deliveryPay + ", orderM=" + orderM + "]";
	}

	@Override
	public int compareTo(PayTable pay) {
		if(this.itemNo < pay.getItemNo()) {
			return 1;
		}else if (this.itemNo > pay.getItemNo()) {
			return -1;
		}
		return 0;
	}
	
}
