/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.domain;

import com.so.webblog.config.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class RoleNameDaoImpl implements RoleNameDao{
    
    Session session;
    public RoleNameDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public RoleName byId(Serializable id) {
        return (RoleName)session.createCriteria(RoleName.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<RoleName> list() {
        return session.createCriteria(RoleName.class).list();
    }

    @Override
    public void save(RoleName u) {
        session.getTransaction().begin();
        try{
            session.save(u);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(RoleName u) {
        session.getTransaction().begin();
        try{
            session.update(u);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(RoleName u) {
        session.getTransaction().begin();
        try{
            session.delete(u);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
