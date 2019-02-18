package com.kh.eg.myPage.model.vo;

public class WinBid implements java.io.Serializable{
	private String memberNo;
	private String itemNo;
	private String dealNo;
	
	public WinBid() {
	
	}

	public WinBid(String memberNo, String itemNo, String dealNo) {
		super();
		this.memberNo = memberNo;
		this.itemNo = itemNo;
		this.dealNo = dealNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	@Override
	public String toString() {
		return "Winbid [memberNo=" + memberNo + ", itemNo=" + itemNo + ", dealNo=" + dealNo + "]";
	}

}
