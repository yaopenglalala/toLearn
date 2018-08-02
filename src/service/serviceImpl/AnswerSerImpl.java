package service.serviceImpl;

import dao.classDao.AnswerDao;
import model.Answer;
import service.AnswerService;

import java.util.List;

public class AnswerSerImpl implements AnswerService {
    private AnswerDao answerDao;

    public AnswerSerImpl (){
        answerDao = new AnswerDao();
    }

    @Override
    public boolean addAnswer(Answer answer) {
        return answerDao.addAnswer(answer);
    }

    @Override
    public boolean removeAnswer(Integer userId, Integer taskId) {
        if (!checkAnswered(userId, taskId)) return false;
        return answerDao.removeAnswer(userId, taskId);
    }

    @Override
    public boolean update(Answer answer) {
        if (!checkAnswered(answer.getUserId(), answer.getTaskId())) return false;
        return answerDao.updateAnswer(answer);
    }

    @Override
    public boolean checkAnswered(Integer userId, Integer taskId) {
        return getAnswer(userId, taskId) != null;
    }

    @Override
    public Answer getAnswer(Integer userId, Integer taskId) {
        return answerDao.getAnswerByUIdAndTId(userId, taskId);
    }

    @Override
    public List<Answer> getUserAnswers(Integer userId) {
        return answerDao.getAnswersByUserId(userId);
    }

    @Override
    public List<Answer> getTaskAnswers(Integer taskId) {
        return answerDao.getAnswersByTaskId(taskId);
    }
}
