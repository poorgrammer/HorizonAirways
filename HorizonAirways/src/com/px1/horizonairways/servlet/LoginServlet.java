package com.px1.horizonairways.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.px1.horizonairways.da.LoginDA;
import com.px1.horizonairways.daimpl.LoginDAImpl;
import com.px1.horizonairways.entity.Login;
import com.px1.horizonairways.entity.User;
import com.px1.horizonairways.service.LoginService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		LoginService loginService = new LoginService();
		LoginDA da = new LoginDAImpl();
		loginService.setLoginDA(da);
		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		Login login = new Login(username, password);
		User user = loginService.validateUser(login);
		request.getSession().setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
		dispatcher.forward(request, response);
	}

}
