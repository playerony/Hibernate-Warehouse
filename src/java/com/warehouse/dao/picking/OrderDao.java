/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.Order;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class OrderDao {
    
    public boolean checkOrderById(int id){
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from Order o where o.id=:orderId";
        Query query = session.createQuery(sql);
        query.setParameter("orderId", id);
        List<Order> list = query.list();
        
        if (list.size() > 0) {
            session.close();
            return true;
        }
        
        session.close();
        return false;
    }
    
    public String getProducts(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from Order o where o.id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        List<Order> list = query.list();
        
        return list.get(0).getItems();
    }
    
    public String getClientID(int orderID){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = " from Order o where o.client.id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", orderID);
        List<Order> list = query.list();
        
        return String.valueOf(list.get(0).getClient().getId());
    }
    
    public void updateOrderValue(int id, String value){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String sql = " update Order o set o.items=:value where o.id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("value", value);
        query.setParameter("id", id);
        
        query.executeUpdate();
        tx.commit();
    }
}
