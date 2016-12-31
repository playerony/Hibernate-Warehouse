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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class PickingDao {
    public boolean nextItemButtonAction(final PalleteInfo palleteInfo, final PalletsInMagazine palletsInMagazine, Map<String, Object> session){
        MagazineDao magazineDao = new MagazineDao();
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

                if(orderPhrase != null)
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
    
    public boolean createPickingPallete(final int id, final int workerID, final int clientID, final String products){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            PalletsPicked palletsPicked = new PalletsPicked(id, workerID, clientID, products);
            session.save(palletsPicked);
            session.getTransaction().commit();

            HibernateUtil.shutdown();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public String getClientID(final int orderID){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from PalletsPicked p where p.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("id", orderID);
            List<PalletsPicked> list = query.list();

            if(list.size() > 0){
                HibernateUtil.shutdown();
                return String.valueOf(list.get(0).getClientID());
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return "error";
    }
    
    public boolean updatePickedPallete(final int id, final String phrase){
        boolean result = false;
        
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String sql = " update PalletsPicked p set p.products=:value where p.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("value", phrase);
            query.setParameter("id", id);

            int value = query.executeUpdate();
            if(value==0)
                    result = false;
                else
                    result = true;

            tx.commit();

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public boolean deletePickedPallete(final int id){
        boolean result = false;
        
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();
            String sql = " delete PalletsPicked where id=:value";
            Query query = session.createQuery(sql);
            query.setParameter("value", id);
            int value = query.executeUpdate();

            if(value==0)
                result = false;
            else
                result = true;

            session.getTransaction().commit(); 
            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return result;
    }
}
