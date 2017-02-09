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
public interface PackingDao {
    public boolean packButtonAction(PalletsPicked palletsPicked, PalleteInfo palleteInfo, Map<String, Object> session);
    
    public String getProducts(int id);
    
    public boolean createPackingPallete(PalletsPacked palletsPacked);
}
