/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.utility.HibernateUtil;
import com.warehouse.utility.Validate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pawel_000
 */
public class MagazineDao {
    
    public boolean checkLocation(final String location){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from PalletsInMagazine p where p.location=:locate";
            Query query = session.createQuery(sql);
            query.setParameter("locate", location);
            List<PalletsPicked> list = query.list();

            if(list.size() > 0){
                HibernateUtil.shutdown();
                return true;
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public String getProductsByLocation(final String location){
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            session.beginTransaction();

            String sql = " from PalletsInMagazine p where p.location=:locate";
            Query query = session.createQuery(sql);
            query.setParameter("locate", location);
            List<PalletsInMagazine> list = query.list();

            if(list.size() > 0){
                HibernateUtil.shutdown();
                return String.valueOf(list.get(0).getProducts());
            }

            HibernateUtil.shutdown();
        }catch(HibernateException e){
            e.printStackTrace();
        }
        
        return "error";
    }
    
    public boolean verifyILocationByItems(final String products, final PalleteInfo palleteInfo){
        ArrayList<PalleteInfo> palleteItems = Validate.getPalleteInformations(products);
        for(PalleteInfo p : palleteItems)
                if(palleteInfo.getId() == p.getId() && palleteInfo.getAmount() <= p.getAmount()){
                    return true;
                }
        
        return false;
    }
    
    public boolean updateLoctionItems(final String location, final String items){
        boolean result = false;
        
        try{
            Session session = HibernateUtil.createSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            String sql = " update PalletsInMagazine p set p.products=:products where p.location=:location";
            Query query = session.createQuery(sql);
            query.setParameter("location", location);
            query.setParameter("products", items);

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
}
