/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.Order;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class OrderService {
    public static void update(Order order, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
        
        transaction.commit();
        session.close();
    }
    
    public static void delete(Order order, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(order);
        
        transaction.commit();
        session.close();
    }
    
    public static List<Order> list(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Order> orderList = session.createQuery("from Order").list();
        session.close();
        
        return orderList;
    }
}
