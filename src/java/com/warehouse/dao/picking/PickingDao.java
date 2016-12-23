/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;

/**
 *
 * @author pawel_000
 */
public class PickingDao {
    private OrderDao orderDao;
    
    public PickingDao(){
        orderDao = new OrderDao();
    }
    
    public boolean nextItemButtonAction(PalleteInfo palleteInfo, PalletsInMagazine palletsInMagazine){
        if(orderDao.checkOrderMaterial(palleteInfo)){
            
        }else
            return false;
        
        return true;
    }
    
    public boolean finishButtonAction(){
        
        
        return true;
    }
}
