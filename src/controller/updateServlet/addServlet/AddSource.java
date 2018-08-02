package controller.updateServlet.addServlet;

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

@WebServlet("/addSource")
public class AddSource extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf8");

        try{
            List<FileItem> fileItems = upload.parseRequest(req);

            Integer courseid = null;
            //Get course id
            for (FileItem fileItem : fileItems){
                if (fileItem.isFormField()){
                    switch (fileItem.getFieldName()) {
                        case "courseid":
                            courseid = Integer.parseInt(fileItem.getString("utf8"));
                            break;
                    }
                }
            }

            if (courseid == null) {
                resp.sendRedirect("/source?courseid=" + courseid);
            }

            //Up load file
            for (FileItem fileItem : fileItems){
                if (!fileItem.isFormField()){
                    ControllerUtil.upLoadFile(fileItem, "res/material/" + courseid + "/" , false);
                }
            }

            resp.sendRedirect("/source?courseid=" + courseid);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("/home");
        }
    }
}
