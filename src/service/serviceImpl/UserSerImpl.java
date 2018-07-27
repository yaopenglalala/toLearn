package service.serviceImpl;

import dao.classDao.UserDao;
import model.User;
import service.UserService;

public class UserSerImpl implements UserService {
    private  UserDao userDao;

    public UserSerImpl(){
        userDao = new UserDao();
    }

    //通过用户名得到用户
    public User getUserByName(String name){
        User rs = userDao.getUserByName(name);
        rs.setPassword("");
        return rs;
    }

    @Override
    public User getUserById(Integer userId) {
        User rs = userDao.getUserById(userId);
        rs.setPassword("");
        return rs;
    }

    //添加用户
    public boolean addUser(String userName, String password){
        User user = new User();
        if (userName == null || password == null ||
                userName.equals("") || password.equals("")) return false;
        user.setUserName(userName);
        user.setPassword(password);
        return userDao.addUser(user);
    }

    //删除用户
    public boolean removeUser(Integer userId){
        User user = new User();
        user.setUserId(userId);
        return userDao.removeUser(userId);
    }

    //检测用户密码是否正确
    public boolean checkUser(String userName, String password){
        User user = userDao.getUserByName(userName);
        if (user == null || user.getUserId() == 0) return false;
        else return user.getPassword().equals(password);
    }

    //修改用户信息
    public boolean updateUser(User user){
        return userDao.updateUser(user);
    }
}
