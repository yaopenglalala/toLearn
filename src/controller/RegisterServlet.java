package controller;

import service.UserService;
import service.serviceImpl.UserSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username").trim();
        String password = req.getParameter("password").trim();

        UserService userService = new UserSerImpl();

        if (userService.addUser(userName, password)){
            req.getSession().setAttribute("user", userService.getUser(userName));
            resp.sendRedirect("/index.jsp");
        }
    }
}
