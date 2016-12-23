package com.so.webblog.service;

import com.so.webblog.domain.User;

/**
 *
 * @author user
 */
public interface UserService extends BaseService<User, Integer>{
    User byUsername(String name);
}
