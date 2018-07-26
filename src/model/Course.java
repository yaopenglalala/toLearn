package model;

import controller.ControllerUtil;

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
        String imgPath = COURSEIMGPATH + courseId +".png";
        if (ControllerUtil.checkFileExist(imgPath)) return imgPath;
        else return COURSEIMGPATH + "default_background.jpg";
    }
}
