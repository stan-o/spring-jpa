package com.so.webblog.service;

import com.so.webblog.domain.RoleName;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserRoleNameService {
    RoleName byId(Serializable id);
    List<RoleName> list();
    void save(RoleName u);
    void update(RoleName u);
    void delete(RoleName u);
}