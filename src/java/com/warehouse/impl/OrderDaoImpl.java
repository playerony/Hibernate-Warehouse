/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.picking.OrderDao;
import com.warehouse.entity.Order;
import com.warehouse.service.OrderService;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class OrderDaoImpl implements OrderDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean checkOrderById(int id) {
        for(Order o : OrderService.list(sessionFactory))
            if(o.getId() == id)
                return true;
        
        return false;
    }

    @Override
    public String getProducts(int id) {
        for(Order o : OrderService.list(sessionFactory))
            if(o.getId() == id)
                return o.getItems();
        
        return null;
    }

    @Override
    public int getClientID(int id) {
        for(Order o : OrderService.list(sessionFactory))
            if(o.getId() == id)
                return o.getClient().getId();
        
        return -1;
    }

    @Override
    public boolean updateOrderValue(int id, String phrase) {
        for(Order o : OrderService.list(sessionFactory))
            if(o.getId() == id){
                o.setItems(phrase);
                OrderService.update(o, sessionFactory);
                
                return true;
            }
        
        return false;
    }

    @Override
    public boolean deleteOrder(int id) {
         for(Order o : OrderService.list(sessionFactory))
            if(o.getId() == id){
                OrderService.delete(o, sessionFactory);
                return true;
            }
        
        return false;
    }
    
}
