/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao;

import com.opensymphony.xwork2.ActionSupport;
import com.warehouse.entity.User;

/**
 *
 * @author pawel_000
 */
public class LoginAction extends ActionSupport{
    private static final long serialVersionUID = 1L;    
    UserDao dao = new UserDao();
    User user;
 
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
            return SUCCESS;
        } else {
            this.addActionError("Invalid username and password");
        }
        return INPUT;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(final User user) {
        this.user = user;
    } 
}
