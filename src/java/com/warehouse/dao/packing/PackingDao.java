/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPacked;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.utility.HibernateUtil;
import com.warehouse.utility.Validate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
public class PackingDao {
    public String getProducts(final int id){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from PalletsPicked p where p.id=:id";
            Query query = session.createQuery(sql);
            query.setParameter("id", id);
            List<PalletsPicked> list = query.list();

            if (list.size() > 0) {
                HibernateUtil.shutdown();
                return list.get(0).getProducts();
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return "error";
    }
    
    public boolean packButtonAction(final PalletsPicked palletsPicked, final PalleteInfo palleteInfo, Map<String, Object> session){
        boolean res = false;
        
        try{
            String products = null;
            String result = palleteInfo.getId() + "(" + palleteInfo.getAmount() + ")";
            String orderPhrase = (String) session.get("order");

            if((String) session.get("check") == null){
                session.put("items", getProducts(palletsPicked.getId()));
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
    
    public boolean createPackingPallete(final int id, final int workerID, final int clientID, final String products, final Date date, final String type){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            PalletsPacked palletsPacked = new PalletsPacked(id, workerID, clientID, products, date, type);
            session.save(palletsPacked);
            session.getTransaction().commit();

            HibernateUtil.shutdown();
            return true;
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return false;
    }
}
