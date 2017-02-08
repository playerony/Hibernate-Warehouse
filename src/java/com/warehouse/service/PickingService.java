/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.PalletsPicked;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class PickingService {
    public static void insert(PalletsPicked palletsPicked, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(palletsPicked);
        
        transaction.commit();
        session.close();
    }
    
    public static void update(PalletsPicked palletsPicked, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(palletsPicked);
        
        transaction.commit();
        session.close();
    }
    
    public static void delete(PalletsPicked palletsPicked, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(palletsPicked);
        
        transaction.commit();
        session.close();
    }
    
    public static List<PalletsPicked> list(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<PalletsPicked> pickedList = session.createQuery("from PalletsPicked").list();
        session.close();
        
        return pickedList;
    }
}
