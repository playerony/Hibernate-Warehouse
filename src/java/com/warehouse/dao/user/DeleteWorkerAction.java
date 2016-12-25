/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

import com.warehouse.utility.Validate;

/**
 *
 * @author pawel_000
 */
public class DeleteWorkerAction extends AbstractUserAction {

    @Override
    public void validate() {
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
        dao.deleteWorker(user.getFirstname(), user.getLastname());
        
        return SUCCESS;
    }
    
}
