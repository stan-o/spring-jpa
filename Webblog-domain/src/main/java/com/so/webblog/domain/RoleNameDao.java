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
public interface RoleNameDao {
    RoleName byId(Serializable id);
    List<RoleName> list();
    void save(RoleName u);
    void update(RoleName u);
    void delete(RoleName u);
    void delete(Serializable id);
    
}
