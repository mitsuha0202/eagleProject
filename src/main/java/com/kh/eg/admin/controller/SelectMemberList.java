package com.kh.eg.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.service.AdMemberService;
import com.kh.eg.admin.model.service.AdMemberServiceImpl;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.common.Pagination;

/**
 * Servlet implementation class SelectMemberList
 */
public class SelectMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMemberList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage= 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		AdMemberService ms = new AdMemberServiceImpl();
		
		try {
		int listCount = ms.getListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<AdminVo> list = ms.selectMemberList(pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/admin/memberList.jsp");
		view.forward(request, response);
		
		}catch(AdMemberselectException e) {
			RequestDispatcher error = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			error.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
