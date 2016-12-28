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
    private Map<String, Object> session;
    
    @Override
    public void validate() {
        if (user.getLogin().length() == (0)) {
            addActionError("Login is required!");
        }
        
        if (user.getPassword().length() == (0)) {
            addActionError("Password is required!");
        }
        
        if (!userDao.find(user.getLogin(), user.getPassword())) {
            addActionError("Wrong login or password!");
        }
    }
 
    @Override
    public String execute() {
        String rank = userDao.getUserRank(user.getLogin(), user.getPassword());

        session.put("userID", userDao.getUserID(user.getLogin(), user.getPassword()));
        session.put("rank", rank);
        
        // Reset cache values
        session.put("items", null);
        session.put("orderID", null);
        session.put("order", null);
        session.put("check", null);
        session.put("safe", null);

        if(!session.get("userID").equals("error"))
            return rank;
        else
            return "error";
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
         this.session = map;
    }
}
