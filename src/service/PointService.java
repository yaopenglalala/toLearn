package service;

import model.Chapter;
import model.Course;
import model.Point;

import java.util.List;

public interface PointService {
    //通过章节id得到知识点列表
    List<Point> getPoints(Integer chapterId);

    //通过知识点id得到知识点信息
    Point getPoint(Integer pointId);

    //添加知识点
    boolean addPoint(Point point);

    //删除知识点
    boolean removePoint(Integer pointId);

    //修改知识点信息
    boolean updatePoint(Point point);

    Course getCourseByPoint(Point point);
}
