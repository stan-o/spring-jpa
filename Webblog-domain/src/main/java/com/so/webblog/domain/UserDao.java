/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserDao {
    User byId(Serializable id);
    User byUsername(String username);
    List<User> list();
    void save(User u);
    void update(User u);
    void delete(User u);
    void delete(Serializable id);
}
