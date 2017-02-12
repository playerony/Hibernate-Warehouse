/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.packing.PackingDao;
import com.warehouse.dao.picking.PickingDao;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPacked;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.service.PackingService;
import com.warehouse.utility.Validate;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class PackingDaoImpl implements PackingDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean packButtonAction(PalletsPicked palletsPicked, PalleteInfo palleteInfo, PickingDao pickingDao, Map<String, Object> session) {
        boolean res = false;
        
        try{
            String products = null;
            String result = palleteInfo.getId() + "(" + palleteInfo.getAmount() + ")";
            String orderPhrase = String.valueOf(session.get("order"));
            
            if(!String.valueOf(session.get("check")).isEmpty()){
                session.put("items", pickingDao.getProducts(palletsPicked.getId()));
                session.put("safe", pickingDao.getProducts(palletsPicked.getId()));
                session.put("check", "true");
                session.put("orderID", palletsPicked.getId());
                products = pickingDao.getProducts(palletsPicked.getId());
            }else
                products = String.valueOf(session.get("items"));

            if(!products.isEmpty()){
                ArrayList<PalleteInfo> palleteItems = Validate.getPalleteInformations(products);

                PalleteInfo pal = null;
                for(PalleteInfo p : palleteItems)
                    if(palleteInfo.getId() == p.getId()){
                        pal = p;
                        break;
                    }
                
                    if(pal != null){
                        int value = pal.getAmount() - palleteInfo.getAmount();
                        pal.setAmount(value);

                        if(value <= 0)
                            palleteItems.remove(pal);

                        String phr = null;
                        phr = palleteItems.stream().filter((p) -> (p != null)).map((p) -> (p.getId() + "(" + p.getAmount() + ")" + ",")).reduce(phr, String::concat);   
                        session.put("items", phr);

                        if(!orderPhrase.isEmpty())
                            session.put("order", orderPhrase + "," + result);
                        else
                            session.put("order", result);

                            res = true;
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        
        return res;
    }

    @Override
    public String getProducts(int id) {
        for(PalletsPacked p : PackingService.list(sessionFactory))
            if(p.getId() == id)
                return p.getProducts();
        
        return null;
    }

    @Override
    public boolean createPackingPallete(PalletsPacked palletsPacked) {
        try{
            PackingService.insert(palletsPacked, sessionFactory);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
    
}
