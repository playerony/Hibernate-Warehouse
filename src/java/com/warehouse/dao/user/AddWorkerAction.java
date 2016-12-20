/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.warehouse.other.Validate;

/**
 *
 * @author pawel_000
 */
public class AddWorkerAction extends AbstractAction {
    @Override
     public void validate() {
        if (user.getLogin().length() == (0)) {
            this.addFieldError("user.login", "Name is required");
        }
        
        if (user.getPassword().length() == (0)) {
            this.addFieldError("user.password", "Password is required");
        }
        
        if (user.getFirstname().length() == (0)) {
            this.addFieldError("user.firstname", "Firstname is required");
        }
        
        if (!Validate.checkNumbersInString(user.getFirstname())) {
            this.addFieldError("user.firstname", "Wrong firstname");
        }
        
        if (user.getLastname().length() == (0)) {
            this.addFieldError("user.lastname", "Lastname is required");
        }
        
        if (!Validate.checkNumbersInString(user.getLastname())) {
            this.addFieldError("user.lastname", "Wrong lastname");
        }
    }
     
    @Override
    public String execute() {
        dao.addWorker(user.getId(), user.getFirstname(), 
                                    user.getLastname(), user.getLogin(), 
                                    user.getPassword(), user.getPlace(), 
                                    user.getRank());
        
        return SUCCESS;
    }
}
