/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pawel_000
 */
public class CheckOrderNumber extends AbstractPickingAction implements SessionAware{
    private Map<String, Object> session;

    @Override
    public void validate() {
        if(String.valueOf(order.getId()).equals("0")) {
            addActionError("It's not a number!!");
        }
        
        if(order.getId() <= 0) {
            addActionError("Wrong number");
        }
    }

    @Override
    public String execute() {
        if(orderDao.checkOrderById(order.getId())){
            session.put("orderID", String.valueOf(order.getId()));
            session.put("items", orderDao.getProducts(order.getId()));
            session.put("order", null);
            
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
         this.session = map;
    }
    
}
