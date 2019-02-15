package com.kh.eg.myPage.common;

import com.kh.eg.myPage.model.vo.PageInfo;

public class Pagination {
	
	//PageInfo를 리턴하는 메소드
	public static PageInfo getPageInfo(int currentPage, int listCount) {
		PageInfo pi = null;
		
		//지금은 10으로 고정했지만 다르게 하고 싶으면 매개변수로 limit 받으면 된다.
		int limit = 10;			//한 페이지에 게시글이 몇 개가 보여질 것인지
		int buttonCount = 10;	//한 화면에 보여질 페이징 버튼의 수
		int maxPage;			//전체 페이지에서 가장 마지막 페이지
		int startPage;			//한번에 표시될 페이지 버튼의 시작할 페이지
		int endPage;			//한번에 표시될 페이지 버튼의 끝나는 페이지
		
		maxPage = (int)((double)listCount / limit + 0.9);
		
		startPage = (((int)((double)currentPage / buttonCount + 0.9)) - 1) * buttonCount + 1;
		
		endPage = startPage + buttonCount - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		return pi;
	}
}
