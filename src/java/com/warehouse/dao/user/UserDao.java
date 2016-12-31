/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.warehouse.entity.User;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
class UserDao {
    
    public boolean find(final String name, final String password) {
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " from User u where u.login=:name and u.password=:pass";
            Query query = session.createQuery(sql);
            query.setParameter("name", name);
            query.setParameter("pass", password);
            List<User> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return true;
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean findUserByLogin(final String login) {
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " from User u where u.login=:name";
            Query query = session.createQuery(sql);
            query.setParameter("name", login);
            List<User> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return true;
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean addWorker(final int id, final String firstname, final String lastname, final String login, 
                                                   final String password, final String place, final String rank)
    {
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            User user = new User(id, firstname, lastname, login, password, place, rank);

            session.save(user);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
            
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteWorker(final String firstname, final String lastname){
        boolean result = false;
        
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " delete User where firstname=:name and lastname=:surname";
            Query query = session.createQuery(sql);
            query.setParameter("name", firstname);
            query.setParameter("surname", lastname);
            int value = query.executeUpdate();

            if(value==0)
                result = false;
            else
                result = true;

            session.getTransaction().commit(); 
            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public String getUserRank(final String name, final String password){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " from User u where u.login=:name and u.password=:pass";
            Query query = session.createQuery(sql);
            query.setParameter("name", name);
            query.setParameter("pass", password);
            List<User> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return list.get(0).getRank();
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return "error";
    }
    
    public String getUserID(final String name, final String password){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " from User u where u.login=:name and u.password=:pass";
            Query query = session.createQuery(sql);
            query.setParameter("name", name);
            query.setParameter("pass", password);
            List<User> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return String.valueOf(list.get(0).getId());
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return "error";
    }
}
