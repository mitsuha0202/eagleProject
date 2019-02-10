package com.kh.eg.item.model.vo;

public class Item {

	
	private int itemNo;
	private String itemName;
	private String startPrice;
	private String bidUnit;
	private String deliveryPay;
	private String origin;
	private String deleteYN;
	private String categoryYN;
	private String memberNo;
	private String auctionCode;
	
	public Item() {}
	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", startPrice=" + startPrice + ", bidUnit="
				+ bidUnit + ", deliveryPay=" + deliveryPay + ", origin=" + origin + ", deleteYN=" + deleteYN
				+ ", categoryYN=" + categoryYN + ", memberNo=" + memberNo + ", auctionCode=" + auctionCode + "]";
	}
	public Item(int itemNo, String itemName, String startPrice, String bidUnit, String deliveryPay, String origin,
			String deleteYN, String categoryYN, String memberNo, String auctionCode) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.startPrice = startPrice;
		this.bidUnit = bidUnit;
		this.deliveryPay = deliveryPay;
		this.origin = origin;
		this.deleteYN = deleteYN;
		this.categoryYN = categoryYN;
		this.memberNo = memberNo;
		this.auctionCode = auctionCode;
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
	public String getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(String startPrice) {
		this.startPrice = startPrice;
	}
	public String getBidUnit() {
		return bidUnit;
	}
	public void setBidUnit(String bidUnit) {
		this.bidUnit = bidUnit;
	}
	public String getDeliveryPay() {
		return deliveryPay;
	}
	public void setDeliveryPay(String deliveryPay) {
		this.deliveryPay = deliveryPay;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDeleteYN() {
		return deleteYN;
	}
	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}
	public String getCategoryYN() {
		return categoryYN;
	}
	public void setCategoryYN(String categoryYN) {
		this.categoryYN = categoryYN;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getAuctionCode() {
		return auctionCode;
	}
	public void setAuctionCode(String auctionCode) {
		this.auctionCode = auctionCode;
	}
	
}
