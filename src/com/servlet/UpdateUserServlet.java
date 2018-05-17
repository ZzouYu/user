package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserInfo;
import com.service.UserInfoService;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = 0;
		String idStr = request.getParameter("id") ; 
		if(idStr !=null && !idStr.isEmpty()){
			id = Integer.valueOf(request.getParameter("id"));
		}
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String remark = request.getParameter("remark");
		UserInfo user = new UserInfo(id, name, age,remark);
		user.toString();
		try {
			UserInfoService u = new UserInfoService();
			u.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("QueryUserInfoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
