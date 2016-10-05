package com.so.webblog.service;

import com.so.webblog.domain.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserService {
    User byId(Serializable id);
    User byUsername(String name);
    List<User> list();
    void save(User u);
    void update(User u);
    void delete(User u);
}
