package tech_blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech_blog.model.User;
import tech_blog.service.UserService;
import tech_blog.service.UserServiceImpl;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		User newUser = new User(userId, username, password, email);
		
		if (userService.registerUser(newUser)) {
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			req.setAttribute("error", "Registration failed. Username might already exist.");
			req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
		}
	}
}
