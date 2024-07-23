package tech_blog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech_blog.dao.BoardDAO;
import tech_blog.dao.BoardDAOImpl;
import tech_blog.model.Board;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private BoardDAO boardDAO;
	
	public MainController() {
        this.boardDAO = new BoardDAOImpl();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Board> boards = boardDAO.findAllBoard();
		req.setAttribute("boards", boards);
		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
	}
}
