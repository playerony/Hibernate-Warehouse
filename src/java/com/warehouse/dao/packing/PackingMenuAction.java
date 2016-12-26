/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

/**
 *
 * @author pawel_000
 */
public class PackingMenuAction extends AbstractPackingAction{

    @Override
    public void validate() {
        if(String.valueOf(palletsPicked.getId()) == null) {
            this.addActionError("It's not a number!");
        }
        
        if(palletsPicked.getId() <= (0)) {
            this.addActionError("Wrong number");
        }
    }

    @Override
    public String execute() {
        
        
        return SUCCESS;
    }
    
}
