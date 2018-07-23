package service.serviceImpl;

import dao.classDao.PointDao;
import model.Chapter;
import model.Point;
import service.ChapterService;
import service.CourseService;
import service.PointService;

import java.util.List;

public class PointSerImpl implements PointService {
    private PointDao pointDao;

    public PointSerImpl(){
        pointDao = new PointDao();
    }

    @Override
    public List<Point> getPoints(Integer chapterId) {
        return pointDao.getPointsByChapterId(chapterId);
    }

    @Override
    public Point getPoint(Integer pointId) {
        return pointDao.getPointByPointId(pointId);
    }

    @Override
    public boolean addPoint(Point point) {
        ChapterService chapterService = new ChapterSerImpl();
        if (chapterService.getChapter(point.getChapterId()) == null) return false;
        else return pointDao.addPoint(point);
    }

    @Override
    public boolean removePoint(Integer pointId) {
        return pointDao.removePoint(pointId);
    }

    @Override
    public boolean updatePoint(Point point) {
        Point pointIdRes = getPoint(point.getPointId());
        if (pointIdRes == null || !pointIdRes.getChapterId().equals(point.getChapterId())) return false;
        else {
            pointDao.updatePoint(point);
            return true;
        }
    }
}
