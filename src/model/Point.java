package model;

import controller.ControllerUtil;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Point implements Serializable {
    private final static String VIDEOPATH = "res/video/point/";
    private Integer pointId;
    private Integer chapterId;
    private String pointName;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

}
