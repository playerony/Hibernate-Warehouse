/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

/**
 *
 * @author pawel_000
 */
public class PickingMenuAction extends AbstractPickingAction {
    private PickingDao pickingDao = new PickingDao();

    @Override
    public void validate() {
        if(String.valueOf(palleteInfo.getId()) == null){
            this.addFieldError("palleteInfo.id", "It's not a number");
        }
        
        if(String.valueOf(palleteInfo.getAmount()) == null){
            this.addFieldError("palleteInfo.amount", "It's not a number");
        }
        
        if(palletsInMagazine.getLocation().length() == (0)){
            this.addFieldError("palletsInMagazine.location", "Wrong location");
        }
    }

    @Override
    public String execute() {
        if(pickingDao.nextItemButtonAction(palleteInfo, palletsInMagazine))
            return SUCCESS;
        else{
            this.addActionError("Some problems by adding next item!");
            
            return INPUT;
        }
    }
}
