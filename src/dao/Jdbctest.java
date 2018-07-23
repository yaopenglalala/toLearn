package dao;

import model.Chapter;
import model.Course;
import model.User;
import service.ChapterService;
import service.CourseService;
import service.serviceImpl.ChapterSerImpl;
import service.serviceImpl.CourseSerImpl;
import service.serviceImpl.UserSerImpl;

import java.io.File;
import java.util.List;

public class Jdbctest {
    public static void main(String[] args) {
        UserSerImpl userSerImpl = new UserSerImpl();
        userSerImpl.addUser("fsa", "ffsa");
        System.out.println(userSerImpl.checkUser("fsa","ffsa"));
        System.out.println(userSerImpl.removeUser(25));
        User user =  userSerImpl.getUser("fsa");
        user.setPassword("f123456");
        userSerImpl.updateUser(user);

        Course course = new Course();
        course.setUserId(1);
        course.setCourseName("fafsad");
        CourseService courseSer = new CourseSerImpl();
        //courseSer.addCourse(course);

        Chapter chapter = new Chapter();
        List<Course> courses = courseSer.getCoursesByUserId(1);
        chapter.setChapterName("fuckchapter");
        ChapterService chapterSer = new ChapterSerImpl();
        for (Course course1 : courses){
            chapter.setCourseId(course1.getCourseId());
            chapterSer.addChapter(chapter);
        }
        chapter.setChapterId(1);
        chapter.setChapterName("someonelikeyou");
        chapterSer.updateChapter(chapter);

//        File[] files = new File("./").listFiles();
//        for (File file : files){
//            System.out.println(file.getName());
//        }

    }
}
