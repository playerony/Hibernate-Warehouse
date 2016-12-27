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
public class AddWorkerAction extends AbstractUserAction {
    @Override
     public void validate() {
        if (user.getLogin().length() == (0)) {
            addActionError("Login is required");
        }
        
        if (user.getLogin().length() > (10)) {
            addActionError("Login is too long");
        }
        
        if (user.getPassword().length() == (0)) {
            addActionError("Password is required");
        }
        
        if (user.getPassword().length() > (10)) {
            addActionError("Password is too long");
        }
        
        if (user.getFirstname().length() == (0)) {
            addActionError("Firstname is required");
        }
        
        if (!Validate.checkNumbersInString(user.getFirstname())) {
            addActionError("Firstname has wrong marks");
        }
        
         if (user.getLastname().length() == (0)) {
            addActionError("Lastname is required");
        }
        
        if (!Validate.checkNumbersInString(user.getLastname())) {
            addActionError("Lastname has wrong marks");
        }
        
        if(user.getLastname().equals(user.getFirstname())){
            addActionError("Firstname = Lastname");
        }
        
        if (userDao.findUserByLogin(user.getLogin())) {
            addActionError("This login exist in database!!!");
        }
    }
     
    @Override
    public String execute() {
        if(userDao.addWorker(user.getId(), user.getFirstname(), user.getLastname(), 
                                          user.getLogin(), user.getPassword(), user.getPlace(),  user.getRank()))
            return SUCCESS;
        return INPUT;
    }
}
