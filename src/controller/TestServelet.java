package controller;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import javafx.application.Application;
import javafx.stage.Stage;
import model.User;
import service.UserService;
import service.serviceImpl.UserSerImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class TestServelet extends HttpServlet {
    UserService userService = new UserSerImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        List<User> user = new ArrayList<>();
        request.setAttribute("key", user);
    }
}
