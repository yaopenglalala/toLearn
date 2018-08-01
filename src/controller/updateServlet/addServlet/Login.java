package controller.updateServlet.addServlet;

import controller.ControllerUtil;
import service.UserService;
import service.serviceImpl.UserSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        if (userName == null) userName = "";
        if (password == null) password = "";
        userName = userName.trim();
        password = password.trim();

        UserService userService = new UserSerImpl();

        if (userService.getUserByName(userName) == null) {
            req.setAttribute("err", "This user doesn't exist!");
            doGet(req, resp);
        } else if (!userService.checkUser(userName, ControllerUtil.getMD5(password))){
            req.setAttribute("err", "Password is wrong!");
            doGet(req,resp);
        } else {
            req.getSession().setAttribute("user", userService.getUserByName(userName));
            resp.sendRedirect("/home");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/login.jsp");
        requestDispatcher.forward(req, resp);
    }
}
