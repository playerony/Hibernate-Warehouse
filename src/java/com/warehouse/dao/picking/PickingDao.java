/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.PalleteInfo;
import com.warehouse.entity.PalletsInMagazine;
import com.warehouse.entity.PalletsPicked;
import java.util.Map;

/**
 *
 * @author pawel_000
 */
public interface PickingDao {
    public boolean nextItemButtonAction(final PalleteInfo palleteInfo, final PalletsInMagazine palletsInMagazine, Map<String, Object> session);
    
    public boolean createPickingPallete(PalletsPicked palletsPicked);
    
    public String getClientID(int orderID);
    
    public boolean updatePickedPallete(int id, String phrase);
    
    public boolean deletePickedPallete(int id);
}
