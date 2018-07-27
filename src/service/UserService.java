package service;

import model.User;

public interface UserService {
    //通过用户名得到用户
    User getUserByName(String name);

    //通过用户id得到用户
    User getUserById(Integer userId);

    //添加用户
    boolean addUser(String userName, String password);

    //删除用户
    boolean removeUser(Integer userId);

    //检测用户密码是否正确
    boolean checkUser(String userName, String password);

    //修改用户信息
    boolean updateUser(User user);

    //搜索
    //todo
}
