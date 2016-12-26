/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pawel_000
 */
public class PackingMenuAction extends AbstractPackingAction implements SessionAware{
    private Map<String, Object> session;

    @Override
    public void validate() {
        if(String.valueOf(palletsPicked.getId()) == null) {
            this.addActionError("It's not a number!");
        }
        
        if(palletsPicked.getId() <= (0)) {
            this.addActionError("Wrong number");
        }
    }

    @Override
    public String execute() {
        if(packingDao.packButtonAction()){
            return SUCCESS;
        }else{
            this.addActionError("Some problems by packing item!");
            
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
