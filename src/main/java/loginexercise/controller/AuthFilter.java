package loginexercise.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginexercise.entity.User;

@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getServletPath();
        String context = req.getContextPath();

        HttpSession httpSession = req.getSession();
        User userLoggedIn = (User) httpSession.getAttribute("userLoggedIn");

        if ("/login".equals(path)) {
            if (userLoggedIn == null) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(context + "/home");
            }
        } else {
            if (userLoggedIn == null) {
                res.sendRedirect(context + "/login");
            } else {
                chain.doFilter(request, response);
            }
        }
    }
}
