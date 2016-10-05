package com.so.webblog.service;

import com.so.webblog.domain.UserRole;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserRoleService {
    UserRole byId(Serializable id);
    List<UserRole> list();
    void save(UserRole u);
    void update(UserRole u);
    void delete(UserRole u);
}