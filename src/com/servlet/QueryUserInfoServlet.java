package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserInfo;
import com.service.UserInfoService;

/**
 * Servlet implementation class QueryUserInfoServlet
 */
public class QueryUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		UserInfo userinfo = new UserInfo(id,name);
		userinfo.toString();
		List<UserInfo>  list = null ;
		try {
			UserInfoService us = new UserInfoService();
			 list = us.list(userinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("userlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
