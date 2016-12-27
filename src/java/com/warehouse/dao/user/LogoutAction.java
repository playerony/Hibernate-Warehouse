/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author pawel_000
 */
public class LogoutAction extends AbstractUserAction implements SessionAware{
    private Map<String, Object> session;

    @Override
    public void validate() {
        
    }

    @Override
    public String execute() {
        session.clear();
        
        return SUCCESS;
    }
    
    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
}
