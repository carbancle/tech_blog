package tech_blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); // 세션이 존재하면 반환하고, 존재하지 않으면 null 반환
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        resp.sendRedirect(req.getContextPath() + "/main"); // 로그인 페이지로 리다이렉트
    }
}