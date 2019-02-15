package com.kh.eg.item.model.vo;

import org.springframework.stereotype.Component;

import com.kh.eg.attachment.model.vo.Attachment;

@Component
public class Item implements java.io.Serializable {

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
	private String deliveryPrice;
	private String itemcount;
	private int bidCount;
	private Attachment atta; 
	
	
	public Item() {}


	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", startPrice=" + startPrice + ", bidUnit="
				+ bidUnit + ", deliveryPay=" + deliveryPay + ", origin=" + origin + ", deleteYN=" + deleteYN
				+ ", categoryNo=" + categoryNo + ", mid=" + mid + ", auctionCode=" + auctionCode + ", detail=" + detail
				+ ", deliveryPrice=" + deliveryPrice + ", itemcount=" + itemcount + ", bidCount=" + bidCount + ", atta="
				+ atta + "]";
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


	public String getDeliveryPrice() {
		return deliveryPrice;
	}


	public void setDeliveryPrice(String deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}


	public String getItemcount() {
		return itemcount;
	}


	public void setItemcount(String itemcount) {
		this.itemcount = itemcount;
	}


	public int getBidCount() {
		return bidCount;
	}


	public void setBidCount(int bidCount) {
		this.bidCount = bidCount;
	}


	public Attachment getAtta() {
		return atta;
	}


	public void setAtta(Attachment atta) {
		this.atta = atta;
	}


	public Item(int itemNo, String itemName, String startPrice, String bidUnit, String deliveryPay, String origin,
			String deleteYN, String categoryNo, String mid, String auctionCode, String detail, String deliveryPrice,
			String itemcount, int bidCount, Attachment atta) {
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
		this.deliveryPrice = deliveryPrice;
		this.itemcount = itemcount;
		this.bidCount = bidCount;
		this.atta = atta;
	}
	
	


}
