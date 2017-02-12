/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

import com.warehouse.dao.picking.PickingDao;
import com.warehouse.entity.PalletsPacked;
import com.warehouse.impl.PickingDaoImpl;
import java.util.Calendar;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pawel_000
 */
public class PackingButtonAction extends AbstractPackingAction implements SessionAware{
    private Map<String, Object> session;

    @Override
    public void validate() {
        
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
    
    public String finishButtonAction(){
        int id = 0;
        int userID = Integer.parseInt(String.valueOf(session.get("userID")));
        String orderID = String.valueOf(session.get("orderID"));
        String clientID = pickingDao.getClientID(Integer.parseInt(String.valueOf(session.get("orderID"))));
        String phrase = String.valueOf(session.get("order"));
        
        if(String.valueOf(session.get("items")).length() > 0){
            if(!pickingDao.updatePickedPallete(Integer.parseInt(orderID), String.valueOf(session.get("items"))))
                return INPUT;
        }else
            pickingDao.deletePickedPallete(Integer.parseInt(String.valueOf(session.get("orderID"))));
        
        if(!clientID.contains("error") && 
            packingDao.createPackingPallete(new PalletsPacked(id, userID, Integer.parseInt(clientID), phrase, 
                                                                                                  Calendar.getInstance().getTime(), "pallete")))
        {
            session.put("items", null);
            session.put("orderID", null);
            session.put("order", null);
            session.put("check", null);
            session.put("safe", null);

            return String.valueOf(session.get("rank"));
        }else{
            if(pickingDao.updatePickedPallete(Integer.parseInt(orderID), String.valueOf(session.get("safe"))))
                return INPUT;
            
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
