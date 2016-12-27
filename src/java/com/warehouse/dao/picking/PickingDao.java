/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.utility.Validate;
import com.warehouse.utility.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
public class PickingDao {
    public boolean nextItemButtonAction(PalleteInfo palleteInfo, PalletsInMagazine palletsInMagazine, Map<String, Object> session){
        boolean res = false;
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
		    	
            if(value < 0)
                palleteItems.remove(pal);
            
            String phr = "";
            phr = palleteItems.stream().filter((p) -> (p != null)).map((p) -> (p.getId() + "(" + p.getAmount() + ")" + ",")).reduce(phr, String::concat);   
            session.put("items", phr);
		    	
            if(orderPhrase != null)
                session.put("order", orderPhrase + "," + result);
            else
                session.put("order", result);
		    	
            res = true;
        }
        
        return res;
    }
    
    public boolean createPickingPallete(int id, int workerID, int clientID, String products){
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        
        PalletsPicked palletsPicked = new PalletsPicked(id, workerID, clientID, products);
        session.save(palletsPicked);
        session.getTransaction().commit();
        
        HibernateUtil.shutdown();
        
        return true;
    }
    
    public String getClientID(int orderID){
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        
        String sql = " from PalletsPicked p where p..id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", orderID);
        List<PalletsPicked> list = query.list();
        
        HibernateUtil.shutdown();
        
        return String.valueOf(list.get(0).getClientID());
    }
}
