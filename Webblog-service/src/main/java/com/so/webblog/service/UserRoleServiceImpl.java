package com.so.webblog.service;

import com.so.webblog.domain.UserRole;
import com.so.webblog.domain.UserRoleDao;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserRoleServiceImpl implements UserRoleService{
    
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public UserRole byId(Serializable id) {
        return userRoleDao.byId(id);
    }

    @Override
    public List<UserRole> list() {
        return userRoleDao.list();
    }

    @Override
    public void save(UserRole u) {
        userRoleDao.save(u);
    }

    @Override
    public void update(UserRole u) {
        userRoleDao.update(u);
    }

    @Override
    public void delete(UserRole u) {
        userRoleDao.delete(u);
    } 
}