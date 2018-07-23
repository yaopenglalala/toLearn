package service;

import model.Chapter;
import model.Course;

import java.util.List;

public interface ChapterService {
    //通过课程id得到章节列表
    List<Chapter> getChapters(Integer courseId);

    //通过章节id得到章节信息
    Chapter getChapter(Integer chapterId);

    //添加章节
    boolean addChapter(Chapter chapter);

    //删除章节
    boolean removeChapter(Integer chapterId);

    //修改章节信息
    boolean updateChapter(Chapter chapter);

    //搜索
    //todo
}
