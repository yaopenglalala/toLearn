package service;

import model.Answer;
import model.Course;
import model.User;

import java.util.List;

public interface AnswerService {
    //答题
    boolean addAnswer(Answer answer);

    //放弃答案
    boolean removeAnswer(Integer userId, Integer taskId);

    //更新答案
    boolean update(Answer answer);

    //判断是否作答
    boolean checkAnswered(Integer userId, Integer courseId);

    //得到用户的该问作答
    Answer getAnswer(Integer userId, Integer taskId);

    //得到用户的所有答案
    List<Answer> getUserAnswers(Integer userId);

    //得到该问题的所有答案
    List<Answer> getTaskAnswers(Integer taskId);
}
