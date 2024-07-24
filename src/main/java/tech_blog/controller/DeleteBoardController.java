package tech_blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech_blog.model.User;
import tech_blog.service.BoardService;
import tech_blog.service.BoardServiceImpl;

@WebServlet("/delete_board")
public class DeleteBoardController extends HttpServlet {
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		User loggedInUser = (User) req.getSession().getAttribute("user");
		
		System.out.println(idStr + " " + loggedInUser);
		System.out.println(loggedInUser.getUserId());
        
		if (idStr != null && !idStr.isEmpty() && loggedInUser != null) {
            try {
                int id = Integer.parseInt(idStr);
                boolean isDeleted = boardService.deleteBoard(id, loggedInUser.getUserId());
                
                if (isDeleted) {
                    resp.sendRedirect(req.getContextPath() + "/main");
                } else {
                    // 삭제 실패 시 처리 로직
                	System.out.println("에러 1");
                    resp.sendRedirect(req.getContextPath() + "/error.jsp");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("에러 2");
                // 잘못된 ID 형식 처리
                resp.sendRedirect(req.getContextPath() + "/error.jsp");
            }
        } else {
        	System.out.println("에러 3");
            // ID 또는 로그인된 사용자가 없는 경우 처리
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
	}
}
