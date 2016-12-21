/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.warehouse.entity.User;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
class UserDao {
    public static boolean find(String name, String password) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from User u where u.login=:name and u.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        query.setParameter("pass", password);
        List<User> list = query.list();
        
        if (list.size() > 0) {
            session.close();
            return true;
        }
        
        session.close();
        return false;
    }
    
    public static boolean addWorker(int id, String firstname, String lastname, String login, String password, String place, String rank){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        User user = new User(id, firstname, lastname, login, password, place, rank);
        
        session.save(user);
        session.getTransaction().commit();
        
        session.close();  
        
        return true;
    }
    
    public static boolean deleteWorker(String firstname, String lastname){
        boolean result = false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        session.close();
        
        return result;
    }
    
    public static String getUserRank(String name, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from User u where u.login=:name and u.password=:pass";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        query.setParameter("pass", password);
        List<User> list = query.list();
        
        return list.get(0).getRank();
    }
}
