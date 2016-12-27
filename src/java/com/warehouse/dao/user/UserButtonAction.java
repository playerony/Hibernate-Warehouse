/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.user;

/**
 *
 * @author pawel_000
 */
public class UserButtonAction extends AbstractUserAction{

    @Override
    public void validate() {
        
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
    
    public String backButtonAction(){
        return "admin";
    }
}
