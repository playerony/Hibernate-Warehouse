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
            addActionError("Firstname is required!");
        }
        
        if (!Validate.checkNumbersInString(user.getFirstname())) {
            addActionError("Wrong firstname");
        }
        
        if (user.getLastname().length() == (0)) {
            addActionError("Lastname is required!");
        }
        
        if (!Validate.checkNumbersInString(user.getLastname())) {
            addActionError("Wrong lastname!");
        }
    }

    @Override
    public String execute() {
        if(userDao.deleteWorker(user.getFirstname(), user.getLastname()))
            return SUCCESS;
        
        return INPUT;
    }
    
}
