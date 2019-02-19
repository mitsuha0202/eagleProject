package com.kh.eg.bidding.model.vo;

import java.sql.Date;

public class ItemDetail implements java.io.Serializable{
	private String itemNo;
	private String itemName;
	private String startPrice;
	private String bidUnit;
	private String deliveryPay;
	private String origin;
	private String deleteYN;
	private String categoryNo;
	private String mNo;
	private String auctionCode;
	private String detail;
	private String deliveryPrice;
	private String itemCount;
	private String mId;
	private String rating;
	private String auctionName;
	private Date startDay;
	private Date endDay;
	private String exitYN;
	
	public ItemDetail() {}

	@Override
	public String toString() {
		return "ItemDetail [itemNo=" + itemNo + ", itemName=" + itemName + ", startPrice=" + startPrice + ", bidUnit="
				+ bidUnit + ", deliveryPay=" + deliveryPay + ", origin=" + origin + ", deleteYN=" + deleteYN
				+ ", categoryNo=" + categoryNo + ", mNo=" + mNo + ", auctionCode=" + auctionCode + ", detail=" + detail
				+ ", deliveryPrice=" + deliveryPrice + ", itemCount=" + itemCount + ", mId=" + mId + ", rating="
				+ rating + ", auctionName=" + auctionName + ", startDay=" + startDay + ", endDay=" + endDay
				+ ", exitYN=" + exitYN + "]";
	}

	public ItemDetail(String itemNo, String itemName, String startPrice, String bidUnit, String deliveryPay,
			String origin, String deleteYN, String categoryNo, String mNo, String auctionCode, String detail,
			String deliveryPrice, String itemCount, String mId, String rating, String auctionName, Date startDay,
			Date endDay, String exitYN) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.startPrice = startPrice;
		this.bidUnit = bidUnit;
		this.deliveryPay = deliveryPay;
		this.origin = origin;
		this.deleteYN = deleteYN;
		this.categoryNo = categoryNo;
		this.mNo = mNo;
		this.auctionCode = auctionCode;
		this.detail = detail;
		this.deliveryPrice = deliveryPrice;
		this.itemCount = itemCount;
		this.mId = mId;
		this.rating = rating;
		this.auctionName = auctionName;
		this.startDay = startDay;
		this.endDay = endDay;
		this.exitYN = exitYN;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
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

	public String getmNo() {
		return mNo;
	}

	public void setmNo(String mNo) {
		this.mNo = mNo;
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

	public String getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(String deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAuctionName() {
		return auctionName;
	}

	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getExitYN() {
		return exitYN;
	}

	public void setExitYN(String exitYN) {
		this.exitYN = exitYN;
	}

	
}