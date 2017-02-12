/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.PalletsPacked;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class PackingService {
    public static void insert(PalletsPacked palletsPacked, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(palletsPacked);
        
        transaction.commit();
        session.close();
    }
    
    public static void update(PalletsPacked palletsPacked, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(palletsPacked);
        
        transaction.commit();
        session.close();
    }
    
    public static void delete(PalletsPacked palletsPacked, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(palletsPacked);
        
        transaction.commit();
        session.close();
    }
    
    public static List<PalletsPacked> list(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<PalletsPacked> packedList = session.createQuery("from PalletsPacked").list();
        session.close();
        
        return packedList;
    }
}
