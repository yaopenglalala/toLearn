package controller.updateServlet;

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
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }

        ChapterService chapterService = new ChapterSerImpl();

        String courseIdString = req.getParameter("courseid");
        String chapterString = req.getParameter("chapter");

        if (courseIdString != null && chapterString != null){
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
