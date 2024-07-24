package tech_blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech_blog.model.Board;
import tech_blog.service.BoardService;
import tech_blog.service.BoardServiceImpl;

@WebServlet("/detail/*")
public class DetailBoardController extends HttpServlet{
	private BoardService boardService= new BoardServiceImpl();
	
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
        
        String boardIdStr = pathParts[1];
        try {
            int boardId = Integer.parseInt(boardIdStr);
            Board board = boardService.getBoardById(boardId);
            if (board == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            req.setAttribute("board", board);
            req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
            
        } catch (NumberFormatException e) {
        	e.printStackTrace();
        }
        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
