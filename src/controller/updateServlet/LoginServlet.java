package controller.updateServlet;

import controller.ControllerUtil;
import service.UserService;
import service.serviceImpl.UserSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        if (userName == null) userName = "";
        if (password == null) password = "";
        userName = userName.trim();
        password = password.trim();

        UserService userService = new UserSerImpl();

        System.out.println(userName);

        if (userService.checkUser(userName, password)) {
            String file = "res/default_background.jpg";
            if (ControllerUtil.checkFileExist(file)){
                req.getSession().setAttribute("url", file);
                File[] files = ControllerUtil.getFilesByPath("res/course_img");
                for (File file1 : files){
                    System.out.println(file1.getPath());
                }
                resp.sendRedirect("/index.jsp");
            } else {
                req.getSession().setAttribute("url", null);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
