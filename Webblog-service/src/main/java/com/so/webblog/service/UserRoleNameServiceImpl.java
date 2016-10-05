package com.so.webblog.service;

import com.so.webblog.domain.RoleName;
import com.so.webblog.domain.RoleNameDao;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserRoleNameServiceImpl implements UserRoleNameService{
    
    @Autowired
    private RoleNameDao roleNameDao;

    @Override
    public RoleName byId(Serializable id) {
        return roleNameDao.byId(id);
    }

    @Override
    public List<RoleName> list() {
        return roleNameDao.list();
    }

    @Override
    public void save(RoleName u) {
        roleNameDao.save(u);
    }

    @Override
    public void update(RoleName u) {
        roleNameDao.update(u);
    }

    @Override
    public void delete(RoleName u) {
        roleNameDao.delete(u);
    }  
}