package controller.updateServlet;

import service.UserService;
import service.serviceImpl.UserSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        if (userName == null) userName = "";
        if (password == null) password = "";
        userName = userName.trim();
        password = password.trim();

        UserService userService = new UserSerImpl();

        if (userName.equals("")){
            req.setAttribute("err", "Invalid user name");
        } else if (userService.getUserByName(userName) != null) {
            req.setAttribute("err", "This user exists!");
            doGet(req, resp);
        } else {
            userService.addUser(userName, password);
            req.getSession().setAttribute("user", userService.getUserByName(userName));
            resp.sendRedirect("/home");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/register.jsp");
        requestDispatcher.forward(req, resp);
    }
}