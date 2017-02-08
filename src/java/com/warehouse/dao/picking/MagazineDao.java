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
public interface MagazineDao {
    public boolean checkLocation(String location);
    
    public String getProductsByLocation(String location);
    
    public boolean verifyILocationByItems(String products, PalleteInfo palleteInfo);
    
    public boolean updateLoctionItems(String location, String items);
}
