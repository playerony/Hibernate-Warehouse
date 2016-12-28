/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.Order;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class OrderDao {
    
    public boolean checkOrderById(final int id){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Order o where o.id=:orderId";
            Query query = session.createQuery(sql);
            query.setParameter("orderId", id);
            List<Order> list = query.list();

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
    
    public String getProducts(final int id){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from Order o where o.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            List<Order> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return list.get(0).getItems();
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return "error";
    }
    
    public String getClientID(final int orderID){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from Order o where o.client.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("id", orderID);
            List<Order> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return String.valueOf(list.get(0).getClient().getId());
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return "error";
    }
    
    public boolean updateOrderValue(final int id, final String phrase){
        boolean result = false;
        
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String sql = " update Order o set o.items=:value where o.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("value", phrase);
            query.setParameter("id", id);

            int value = query.executeUpdate();
            if(value==0)
                result = false;
            else
                result = true;
            
            tx.commit();

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public boolean deleteOrder(final int id){
        boolean result = false;
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " delete Order where id=:value";
            Query query = session.createQuery(sql);
            query.setParameter("value", id);
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
}
