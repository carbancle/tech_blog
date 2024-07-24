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

@WebServlet("/update_board/*")
public class UpdateBoardController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pathInfo = req.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String[] pathParts = pathInfo.split("/");
		if (pathParts.length != 2) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		try {
			String boardIdStr = pathParts[1];
			int boardId = Integer.parseInt(boardIdStr);
			Board board = boardService.getBoardById(boardId);
			if (board == null) {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}

			req.setAttribute("board", board);
			req.getRequestDispatcher("/WEB-INF/views/create_board.jsp").forward(req, resp);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User loggedInUser = (User) req.getSession().getAttribute("user");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		Board board = new Board(id, title, content.trim(), loggedInUser.getUserId());
		System.out.println(board.getContent());

		boolean isUpdated = boardService.updateBoard(board);

		if (isUpdated) {
			resp.sendRedirect(req.getContextPath() + "/main");
		} else {
			req.setAttribute("error", "게시글을 수정하는데 문제가 발생했습니다.");
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		}

	}
}
