package controller.updateServlet;

import controller.ControllerUtil;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addPointVideo")
public class AddPointVideo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf8");

        try{
            List<FileItem> fileItems = upload.parseRequest(req);
            Integer pointId = Integer.parseInt(req.getParameter("pointid"));

            for (FileItem fileItem : fileItems){
                if (!fileItem.isFormField()){
                    ControllerUtil.upLoadFile(fileItem, "res/video/" + pointId + "/" , false);
                }
            }
            resp.sendRedirect("/point?pointid="+pointId);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("/home");
        }
    }
}
