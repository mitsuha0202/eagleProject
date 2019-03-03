package com.kh.eg.myPage.model.vo;

public class MainList implements java.io.Serializable{
	
	private String dealNo;
	private String payNo;
	private String saleNo;
	private String orderM;
	
	public MainList() {
	
	}

	public MainList(String dealNo, String payNo, String saleNo, String orderM) {
		super();
		this.dealNo = dealNo;
		this.payNo = payNo;
		this.saleNo = saleNo;
		this.orderM = orderM;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getSaleNo() {
		return saleNo;
	}

	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}

	public String getOrderM() {
		return orderM;
	}

	public void setOrderM(String orderM) {
		this.orderM = orderM;
	}

	@Override
	public String toString() {
		return "MainList [dealNo=" + dealNo + ", payNo=" + payNo + ", saleNo=" + saleNo + ", orderM=" + orderM + "]";
	}
	
}
