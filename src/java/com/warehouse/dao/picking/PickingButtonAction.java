/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author pawel_000
 */
public class PickingButtonAction extends ActionSupport {
    @Override
    public void validate() {
        
    }
    
    public String finishButtonAction(){
        System.out.print("Finish");
        
        return "admin";
    }
    
    public String backButtonAction(){
        System.out.print("Back");
        
        return "admin";
    }
}
