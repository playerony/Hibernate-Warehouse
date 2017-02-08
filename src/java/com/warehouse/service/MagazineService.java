/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.service;

import com.warehouse.entity.PalletsInMagazine;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class MagazineService {
    public static void update(PalletsInMagazine palletsInMagazine, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(palletsInMagazine);
        
        transaction.commit();
        session.close();
    }
    
    public static void delete(PalletsInMagazine palletsInMagazine, SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(palletsInMagazine);
        
        transaction.commit();
        session.close();
    }
    
    public static List<PalletsInMagazine> list(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<PalletsInMagazine> palletsInMagazineList = session.createQuery("from PalletsInMagazine").list();
        session.close();
        
        return palletsInMagazineList;
    }
}
