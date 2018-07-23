package service.serviceImpl;

import dao.classDao.ChapterDao;
import model.Chapter;
import service.ChapterService;
import service.CourseService;

import java.util.List;

public class ChapterSerImpl implements ChapterService {
    private ChapterDao chapterDao;

    public ChapterSerImpl(){
        chapterDao = new ChapterDao();
    }

    @Override
    public List<Chapter> getChapters(Integer courseId) {
        return chapterDao.getChaptersByCourseId(courseId);
    }

    @Override
    public Chapter getChapter(Integer chapterId) {
        return chapterDao.getChapterByChapterId(chapterId);
    }

    @Override
    public boolean addChapter(Chapter chapter) {
        CourseService courseService = new CourseSerImpl();
        if (courseService.getCourseByCourseId(chapter.getCourseId()) == null) return false;
        else {
            return chapterDao.addChapter(chapter);
        }
    }

    @Override
    public boolean removeChapter(Integer chapterId) {
        CourseService courseService = new CourseSerImpl();
        if (courseService.getCourseByCourseId(chapterId) == null) return false;
        else {
            return chapterDao.removeChapter(chapterId);
        }
    }

    @Override
    public boolean updateChapter(Chapter chapter) {
        Chapter chapterIdRes = getChapter(chapter.getChapterId());
        if (chapterIdRes == null || !chapterIdRes.getCourseId().equals(chapter.getCourseId())) return false;
        else {
            chapterDao.updateChapter(chapter);
            return true;
        }
    }


}
