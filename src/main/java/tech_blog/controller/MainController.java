package tech_blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech_blog.model.Board;
import tech_blog.model.User;
import tech_blog.service.BoardService;
import tech_blog.service.BoardServiceImpl;
import tech_blog.service.UserService;
import tech_blog.service.UserServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();
	private UserService userService  = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); 
		
		List<Board> boards = boardService.getFindAllBoard();
		User user = new User();
		if(session != null) {			
			user = (User) session.getAttribute("user");
		}
		req.setAttribute("boards", boards);
		req.setAttribute("user", user);

		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		
		System.out.println(keyword + "keyword???");
		
		List<Board> boards = boardService.getFindBoardByKeword(keyword);
        req.setAttribute("boards", boards);
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}
}
