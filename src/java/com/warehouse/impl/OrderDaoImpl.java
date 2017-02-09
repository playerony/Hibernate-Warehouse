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
        Order order = OrderService.list(sessionFactory).get(id);
        
        return order != null;
    }

    @Override
    public String getProducts(int id) {
        return OrderService.list(sessionFactory).get(id).getItems();
    }

    @Override
    public String getClientID(int orderID) {
        return String.valueOf(OrderService.list(sessionFactory).get(orderID).getClient().getId());
    }

    @Override
    public boolean updateOrderValue(int id, String phrase) {
        try{
            Order order = OrderService.list(sessionFactory).get(id);
            order.setItems(phrase);

            OrderService.update(order, sessionFactory);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }

    @Override
    public boolean deleteOrder(int id) {
        try{
            OrderService.delete(OrderService.list(sessionFactory).get(id), sessionFactory);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
    
}
