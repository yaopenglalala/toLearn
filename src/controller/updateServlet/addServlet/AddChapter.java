package controller.updateServlet.addServlet;

import model.Chapter;
import model.User;
import service.ChapterService;
import service.serviceImpl.ChapterSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addChapter")
public class AddChapter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChapterService chapterService = new ChapterSerImpl();

        String courseIdString = req.getParameter("courseid");
        System.out.println(req.getParameter("chapter"));
        String chapterString = new String(req.getParameter("chapter").getBytes("ISO8859-1"),"UTF-8");

        if (courseIdString != null){
            if (!courseIdString.trim().equals("") && !chapterString.trim().equals("")){
                Chapter chapter = new Chapter();
                chapter.setCourseId(Integer.parseInt(courseIdString));
                chapter.setChapterName(chapterString);
                chapterService.addChapter(chapter);
            }
        }
        resp.sendRedirect("/detail?courseid="+courseIdString);
    }
}
