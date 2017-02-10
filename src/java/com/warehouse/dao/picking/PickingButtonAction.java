/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.PalletsPicked;
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
        if(String.valueOf(session.get("items")).length() > 0){
            if(!orderDao.updateOrderValue(Integer.parseInt(String.valueOf(session.get("orderID"))), String.valueOf(session.get("items")))){
                return INPUT;
            }
        }else
            orderDao.deleteOrder(Integer.parseInt(String.valueOf(session.get("orderID"))));
        
        if(!orderDao.getClientID(Integer.parseInt(String.valueOf(session.get("orderID")))).equals("error") && 
            (String)session.get("order") != null &&
            pickingDao.createPickingPallete(new PalletsPicked(0, Integer.parseInt(String.valueOf(session.get("userID"))), 
            Integer.parseInt(orderDao.getClientID(Integer.parseInt(String.valueOf(session.get("orderID"))))), 
            String.valueOf(session.get("order")))))
        {
            session.put("items", null);
            session.put("orderID", null);
            session.put("order", null);
            session.put("check", null);
            session.put("safe", null);

            return (String) session.get("rank");
        }else{
            if(orderDao.updateOrderValue(Integer.parseInt(String.valueOf(session.get("orderID"))), String.valueOf(session.get("safe")))){
                return INPUT;
            }
            
            return "error";
        }
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
