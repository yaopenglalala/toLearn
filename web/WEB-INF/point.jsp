<%@ page import="model.Course" %>
<%@ page import="model.Chapter" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Point" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<%-----------%>
<%
    //这个页面对应的课程
    Course course = (Course) request.getAttribute("course");

    //这个页面对应的章节
    Chapter chapter = (Chapter) request.getAttribute("chapter");

    //这个页面对应的知识点
    Point point = (Point) request.getAttribute("point");

    //章节列表
    List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");

    //章节对应的知识点，以<Integer, List<Point>>存储，即章节id对应知识点列表
    Map<Integer, List<Point>> points = (Map<Integer, List<Point>>) request.getAttribute("points");

    //知识点对应的视频文件名列表
    List<String> videos = (List<String>) request.getAttribute("videos");

    //判断是否是老师
    Boolean isTeacher = course.getUserId().equals(user.getUserId());
%>
<%-----------%>
<%
%>
<html>
<head>
    <title>To Learn</title>
    <script src="../js/preview.js"></script>
</head>
<body>
<div class="container" style="padding: 10px;">

    <div class="row" style="margin-top: 10px;">
        <div class="col-4">
            <%for(Chapter chapter1:chapters){%>
            <div class="list-group" style="margin-top: 10px;">
                <a href="#" class="list-group-item list-group-item-action active"><%=chapter.getChapterName()%></a>
                <% for(Point point1 : points.get(chapter1.getChapterId())){%>
                <a href="point?pointid=<%=point1.getPointId()%>" class="list-group-item list-group-item-action"><%=point1.getPointName()%></a>
                <%}%>
            </div>
            <%}%>
        </div>

        <div class="col-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#"><%=chapter.getChapterName()%></a></li>
                    <li class="breadcrumb-item"><a href="#"><%=point.getPointName()%></a></li>
                </ol>
            </nav>
            <% if(isTeacher){ %>
            <form method="post" action="addPointVideo" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="file" name="file">
                    <button id="video_chooser" type="button" class="btn btn-primary">选择视频</button>
                    <button id="upload" type="submit" class="btn btn-primary">上传</button>

                    <input name="pointid" value="<%= point.getPointId()%>" hidden>
                    <%--<input id="upload_video" accept="video/mp4" type="file" name="video" hidden="">--%>
                </div>
            </form>
            <% } %>
            <% if(videos != null) {
                for (String video : videos){ %>
            <iframe style="width: 100%; height: 70%; margin-top: 20px;" src="<%= video%>" controls="controls">
                您的浏览器不支持 iframe 标签。
            </iframe>
                <% if (course.getUserId().equals(user.getUserId())) { %>
                    <form action="/remove" method="post">
                        <input type="text" name="src" value="<%= video%>" hidden>
                        <input type="submit" value="remove"/>
                    </form>
                    <% }
                }
            %>
            <% }%>
        </div>
    </div>
</div>

</body>
</html>
