package tech_blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login";
        String registerURI = req.getContextPath() + "/register";
        
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean registerRequest = req.getRequestURI().equals(registerURI);
        boolean staticResource = req.getRequestURI().startsWith(req.getContextPath() + "/static/");
        
        if (staticResource) {
            chain.doFilter(request, response);
            return;
        }

        if (loggedIn || loginRequest || registerRequest) {
            if (loggedIn && registerRequest) {
                resp.sendRedirect(req.getContextPath() + "/main");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (req.getRequestURI().startsWith(req.getContextPath() + "/create_board") ||
                req.getRequestURI().startsWith(req.getContextPath() + "/update_board") ||
                req.getRequestURI().startsWith(req.getContextPath() + "/delete_board")) {
                resp.sendRedirect(loginURI);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        // 필터 제거 시 필요한 작업
    }
}
