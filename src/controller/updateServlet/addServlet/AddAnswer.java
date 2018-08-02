package controller.updateServlet.addServlet;

import model.Answer;
import model.Task;
import model.User;
import service.AnswerService;
import service.serviceImpl.AnswerSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addAnswer")
public class AddAnswer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String taskIdString = req.getParameter("taskid");
        try {
            Integer taskId = Integer.parseInt(taskIdString);

            Answer answer = new Answer();
            answer.setUserId(user.getUserId());
            answer.setTaskId(taskId);
            answer.setAnswerContent(new String(req.getParameter("answer").getBytes("ISO8859-1"),"UTF-8"));

            AnswerService answerService = new AnswerSerImpl();

            if (answerService.getAnswer(user.getUserId(), taskId) == null) answerService.addAnswer(answer);

        } catch (Exception e){
            e.printStackTrace();
        }

        resp.sendRedirect("/answer?taskid="+taskIdString);
    }
}
