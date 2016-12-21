/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.opensymphony.xwork2.ActionSupport;
import com.warehouse.entity.Client;
import com.warehouse.entity.Order;

/**
 *
 * @author pawel_000
 */
public abstract class AbstractPickingAction extends ActionSupport{
    protected Order order;
    protected Client client;
    protected ClientDao clientDao = new ClientDao();
    protected OrderDao orderDao = new OrderDao();
    
    @Override
     public abstract void validate();
     @Override
     public abstract String execute();
     
     public Client getClient() {
        return client;
    }
 
    public void setClient(Client client) {
        this.client = client;
    } 
    
    public Order getOrder() {
        return order;
    }
 
    public void setOrder(Order order) {
        this.order = order;
    } 
}
