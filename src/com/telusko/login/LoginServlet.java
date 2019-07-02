package com.telusko.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telusko.dao.LoginDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDao loginDao = new LoginDao();
		boolean isValidUser= loginDao.checkCredentials(username, password);
		
		if (username == null || username.isEmpty()) {
			rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
		} else if (isValidUser) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect(request.getContextPath() + "/welcome");
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
