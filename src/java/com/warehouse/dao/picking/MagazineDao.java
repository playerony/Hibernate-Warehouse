/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warehouse.dao.picking;

import com.warehouse.entity.PalleteInfo;

/**
 *
 * @author pawel_000
 */
public interface MagazineDao {
    public boolean checkLocation(String location);
    
    public boolean verifyILocationByItems(String products, PalleteInfo palleteInfo);
    
    public boolean updateLoctionItems(String location, String items);
    
    public String getProductsByLocation(String location);
}
