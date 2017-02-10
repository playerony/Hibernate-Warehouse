/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.packing;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsPacked;
import com.warehouse.entity.PalletsPicked;
import java.util.Map;

/**
 *
 * @author pawel_000
 */
public interface PackingDao {
    public boolean packButtonAction(PalletsPicked palletsPicked, PalleteInfo palleteInfo, Map<String, Object> session);
    
    public String getProducts(int id);
    
    public boolean createPackingPallete(PalletsPacked palletsPacked);
}
