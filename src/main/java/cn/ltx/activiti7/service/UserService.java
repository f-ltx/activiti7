package cn.ltx.activiti7.service;

import cn.ltx.activiti7.dao.UserDao;
import cn.ltx.activiti7.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findById(User user) {
        return userDao.findByUserGuid(user.getUserGuid());
    }
}
