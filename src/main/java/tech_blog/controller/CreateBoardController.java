package tech_blog.controller;

import java.io.IOException;

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

@WebServlet("/create_board")
public class CreateBoardController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/create_board.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }
        
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setUserId(user.getUserId());
        
        boolean isSuccess = boardService.createBoard(board);
        
        if (isSuccess) {
            resp.sendRedirect(req.getContextPath() + "/main");
        } else {
            req.setAttribute("error", "글 작성 중 오류가 발생했습니다.");
            req.getRequestDispatcher("/WEB-INF/views/create_board.jsp").forward(req, resp);
        }
	}
}
