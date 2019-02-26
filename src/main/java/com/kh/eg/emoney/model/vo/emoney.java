package com.kh.eg.emoney.model.vo;

import java.util.Date;

public class emoney implements java.io.Serializable {

	private String useNo;
	private Date useDay;
	private int money;
	private String useStatus;
	private String memberNo;
	private String payNo;
	private String exchangeNo;
	private String exchangeYn;
	private String userNo;
	private int amount;
	private Date payDay;
	private String cardNo;
	private String payStatus;
	private String refundNo;
	private String dealNo;
	private String itemNo;

	public emoney() {}

	public String getUseNo() {
		return useNo;
	}

	public void setUseNo(String useNo) {
		this.useNo = useNo;
	}

	public Date getUseDay() {
		return useDay;
	}

	public void setUseDay(Date useDay) {
		this.useDay = useDay;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getExchangeNo() {
		return exchangeNo;
	}

	public void setExchangeNo(String exchangeNo) {
		this.exchangeNo = exchangeNo;
	}

	public String getExchangeYn() {
		return exchangeYn;
	}

	public void setExchangeYn(String exchangeYn) {
		this.exchangeYn = exchangeYn;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	@Override
	public String toString() {
		return "emoney [useNo=" + useNo + ", useDay=" + useDay + ", money=" + money + ", useStatus=" + useStatus
				+ ", memberNo=" + memberNo + ", payNo=" + payNo + ", exchangeNo=" + exchangeNo + ", exchangeYn="
				+ exchangeYn + ", userNo=" + userNo + ", amount=" + amount + ", payDay=" + payDay + ", cardNo=" + cardNo
				+ ", payStatus=" + payStatus + ", refundNo=" + refundNo + ", dealNo=" + dealNo + ", itemNo=" + itemNo
				+ "]";
	}

	public emoney(String useNo, Date useDay, int money, String useStatus, String memberNo, String payNo,
			String exchangeNo, String exchangeYn, String userNo, int amount, Date payDay, String cardNo,
			String payStatus, String refundNo, String dealNo, String itemNo) {
		super();
		this.useNo = useNo;
		this.useDay = useDay;
		this.money = money;
		this.useStatus = useStatus;
		this.memberNo = memberNo;
		this.payNo = payNo;
		this.exchangeNo = exchangeNo;
		this.exchangeYn = exchangeYn;
		this.userNo = userNo;
		this.amount = amount;
		this.payDay = payDay;
		this.cardNo = cardNo;
		this.payStatus = payStatus;
		this.refundNo = refundNo;
		this.dealNo = dealNo;
		this.itemNo = itemNo;
	}

	
	
	

	
	
	
}
