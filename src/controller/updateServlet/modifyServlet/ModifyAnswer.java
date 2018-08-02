package controller.updateServlet.modifyServlet;

import model.Answer;
import model.User;
import service.AnswerService;
import service.serviceImpl.AnswerSerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifyAnswer")
public class ModifyAnswer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String taskIdString = req.getParameter("taskid");
        try{
            Integer taskId = Integer.parseInt(taskIdString);
            String answerString = new String(req.getParameter("answer").getBytes("ISO8859-1"),"UTF-8");

            AnswerService answerService = new AnswerSerImpl();

            Answer answer = answerService.getAnswer(user.getUserId(), taskId);
            answer.setAnswerContent(answerString);
            answerService.update(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/answer?taskid=" + taskIdString);
    }
}
