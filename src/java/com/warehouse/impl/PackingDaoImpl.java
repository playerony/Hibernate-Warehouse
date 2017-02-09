/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.packing.PackingDao;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPacked;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.service.PackingService;
import com.warehouse.utility.Validate;
import java.util.ArrayList;
import java.util.Date;
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
    public boolean packButtonAction(PalletsPicked palletsPicked, PalleteInfo palleteInfo, Map<String, Object> session) {
        boolean res = false;
        
        try{
            String products = null;
            String result = palleteInfo.getId() + "(" + palleteInfo.getAmount() + ")";
            String orderPhrase = (String) session.get("order");

            if((String) session.get("check") == null){
                session.put("items", getProducts(palletsPicked.getId()));
                session.put("safe", getProducts(palletsPicked.getId()));
                session.put("check", "true");
                session.put("orderID", palletsPicked.getId());
                products = getProducts(palletsPicked.getId());
            }else{
                products = (String) session.get("items");
            }

            if(products != null){
                ArrayList<PalleteInfo> palleteItems = Validate.getPalleteInformations((String) session.get("items"));

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

                        String phr = "";
                        phr = palleteItems.stream().filter((p) -> (p != null)).map((p) -> (p.getId() + "(" + p.getAmount() + ")" + ",")).reduce(phr, String::concat);   
                        session.put("items", phr);

                        if(orderPhrase != null)
                            session.put("order", orderPhrase + "," + result);
                        else
                            session.put("order", result);

                        System.out.print(session.get("items"));
                        System.out.print(session.get("order"));

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
        return PackingService.list(sessionFactory).get(id).getProducts();
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
