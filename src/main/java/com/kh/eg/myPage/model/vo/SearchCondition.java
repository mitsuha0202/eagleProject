package com.kh.eg.myPage.model.vo;

public class SearchCondition {
	private String writer;
	private String title;
	
	public SearchCondition() {}

	public SearchCondition(String writer, String title) {
		super();
		this.writer = writer;
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "SearchCondition [writer=" + writer + ", title=" + title + "]";
	}
}
