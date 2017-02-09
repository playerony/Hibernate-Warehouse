/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

import com.opensymphony.xwork2.ActionSupport;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.impl.PackingDaoImpl;

/**
 *
 * @author pawel_000
 */
public abstract class AbstractPackingAction extends ActionSupport{
    protected PalletsPicked palletsPicked;
    protected PalleteInfo palleteInfo;
    protected PackingDao packingDao = new PackingDaoImpl();
    
    @Override
     public abstract void validate();
     @Override
     public abstract String execute();

    public PalletsPicked getPalletsPicked() {
        return palletsPicked;
    }

    public void setPalletsPicked(PalletsPicked palletsPicked) {
        this.palletsPicked = palletsPicked;
    }

    public PalleteInfo getPalleteInfo() {
        return palleteInfo;
    }

    public void setPalleteInfo(PalleteInfo palleteInfo) {
        this.palleteInfo = palleteInfo;
    }
}
