/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.picking.MagazineDao;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;
import com.warehouse.service.MagazineService;
import com.warehouse.utility.Validate;
import java.util.ArrayList;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class MagazineDaoImpl implements MagazineDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public boolean checkLocation(String location) {
        for(PalletsInMagazine p : MagazineService.list(sessionFactory)){
            if(p.getLocation().equals(location))
                return true;
        }
        
        return false;
    }

    @Override
    public String getProductsByLocation(String location) {
        for(PalletsInMagazine p : MagazineService.list(sessionFactory)){
            if(p.getLocation().equals(location))
                return p.getProducts();
        }
        
        return "error";
    }

    @Override
    public boolean verifyILocationByItems(String products, PalleteInfo palleteInfo) {
        ArrayList<PalleteInfo> palleteItems = Validate.getPalleteInformations(products);
        for(PalleteInfo p : palleteItems)
                if(palleteInfo.getId() == p.getId() && palleteInfo.getAmount() <= p.getAmount()){
                    return true;
                }
        
        return false;
    }

    @Override
    public boolean updateLoctionItems(String location, String items) {
        try{
            MagazineService.update(new PalletsInMagazine(location, items), sessionFactory);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
}
