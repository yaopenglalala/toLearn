package controller.updateServlet.modifyServlet;

import model.Chapter;
import service.ChapterService;
import service.serviceImpl.ChapterSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyChapter")
public class ModifyChapter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChapterService chapterService = new ChapterSerImpl();
        String chapterIdString = req.getParameter("chapterid");
        Integer courseId = 1;
        try{
            Integer chapterId = Integer.parseInt(chapterIdString);
            String chapterString = new String(req.getParameter("chapter").getBytes("ISO8859-1"),"UTF-8");

            Chapter chapter = chapterService.getChapter(chapterId);
            chapter.setChapterName(chapterString);
            courseId = chapter.getCourseId();

            chapterService.updateChapter(chapter);
        } catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/detail?courseid=" + courseId);
    }
}
