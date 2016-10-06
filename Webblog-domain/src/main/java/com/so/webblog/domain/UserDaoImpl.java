package com.so.webblog.domain;

import com.so.webblog.config.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Component
public class UserDaoImpl implements UserDao{
    
//    @Autowired
    private Session session;

    public UserDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    

    @Override
    public User byId(Serializable id) {
        return (User)session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public User byUsername(String username) {
        return (User)session.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
    }

    @Override
    public List<User> list() {
        return session.createCriteria(User.class).list();
    }

    @Override
//    @Transactional
    public void save(User u) {
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
    @Transactional
    public void update(User u) {
        session.getTransaction().begin();
        try{
            session.merge(u);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
        }
    }

    @Override
    @Transactional
    public void delete(User u) {
        session.getTransaction().begin();
        try{
            session.delete(u);
            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
        }  
    }

    @Override
    @Transactional
    public void delete(Serializable id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
