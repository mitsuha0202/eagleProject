package com.kh.eg.item.model.vo;

public class Item {

	private int itemNo;
	private String itemName;
	private String startPrice;
	private String bidUnit;
	private String deliveryPay;
	private String origin;
	private String deleteYN;
	private String categoryNo;
	private String mid;
	private String auctionCode;
	private String detail;

	public Item() {}

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

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getAuctionCode() {
		return auctionCode;
	}

	public void setAuctionCode(String auctionCode) {
		this.auctionCode = auctionCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", startPrice=" + startPrice + ", bidUnit="
				+ bidUnit + ", deliveryPay=" + deliveryPay + ", origin=" + origin + ", deleteYN=" + deleteYN
				+ ", categoryNo=" + categoryNo + ", mid=" + mid + ", auctionCode=" + auctionCode + ", detail="
				+ detail + "]";
	}

	public Item(int itemNo, String itemName, String startPrice, String bidUnit, String deliveryPay, String origin,
			String deleteYN, String categoryNo, String mid, String auctionCode, String detail) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.startPrice = startPrice;
		this.bidUnit = bidUnit;
		this.deliveryPay = deliveryPay;
		this.origin = origin;
		this.deleteYN = deleteYN;
		this.categoryNo = categoryNo;
		this.mid = mid;
		this.auctionCode = auctionCode;
		this.detail = detail;
	}
	
	


}
