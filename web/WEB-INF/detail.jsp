<%@ page import="model.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Chapter" %>
<%@ page import="java.util.Map" %>
<%@ page import="model.Point" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.Bool" %>
<%--
  Created by IntelliJ IDEA.
  User: 妖风
  Date: 2018/7/26
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-----------%>
<%
    //这个页面对应的课程
    Course course = (Course) request.getAttribute("course");

    //章节列表
    List<Chapter> chapters = (List<Chapter>) request.getAttribute("chapters");

    //章节对应的知识点，以<Integer, List<Point>>存储，即章节id对应知识点列表
    Map<Integer, List<Point>> points = (Map<Integer, List<Point>>) request.getAttribute("points");

    //是否是选课学生
    Boolean isStudent = (Boolean) request.getAttribute("isStudent");
%>
<%-----------%>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>To Learn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%--添加章节--%>
<div class="modal" tabindex="-1" role="dialog" id="addChapterModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">添加章节</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="addChapter" id="addChapterForm">
                    <div class="form-group">
                        <label for="courseID" class="col-form-label">课程ID:</label>
                        <input name="courseid" type="text" class="form-control" id="courseID" value="<%=course.getCourseId()%>" readonly="readonly">
                    </div>
                    <div class="form-group">
                        <label for="chapter" class="col-form-label">章节名称:</label>
                        <input name="chapter" type="text" class="form-control" id="chapter">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" form="addChapterForm">添加</button>
            </div>
        </div>
    </div>
</div>

<%--添加知识点--%>
<div class="modal" tabindex="-1" role="dialog" id="addPointModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">添加新知识点</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="addPoint" method="post" id="addPointForm" class="card-body">
                    <div class="form-group">
                        <label>章节ID</label>
                        <input id="chapterIdId" type="text" class="form-control" name="chapterid" readonly="readonly">
                    </div>
                    <div class="form-group row">
                        <label for="PointDescription" class="col-form-label">知识点名称</label>
                        <input type="text" class="form-control" name="point" id="PointDescription">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" form="addPointForm">添加</button>
            </div>
        </div>
    </div>
</div>

<%--页面内容--%>
<div class="container" style="padding: 10px;">
    <h3><span class="badge badge-secondary"><%=course.getCourseName()%></span></h3>
    <div class="row" style="margin-top: 10px;">
        <div class="col-6">
            <div id="accordion">
                <div class="card">
                <!--对章节循环-->
                <% for (Chapter chapter:chapters){ %>
                    <div class="card-header" id="heading">
                        <h5 class="mb-0">
                            <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapse" aria-expanded="false" aria-controls="collapse"><%=chapter.getChapterName()%></button>
                            <% if (course.getUserId().equals(user.getUserId())){%>
                            <button id="addPointButton" class="btn btn-link addPointButton" style="float: right;" data-toggle="modal" data-target="#addPointModal" onclick="addPoint(<%=chapter.getChapterId()%>)">添加知识点</button>
                            <%}%>
                        </h5>
                    </div>
                    <div id="collapse" class="collapse" aria-labelledby="heading" data-parent="#accordion" style="">
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <!-- 对章节知识点循环 -->
                                <% for (Point point:points.get(chapter.getChapterId())){%>
                                <li class="list-group-item list-group-item-action"><a href="point?pointid=<%=point.getPointId()%>"><%=point.getPointName()%></a></li>
                                <%}%>
                            </ul>
                        </div>
                    </div>
                <% } %>
                </div>
            </div>
        </div>
        <div class="col-2"> </div>
        <div class="col-4">
            <%
                if(!isStudent&&!course.getUserId().equals(user.getUserId())){
            %>
            <form action="addRecord" method="post">
                <input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden/>
                <input type="submit" value="选课"/>
            </form>
            <%
                }else {
            %>
            <a type="button" class="btn btn-primary" style="margin: 5px" href="source?courseid=<%= course.getCourseId()%>"> 资源 </a>
            <a type="button" class="btn btn-primary" style="margin: 5px" href="task?courseid=<%= course.getCourseId()%>"> 作业 </a>
            <%
                    if (course.getUserId().equals(user.getUserId())){
            %>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addChapterModal"> 添加章节 </button>
            <%
                    }else {
            %>
            <form action="removeRecord" method="post">
                <input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden/>
                <button type="submit" class="btn btn-primary"> 退课 </button>
            </form>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
<script src="../js/add.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>

<%--<%--%>
    <%--if (!isStudent && !course.getUserId().equals(user.getUserId())){--%>
<%--%>--%>
<%--<form action="addRecord" method="post">--%>
    <%--<input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden/>--%>
    <%--<input type="submit" value="Select it!"/>--%>
<%--</form>--%>
<%--<%--%>
<%--} else {--%>
<%--%>--%>
<%--<a href="source?courseid=<%= course.getCourseId()%>">Source</a><br>--%>
<%--<a href="task?courseid=<%= course.getCourseId()%>">Tasks</a><br>--%>
<%--<%      if (!course.getUserId().equals(user.getUserId())){ %>--%>
<%--<form action="removeRecord" method="post">--%>
    <%--<input type="text" name="courseid" value="<%= course.getCourseId()%>" hidden/>--%>
    <%--<input type="submit" value="Quit class."/>--%>
<%--</form>--%>
<%--<%      }--%>
<%--}--%>
<%--%>--%>