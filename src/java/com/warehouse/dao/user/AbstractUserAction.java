/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.opensymphony.xwork2.ActionSupport;
import com.warehouse.entity.User;
import com.warehouse.impl.UserDaoImpl;

/**
 *
 * @author pawel_000
 */
public abstract class AbstractUserAction extends ActionSupport {
    protected static final long serialVersionUID = 1L;    
    protected UserDao userDao = new UserDaoImpl();
    protected User user;
    
    @Override
     public abstract void validate();
     @Override
     public abstract String execute();
     
     public User getUser() {
        return user;
    }
 
    public void setUser(final User user) {
        this.user = user;
    } 
}
