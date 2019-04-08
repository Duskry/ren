package com.serviceImpl;

import com.dao.UserDao;
import com.entity.UserEntity;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public boolean login(UserEntity user) {

        UserEntity login = userDao.login(user);

        if(login == null) {
            System.out.println("用户名或者密码错误");
            return false;
        }else {
            return true;
        }
    }
}
