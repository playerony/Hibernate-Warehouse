/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.impl;

import com.warehouse.dao.picking.MagazineDao;
import com.warehouse.dao.picking.PickingDao;
import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.service.PickingService;
import com.warehouse.utility.Validate;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.SessionFactory;

/**
 *
 * @author pawel_000
 */
public class PickingDaoImpl implements PickingDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean nextItemButtonAction(PalleteInfo palleteInfo, PalletsInMagazine palletsInMagazine, MagazineDao magazineDao, Map<String, Object> session) {
        boolean res = false;
        
        try{
            String result = palleteInfo.getId() + "(" + palleteInfo.getAmount() + ")";
            String phrase = (String) session.get("items");
            String orderPhrase = (String) session.get("order");

            ArrayList<PalleteInfo> palleteItems = Validate.getPalleteInformations(phrase);

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

                if(!orderPhrase.isEmpty())
                    session.put("order", orderPhrase + "," + result);
                else
                    session.put("order", result);
                
                String val = magazineDao.getProductsByLocation(palletsInMagazine.getLocation());
                ArrayList<PalleteInfo> locationItems = Validate.getPalleteInformations(val);
                phrase = String.valueOf(locationItems.get(0).getId()) + "(" + String.valueOf(locationItems.get(0).getAmount() - palleteInfo.getAmount()) + ")";
                
                magazineDao.updateLoctionItems(palletsInMagazine.getLocation(),  phrase);

                res = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return res;
    }

    @Override
    public boolean createPickingPallete(PalletsPicked palletsPicked) {
        try{
            PickingService.insert(palletsPicked, sessionFactory);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }

    @Override
    public String getClientID(int id) {
        for(PalletsPicked p : PickingService.list(sessionFactory))
            if(p.getId() == id)
                return String.valueOf(p.getClientID());
        
        return "error";
    }

    @Override
    public boolean updatePickedPallete(int id, String phrase) {
        for(PalletsPicked p : PickingService.list(sessionFactory))
            if(p.getId() == id){
                p.setProducts(phrase);
                PickingService.update(p, sessionFactory);
                
                return true;
            }
        
        return false;
    }

    @Override
    public boolean deletePickedPallete(int id) {
        for(PalletsPicked p : PickingService.list(sessionFactory))
            if(p.getId() == id){
                PickingService.delete(p, sessionFactory);
                return true;
            }
        
        return false;
    }
    
    @Override
    public String getProducts(int id){
        for(PalletsPicked p : PickingService.list(sessionFactory))
            if(p.getId() == id)
                return p.getProducts();
        
        return null;
    }
}
