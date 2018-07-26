package controller;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import javafx.application.Application;
import javafx.stage.Stage;
import model.User;
import service.UserService;
import service.serviceImpl.UserSerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/test")
public class TestServelet extends HttpServlet {
    UserService userService = new UserSerImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        User user = new UserSerImpl().getUser("fsa");
        getServletContext().setAttribute("a",user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/hide.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
