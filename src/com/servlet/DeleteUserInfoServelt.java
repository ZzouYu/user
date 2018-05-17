package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserInfoService;

/**
 * Servlet implementation class DeleteUserInfoServelt
 */
public class DeleteUserInfoServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserInfoServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idStr = request.getParameter("id") ;
			try {
				UserInfoService u = new UserInfoService();
				int id = Integer.valueOf(idStr);
				u.deleteuserInfo(id);
				System.out.println("É¾³ý³É¹¦£¡");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("É¾³ýÊ§°Ü£¡");
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
