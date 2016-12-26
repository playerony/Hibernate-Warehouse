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
public class PickingButtonAction extends AbstractPickingAction implements SessionAware {
    private Map<String, Object> session;
    
    @Override
    public void validate() {
        
    }
    
    @Override
    public String execute() {
        return SUCCESS;
    }
    
    public String finishButtonAction(){
        orderDao.updateOrderValue(Integer.parseInt((String) session.get("orderID")), (String) session.get("items"));
        pickingDao.createPickingPallete(Integer.parseInt((String) session.get("orderID")),
                                                            Integer.parseInt((String) session.get("userID")), 
                                                            Integer.parseInt(orderDao.getClientID(Integer.parseInt((String) session.get("orderID")))), 
                                                            (String) session.get("order"));
        
        session.put("items", null);
        session.put("orderID", null);
        session.put("order", null);
        session.put("check", null);
        
        return (String) session.get("rank");
    }
    
    public String backButtonAction(){
        session.put("items", null);
        session.put("orderID", null);
        session.put("order", null);
        session.put("check", null);
        
        return (String) session.get("rank");
    }
    
    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
