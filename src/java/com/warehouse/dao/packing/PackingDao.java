/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPicked;
import com.warehouse.utility.HibernateUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pawel_000
 */
public class PackingDao {
    public String getProducts(int id){
        Session session = HibernateUtil.createSessionFactory().openSession();
        session.beginTransaction();
        
        String sql = " from PalletsPicked p where p.id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        List<PalletsPicked> list = query.list();
        
        HibernateUtil.shutdown();
        
        return list.get(0).getProducts();
    }
    
    public boolean packButtonAction(PalletsPicked palletsPicked, PalleteInfo palleteInfo, Map<String, Object> session){
        
        
        return true;
    }
}
