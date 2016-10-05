package com.so.webblog.service;

import com.so.webblog.domain.User;
import com.so.webblog.domain.UserDao;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User byId(Serializable id) {
        return userDao.byId(id);
    }

    @Override
    public User byUsername(String name) {
        return userDao.byUsername(name);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public void save(User u) {
        userDao.save(u);
    }

    @Override
    public void update(User u) {
        userDao.update(u);
    }

    @Override
    public void delete(User u) {
        userDao.delete(u);
    }
}