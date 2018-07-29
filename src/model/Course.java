package model;

import controller.ControllerUtil;

import java.io.File;
import java.io.Serializable;

public class Course implements Serializable {
    private final static String COURSEIMGPATH = "res/course_img/";
    private Integer courseId;
    private Integer userId;
    private String courseName;
    private String introduction;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCourseImage() {
        String imgPath = COURSEIMGPATH + courseId + "/";
        if (ControllerUtil.checkFileExist(imgPath)) {
            File[] files = ControllerUtil.getFilesByPath(imgPath);
            if (files.length > 0) return imgPath + files[0].getName();
        }
        return COURSEIMGPATH + "default_background.jpg";
    }
}
