/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.other.Validate;

/**
 *
 * @author pawel_000
 */
public class CheckOrderNumber extends AbstractPickingAction{

    @Override
    public void validate() {
        if(String.valueOf(order.getId()) == null) {
            this.addActionError("It's not a number!");
        }
    }

    @Override
    public String execute() {
        if(orderDao.checkOrderById(order.getId()))
            return SUCCESS;
        else{
            this.addActionError("I can't find this id");
            return INPUT;
        }
    }
    
}
