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
public class LoginAction extends AbstractUserAction implements SessionAware {
    private String rank;
    private Map<String, Object> session;
    
    @Override
    public void validate() {
        if (user.getLogin().length() == (0)) {
            this.addFieldError("user.login", "Name is required");
        }
        
        if (user.getPassword().length() == (0)) {
            this.addFieldError("user.password", "Password is required");
        }
    }
 
    @Override
    public String execute() {
        if (dao.find(user.getLogin(), user.getPassword())) {
            String rank = dao.getUserRank(user.getLogin(), user.getPassword());
            
            session.put("userID", dao.getUserID(user.getLogin(), user.getPassword()));
            session.put("rank", rank);
          
            return rank;
        } else {
            this.addActionError("Invalid username and password");
        }
        return INPUT;
    }

    public String getRank() {
        return rank;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSession(Map<String, Object> map) {
         this.session = map;
    }
}
