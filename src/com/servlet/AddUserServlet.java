package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserInfo;
import com.service.UserInfoService;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String remark = request.getParameter("remark");
		UserInfo userinfo = new UserInfo(name, age,remark);
		userinfo.toString();
		boolean result = false ;
		try {
			UserInfoService us = new UserInfoService();
			result = us.add(userinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result){
			System.out.println("add userinfo success .");
			response.sendRedirect("QueryUserInfoServlet"); 
		}else{
			response.sendRedirect("error.jsp"); 
		}
		
		//request.getRequestDispatcher("QueryUserInfoServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
