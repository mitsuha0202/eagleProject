package com.kh.eg.admin.model.vo;

public class Return implements java.io.Serializable{
	private String dealNo;
	private String memberId;
	private String phone;
	private String orderm;
	private String address;
	private String itemName;
	private int price;
	
	public Return () {}

	public Return(String dealNo, String memberId, String phone, String orderm, String address, String itemName,
			int price) {
		super();
		this.dealNo = dealNo;
		this.memberId = memberId;
		this.phone = phone;
		this.orderm = orderm;
		this.address = address;
		this.itemName = itemName;
		this.price = price;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrderm() {
		return orderm;
	}

	public void setOrderm(String orderm) {
		this.orderm = orderm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Return [dealNo=" + dealNo + ", memberId=" + memberId + ", phone=" + phone + ", orderm=" + orderm
				+ ", address=" + address + ", itemName=" + itemName + ", price=" + price + "]";
	}
	
	

}
