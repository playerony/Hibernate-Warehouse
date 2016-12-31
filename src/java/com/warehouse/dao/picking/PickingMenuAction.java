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
public class PickingMenuAction extends AbstractPickingAction implements SessionAware {
    private Map<String, Object> session;

    @Override
    public void validate() {
        if(String.valueOf(palleteInfo.getId()).equals("0")){
            addActionError("ID is not a number");
        }
        
        if(palleteInfo.getId() < 0) {
            addActionError("Wrong ID");
        }
        
        if(String.valueOf(palleteInfo.getAmount()).equals("0")){
            addActionError("Amount is not a number");
        }
        
        if(palleteInfo.getAmount() < 0) {
            addActionError("Wrong amount");
        }
        
        if(palletsInMagazine.getLocation().length() <= (0)){
            addActionError("Wrong location");
        }
        
        if(!magazineDao.checkLocation(palletsInMagazine.getLocation())){
            addActionError("Can't find this location");
        }
        
        String value = magazineDao.getProductsByLocation(palletsInMagazine.getLocation());
        
        if(!magazineDao.verifyILocationByItems(value, palleteInfo)){
            addActionError("Too low product by location");
        }
    }

    @Override
    public String execute() {
        if(pickingDao.nextItemButtonAction(palleteInfo, palletsInMagazine, session)){
            return SUCCESS;
        }else{
            addActionError("Some problems by adding next item!");
            
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
