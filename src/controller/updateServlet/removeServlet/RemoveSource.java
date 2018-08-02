package controller.updateServlet.removeServlet;

import controller.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/remove")
public class RemoveSource extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = new String(req.getParameter("src").getBytes("ISO8859-1"),"UTF-8");
        System.out.println(path);
        ControllerUtil.removeFileByPath(path);
        resp.sendRedirect("/myspace?type=open");
    }
}
