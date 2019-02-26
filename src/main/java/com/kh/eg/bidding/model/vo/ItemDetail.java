package com.kh.eg.bidding.model.vo;

import java.sql.Date;

public class ItemDetail implements java.io.Serializable{
	private String itemNo;
	private String itemName;
	private int startPrice;
	private int bidUnit;
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
	private String startDay;
	private String endDay;
	private String exitYN;
	private int currentPrice;
	private String wishListNo;
	private String delStatus;
	private int lucky;
	
	public ItemDetail() {}

	@Override
	public String toString() {
		return "ItemDetail [itemNo=" + itemNo + ", itemName=" + itemName + ", startPrice=" + startPrice + ", bidUnit="
				+ bidUnit + ", deliveryPay=" + deliveryPay + ", origin=" + origin + ", deleteYN=" + deleteYN
				+ ", categoryNo=" + categoryNo + ", mNo=" + mNo + ", auctionCode=" + auctionCode + ", detail=" + detail
				+ ", deliveryPrice=" + deliveryPrice + ", itemCount=" + itemCount + ", mId=" + mId + ", rating="
				+ rating + ", auctionName=" + auctionName + ", startDay=" + startDay + ", endDay=" + endDay
				+ ", exitYN=" + exitYN + ", currentPrice=" + currentPrice + ", wishListNo=" + wishListNo
				+ ", delStatus=" + delStatus + ", lucky=" + lucky + "]";
	}

	public ItemDetail(String itemNo, String itemName, int startPrice, int bidUnit, String deliveryPay, String origin,
			String deleteYN, String categoryNo, String mNo, String auctionCode, String detail, String deliveryPrice,
			String itemCount, String mId, String rating, String auctionName, String startDay, String endDay,
			String exitYN, int currentPrice, String wishListNo, String delStatus, int lucky) {
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
		this.currentPrice = currentPrice;
		this.wishListNo = wishListNo;
		this.delStatus = delStatus;
		this.lucky = lucky;
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

	public int getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	public int getBidUnit() {
		return bidUnit;
	}

	public void setBidUnit(int bidUnit) {
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

	public String getExitYN() {
		return exitYN;
	}

	public void setExitYN(String exitYN) {
		this.exitYN = exitYN;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getWishListNo() {
		return wishListNo;
	}

	public void setWishListNo(String wishListNo) {
		this.wishListNo = wishListNo;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	public int getLucky() {
		return lucky;
	}

	public void setLucky(int lucky) {
		this.lucky = lucky;
	}


	
	
}
