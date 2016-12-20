/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.warehouse.cookie.SessionManager;

/**
 *
 * @author pawel_000
 */
public class LoginAction extends AbstractAction{
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
            
            SessionManager.createCookie("login", user.getLogin());
            SessionManager.createCookie("rank", rank);
          
            return rank;
        } else {
            this.addActionError("Invalid username and password");
        }
        return INPUT;
    }
}
