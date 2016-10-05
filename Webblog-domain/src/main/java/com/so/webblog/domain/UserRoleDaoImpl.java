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
public class UserRoleDaoImpl implements UserRoleDao{

    Session session;
    public UserRoleDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public UserRole byId(Serializable id) {
        return (UserRole)session.createCriteria(UserRole.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<UserRole> list() {
        return session.createCriteria(UserRole.class).list();
    }

    @Override
    public void save(UserRole u) {
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
    public void update(UserRole u) {
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
    public void delete(UserRole u) {
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
