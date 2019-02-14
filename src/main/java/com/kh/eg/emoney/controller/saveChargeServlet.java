package com.kh.eg.emoney.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.eg.emoney.model.service.*;
import com.kh.eg.emoney.model.vo.*;


/**
 * Servlet implementation class saveCharge
 */
@WebServlet("/saveCharge.em")
public class saveChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveChargeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buyer_code = request.getParameter("buyer_code");
		int amount = Integer.parseInt(request.getParameter("amount"));
		//String buyer_name = request.getParameter("buyer_name");
		
		
		System.out.println("buyer_code : " + buyer_code);
		//System.out.println("buyer_name : " + buyer_name);
		System.out.println("amount : " + amount);
		amount = (int) ((int)amount*0.9);
		emoney em = new emoney();
		em.setMemberNo(buyer_code);
		em.setAmount(amount);
		
		int result = new emoneyServiceImpl().insertEmoney(em);

		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(result, response.getWriter());
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
