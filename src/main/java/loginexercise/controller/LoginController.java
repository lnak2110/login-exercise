package loginexercise.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginexercise.entity.User;
import loginexercise.service.LoginService;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = loginService.checkLogin(email, password);

        if (user != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("userLoggedIn", user);

            String context = req.getContextPath();
            resp.sendRedirect(context + "/home");
        } else {
            req.setAttribute("loginFailed", true);
            req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
        }
    }
}
