package com.kh.eg.admin.model.vo;

public class AdminVo {	
	private String memberName;
	private String memberId;
	private String accountn;
	private String phone;
	private String rating;
	private String address;
	private String eMoney;
	private String wdStatus;
	private String blStatus;
	
	public void AdminVo() {}

	public AdminVo(String memberName, String memberId, String accountn, String phone, String rating, String address,
			String eMoney, String wdStatus, String blStatus) {
		super();
		this.memberName = memberName;
		this.memberId = memberId;
		this.accountn = accountn;
		this.phone = phone;
		this.rating = rating;
		this.address = address;
		this.eMoney = eMoney;
		this.wdStatus = wdStatus;
		this.blStatus = blStatus;
	}

	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getAccountn() {
		return accountn;
	}



	public void setAccountn(String accountn) {
		this.accountn = accountn;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String geteMoney() {
		return eMoney;
	}



	public void seteMoney(String eMoney) {
		this.eMoney = eMoney;
	}



	public String getWdStatus() {
		return wdStatus;
	}



	public void setWdStatus(String wdStatus) {
		this.wdStatus = wdStatus;
	}



	public String getBlStatus() {
		return blStatus;
	}



	public void setBlStatus(String blStatus) {
		this.blStatus = blStatus;
	}



	@Override
	public String toString() {
		return "AdminVo [memberName=" + memberName + ", memberId=" + memberId + ", accountn=" + accountn + ", phone="
				+ phone + ", rating=" + rating + ", address=" + address + ", eMoney=" + eMoney + ", wdStatus="
				+ wdStatus + ", blStatus=" + blStatus + "]";
	}
	
}