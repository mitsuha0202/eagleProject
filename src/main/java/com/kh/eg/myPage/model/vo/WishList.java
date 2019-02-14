package com.kh.eg.myPage.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class WishList {
	
	
	private String wishlistno;
	private String categoryname;
	private String itemno;
	private String itemname;
	private String startprice;
	private String membername;
	private Date endday;
	
	public WishList() {
		
	}

	public WishList(String wishlistno, String categoryname, String itemno, String itemname, String startprice,
			String membername, Date endday) {
		super();
		this.wishlistno = wishlistno;
		this.categoryname = categoryname;
		this.itemno = itemno;
		this.itemname = itemname;
		this.startprice = startprice;
		this.membername = membername;
		this.endday = endday;
	}

	public String getWishlistno() {
		return wishlistno;
	}

	public void setWishlistno(String wishlistno) {
		this.wishlistno = wishlistno;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getStartprice() {
		return startprice;
	}

	public void setStartprice(String startprice) {
		this.startprice = startprice;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Date getEndday() {
		return endday;
	}

	public void Date(Date endday) {
		this.endday = endday;
	}

	@Override
	public String toString() {
		return "WishList [wishlistno=" + wishlistno + ", categoryname=" + categoryname + ", itemno=" + itemno
				+ ", itemname=" + itemname + ", startprice=" + startprice + ", membername=" + membername + ", endday="
				+ endday + "]";
	}
	
	
	
}
 