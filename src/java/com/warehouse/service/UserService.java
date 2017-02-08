/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class UserService {
    public static void insert(User user, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        
        transaction.commit();
        session.close();
    }
    
    public static void delete(User user, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        
        transaction.commit();
        session.close();
    }
    
    public static List<User> list(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<User> personList = session.createQuery("from User").list();
        session.close();
        
        return personList;
    }
}
