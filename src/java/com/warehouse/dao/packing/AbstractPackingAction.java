/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

import com.opensymphony.xwork2.ActionSupport;
import com.warehouse.dao.picking.PickingDao;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.impl.PackingDaoImpl;
import com.warehouse.impl.PickingDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author pawel_000
 */
public abstract class AbstractPackingAction extends ActionSupport{
    protected PalletsPicked palletsPicked;
    protected PalleteInfo palleteInfo;
    protected PackingDao packingDao;
    protected PickingDao pickingDao;
    
    public AbstractPackingAction(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        packingDao = context.getBean("packingDao", PackingDaoImpl.class);
        pickingDao = context.getBean("pickingDao", PickingDaoImpl.class);
    }
    
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
