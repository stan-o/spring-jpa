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
public interface UserRoleDao {
    UserRole byId(Serializable id);
    List<UserRole> list();
    void save(UserRole u);
    void update(UserRole u);
    void delete(UserRole u);
    void delete(Serializable id);
}
